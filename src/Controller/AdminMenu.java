package Controller;

import java.util.Collection;

import asg.cliche.Command;
import asg.cliche.Param;
import Model.Movie;
import Model.User;

public class AdminMenu {
	private String userName;
	private MovieRecommenderAPI movieRecommender;
	
	public AdminMenu(MovieRecommenderAPI movieRecommender, String userName)
	{
		this.movieRecommender = movieRecommender;
		this.setName(userName);
	}
	
	  
	@Command(description = "Add a new User")
	public void createUser(@Param(name = "First Name") String firstName,
		@Param(name= "Last Name") String lastName,
		@Param(name = "Age") int age,
		@Param(name= "Gender") String gender,
		@Param(name= "Occupation") String occupation,
		@Param(name="UserName") String userName,
		@Param(name="Password") String password) 
	{
		movieRecommender.addUser(firstName, lastName, age, gender, occupation, userName, password);
	}
	
	@Command(description = "Display Users")
	public void getUser() {
		Collection<User> users = movieRecommender.getUsers();
		System.out.println(users);
	}
	
	@Command(description = "Delete a User")
	public void deleteUser(@Param(name = "User Id") Long userId) {
		User user = movieRecommender.getUser(userId);
		movieRecommender.removeUser(user);
	}
	
	
	@Command(description = "Add Movie")
	public void addMovie(@Param(name = "title") String title,
		@Param(name = "year") String year, 
		@Param(name = "url") String url) {
		movieRecommender.addMovie(title, year, url);
	}
	
	@Command(description = "Display Movies")
	public void getMovie() {
		Collection<Movie> movies = movieRecommender.getMovies();
		System.out.println(movies);
	}
	
	@Command(description = "Delete a Movie")
	public void deleteMovie(@Param(name = "Movie Id") Long movieId) {
		Movie movie = movieRecommender.getMovie(movieId);
		movieRecommender.removeMovie(movie);
	}
	  
	  @Command(description="Add Rating")
		public void addRating(
				@Param(name="user") Long UserID,
				@Param(name="movie") Long MovieID,
				@Param(name="rating") int rating)
	  {
			movieRecommender.addRating(UserID, MovieID, rating);
		}
		
		@Command(description="Get User Ratings")
		public void getRating(
				@Param(name="id") Long UserID){
			movieRecommender.getUserRatings(UserID);
		}
	  
	  public String getName() 
		{
		    return userName;
		}
		  public void setName(String userName) 
		  {
		    this.userName = userName;
		  }

}
