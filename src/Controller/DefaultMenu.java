package Controller;

import java.util.Collection;

import asg.cliche.Command;
import asg.cliche.Param;
import Model.Movie;
import Model.User;

public class DefaultMenu {
	private String name;
	private User user;
	private MovieRecommenderAPI movieRecommender;
	
	public DefaultMenu(MovieRecommenderAPI movieRecommender, User user)
	{
		this.movieRecommender = movieRecommender;
		this.setName(user.firstName);
		this.setUser(user);
	}
	
	@Command(description = "Display Users")
	public void getUser() {
		Collection<User> users = movieRecommender.getUsers();
		System.out.println(users);
	}
	
	@Command(description = "Display Movies")
	public void getMovie() {
		Collection<Movie> movies = movieRecommender.getMovies();
		System.out.println(movies);
	}
	
	@Command(description="add a rating")
	public void addRating(
			@Param(name="user") Long UserID,
			@Param(name="movie") Long MovieID,
			@Param(name="rating") int rating){
		movieRecommender.addRating(UserID, MovieID, rating);
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
