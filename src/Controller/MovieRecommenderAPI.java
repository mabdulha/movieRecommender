package Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import Utils.CSVLoader;
import Model.Rating;
import Model.User;
import Model.Movie;
import Utils.Serialiser;

public class MovieRecommenderAPI {
	private Serialiser serialiser;
	
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	
	private Map<String, Rating> ratingIndex = new HashMap<>();
	
	
	
	public MovieRecommenderAPI()
	{
	}
		
	
	public MovieRecommenderAPI(Serialiser serialiser)
	{
		this.serialiser = serialiser;
	}
	
	public void prime() throws Exception {
		CSVLoader loader = new CSVLoader();
		
		List<User> users = loader.parseUsers("data/moviedata_small/users5.dat");
		for (User user : users) {
			userIndex.put(user.userId, user);
		}

		List<Movie> movies = loader.parseMovies("data/moviedata_small/items5.dat");
		for (Movie movie : movies) {
			movieIndex.put(movie.movieId, movie);
		}
	}

		
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serialiser.read();
		userIndex = (Map<Long, User>) serialiser.pop();
		movieIndex = (Map<Long, Movie>) serialiser.pop();
		ratingIndex = (Map<String, Rating>) serialiser.pop();
	}
	
	public void store() throws Exception 
	{
		serialiser.push(userIndex);
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
	
	public User addUser(String firstName, String lastName, int age, String gender, String occupation) 
	{
		//This method allows us to make a new user
		User user = new User(firstName,lastName,age,gender,occupation);
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
	
	public Movie addMovie(String title, int year, String URL)
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
		Rating thisRating = new Rating(userId, movieId, rating);
		String joinedIds = userId.toString() + ' ' + movieId.toString();
		ratingIndex.put(joinedIds, thisRating);
		
		User thisUser = getUser(userId);
		thisUser.ratings.add(thisRating);
		
		Movie thisMovie = getMovie(movieId);
		thisMovie.ratings.add(thisRating);
		
		return thisRating;
	}
	
	public Rating getUserRatings(Long userId)
	{
		return ratingIndex.get(userId);
	}
}