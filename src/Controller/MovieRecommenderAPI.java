package Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.google.common.base.Optional;

import Utils.CSVLoader;
import Utils.FileLogger;
import Model.Rating;
import Model.User;
import Model.Movie;
import Utils.Serialiser;

public class MovieRecommenderAPI {
	private Serialiser serialiser;
	
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private Map<String, User> userLoginIndex = new HashMap<>(); 
	Optional<User> currentUser;
	
	private Map<Long, Rating> ratingIndex = new HashMap<>();
	
	
	
	public MovieRecommenderAPI()
	{
	}
		
	
	public MovieRecommenderAPI(Serialiser serialiser)
	{
		this.serialiser = serialiser;
	}
	
	public void prime() throws Exception {
		CSVLoader loader = new CSVLoader();
		
		List<User> users = loader.parseUsers("moviedata_small/users5.dat");
		for (User user : users) {
			userIndex.put(user.userId , user);
		}

		List<Movie> movies = loader.parseMovies("moviedata_small/items5.dat");
		for (Movie movie : movies) {
			movieIndex.put(movie.movieId, movie);
		}

		List<Rating> ratings = loader.parseRatings("moviedata_small/ratings5.dat");
		for (Rating rating : ratings) {
			ratingIndex.put(rating.userId, rating);
		}
	}

		
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serialiser.read();
		userIndex = (Map<Long, User>) serialiser.pop();
		movieIndex = (Map<Long, Movie>) serialiser.pop();
		ratingIndex = (Map<Long, Rating>) serialiser.pop();
		//userLoginIndex = (Map<String, User> serialiser.pop());
		User.counter = (Long) serialiser.pop();
		Movie.counter = (Long) serialiser.pop();
	}
	
	public void store() throws Exception 
	{
		serialiser.push(User.counter);
		serialiser.push(Movie.counter);
		serialiser.push(userIndex);
		serialiser.push(userLoginIndex);
		serialiser.push(movieIndex);
		serialiser.push(ratingIndex);
		serialiser.write();
	}
	
	public Collection<User> getUsers()
	{
		return userIndex.values();
	}
	
	public Collection<Movie> getMovies()
	{
		return movieIndex.values();
	}
	
	public Collection<Rating> getRatings()
	{
		return ratingIndex.values();
	}
	
	public User addUser(String firstName, String lastName, int age, String gender, String occupation, String userName, String password) 
	{
		User user = new User(firstName,lastName,age,gender,occupation, userName, password);
		userIndex.put(user.userId,user);
		return user;
	}
	
	public User getUser(Long id) {
		return userIndex.get(id);
	}
	
	public void removeUser(User user)
	{
	    userIndex.remove(user.userId);
	}
	
	public Movie addMovie(String title, String year, String URL)
	{
		Movie movie = new Movie(title, year, URL);
		movieIndex.put(movie.movieId,movie);
		return movie;
	}
	
	public Movie getMovie(Long movieId) 
	{
		return  movieIndex.get(movieId);
	}
	
	public Movie getMoviesByTitle(String title) 
	{
		return movieIndex.get(title);
	}
	
	public Movie getMoviesByYear(int year) 
	{
		return movieIndex.get(year);
	}
	
	public void removeMovie(Movie movie)
	{
		movieIndex.remove(movie.movieId);
	}
	
	public Rating addRating(Long userId, Long movieId, int rating)
	  {
		  Rating thisRating = null;
		    Optional<User> user = Optional.fromNullable(userIndex.get(userId));
		    if (user.isPresent())
		    {
		      thisRating = new Rating(userId, movieId, rating);
		      user.get().ratings.put(thisRating.userId, thisRating);
		      ratingIndex.put(thisRating.userId, thisRating);
		    }
		    return thisRating;
	  }
	
	public Rating getUserRatings(Long userId)
	{
		return ratingIndex.get(userId);
	}
	
	public boolean login(String username, String password) {
	    Optional<User> user = Optional.fromNullable(userLoginIndex.get(username));
	    if (user.isPresent() && user.get().password.equals(password)) {
	      currentUser = user;
	      FileLogger.getLogger().log(currentUser.get().userName + " logged in...");
	      return true;
	    }
	    return false;
	  }
	
	public void logout() {
	    Optional<User> user = currentUser;
	    if (user.isPresent()) {
	      FileLogger.getLogger().log(currentUser.get().firstName + " logged out...");
	      currentUser = Optional.absent();
	    }
	  }
}