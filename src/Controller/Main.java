package Controller;

import java.io.File;
import java.util.Collection;
import Utils.Serialiser;
import asg.cliche.Command;
import asg.cliche.Param;
import Controller.MovieRecommenderAPI;
import Model.Movie;
import Model.User;
import Utils.XMLSerializer;

public class Main {
	
	public MovieRecommenderAPI movieRecommender;
	
	public Main() throws Exception {
	File datastore= new File("datastore.xml");
	  Serialiser serialiser = new XMLSerializer(datastore);
	  
	  movieRecommender = new MovieRecommenderAPI(serialiser);
	  if (datastore.isFile())
	  {
		  movieRecommender.load();
	  }
	  else 
	  {
	 movieRecommender.prime();
	 } 
	}
	public static void main( String [] args) throws Exception {

	}
		
	@Command(description = "Add a new User")
	public void createUser(@Param(name = "First Name") String firstName,
		@Param(name= "Last Name") String lastName,
		@Param(name = "Age") int age,
		@Param(name= "Gender") String gender,
		@Param(name= "Occupation") String occupation) {
		movieRecommender.addUser(firstName, lastName, age, gender, occupation);
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
		@Param(name = "year") int year, 
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
}
