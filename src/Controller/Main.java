package Controller;

import java.io.File;
import java.io.IOException;

import Utils.Serialiser;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import Controller.MovieRecommenderAPI;
import Model.Movie;
import Model.User;
import Utils.XMLSerializer;

public class Main implements ShellDependent {
	  
	private static final String ADMIN = "admin";
	public MovieRecommenderAPI movieRecommender;
	private Shell theShell;
	
	public Main() throws Exception {
	File datastore= new File("bigdatastore.xml");
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
	
	public void cliSetShell(Shell theShell)
    {
        this.theShell = theShell;
    }
	
	@Command(description = "Log in")
	  public void logIn(
			  @Param(name = "user name") String username, 
			  @Param(name = "password") String password)
	      throws IOException {

	    if (movieRecommender.login(username, password) && movieRecommender.currentUser.isPresent()) {
	      User user = movieRecommender.currentUser.get();
	      System.out.println("You are logged in as " + user.userName);
	      if (user.role!=null && user.role.equals(ADMIN)) {
	        AdminMenu adminMenu = new AdminMenu(movieRecommender, user.userName);
	        ShellFactory.createSubshell(user.userName, theShell, "Admin", adminMenu).commandLoop();
	      } else {
	        DefaultMenu defaultMenu = new DefaultMenu(movieRecommender, user);
	        ShellFactory.createSubshell(user.userName, theShell, "Default", defaultMenu).commandLoop();
	      }
	    } else
	      System.out.println("Unknown username/password.");
	  } 
	
	@Command(description = "Add a new User")
	public void createUser(@Param(name = "First Name") String firstName,
		@Param(name= "Last Name") String lastName,
		@Param(name = "Age") int age,
		@Param(name= "Gender") String gender,
		@Param(name= "Occupation") String occupation,
		@Param(name= "Username") String userName,	
		@Param(name= "Password") String password,
		@Param(name= "role") String role){
		movieRecommender.addUser(firstName, lastName, age, gender, occupation, userName, password, role);
	}
	
	@Command(description="Search Movie")
	  public void getMovie (@Param(name="title") String title)
	  {
		 Movie movie = movieRecommender.getMoviesByTitle(title);
		 if(movie != null) {
			 System.out.println(movie);
		 } 
	  }
	
	public static void main( String [] args) throws Exception {
		Main main = new Main();
		ShellFactory.createConsoleShell("Command", "MovieRecommender", main).commandLoop();
		
		main.movieRecommender.store();
	}
		
	/*@Command(description = "Add a new User")
	public void createUser(@Param(name = "First Name") String firstName,
		@Param(name= "Last Name") String lastName,
		@Param(name = "Age") int age,
		@Param(name= "Gender") String gender,
		@Param(name= "Occupation") String occupation,
		@Param(name= "Username") String userName,	
		@Param(name= "Password") String password){
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
		@Param(name = "URL") String URL) {
		movieRecommender.addMovie(title, year, URL);
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
	
	@Command(description="Search Movie")
	  public void getMovie (@Param(name="title") String title)
	  {
		 Movie movie = movieRecommender.getMoviesByTitle(title);
		 if(movie != null) {
			 System.out.println(movie);
		 } 
	  }
	
	@Command(description="Add Movie Rating")
	public void addRating(
			@Param(name="user") Long UserID,
			@Param(name="movie") Long MovieID,
			@Param(name="rating") int rating {
		movieRecommender.addRating(UserID, MovieID, rating);
	}
	
*/
}
