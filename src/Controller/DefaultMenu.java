package Controller;

import java.util.Collection;

import asg.cliche.Command;
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
		this.user = user;
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
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
