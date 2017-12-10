package Controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Models.fixtures.users;
import static Models.fixtures.movies;
import static Models.fixtures.ratings;
import Controller.MovieRecommenderAPI;
import Model.Movie;
import Model.Rating;
import Model.User;

public class movieRecommenderAPITest {

	private MovieRecommenderAPI movieRecommender;
	
	@Before
	  public void setup()
	  {
		Model.User.counter = 0l;
		Model.Movie.counter = 0l;
		
	    movieRecommender = new MovieRecommenderAPI();
	    for (User user : users)
	    {
	      movieRecommender.addUser(user.firstName, user.lastName, user.age, user.gender, user.occupation, user.userName, user.password, user.role);
	    }
	    
	    for (Movie movie : movies)
	    {
	    	movieRecommender.addMovie(movie.title, movie.year, movie.URL);
	    }
	  }

	  @After
	  public void tearDown()
	  {
	    movieRecommender = null;
	  }
	
	@Test
	public void testUser() {
		assertEquals (users.length, movieRecommender.getUsers().size());
	    movieRecommender.addUser("marge", "simpsons", 32, "F", "Housewife", "marge", "secret", "default");
	    assertEquals (users.length+1, movieRecommender.getUsers().size());
	    assertEquals (users[0], movieRecommender.getUser(users[0].userId));
	}
	
	@Test
	public void testUsers() {
		assertEquals(users.length, movieRecommender.getUsers().size());
		for (User user : users) {
			User eachUser = movieRecommender.getUser(user.userId);
			assertNotSame(user, eachUser);
		}
	}
	
	@Test
	public void testRemoveUser() {
		assertEquals(users.length, movieRecommender.getUsers().size());
		User marge = movieRecommender.getUser(0l);
		movieRecommender.removeUser(marge);
		assertEquals(users.length - 1, movieRecommender.getUsers().size());
	}

	@Test
	public void testMovies() {
		assertEquals(movies.length, movieRecommender.getMovies().size());
		for (Movie movie : movies) {
			Movie eachMovie = movieRecommender.getMovie(movie.movieId);
			assertEquals(movie, eachMovie);
			assertNotSame(movie, eachMovie);
		}
	}
	
	@Test
	public void testGetMovieByTitle() {
		Movie eachMovie = movieRecommender.getMoviesByTitle("Gladiator");
		assertEquals(movies[1], eachMovie);
		assertNotSame(users[1], eachMovie);
		assertNotNull(eachMovie);
	}
	
	@Test
	public void testGetMovieByYear() {
		Movie eachMovie = movieRecommender.getMoviesByYear(2000);
		assertEquals(movies[1], eachMovie);
		assertNotSame(users[1], eachMovie);
		assertNotNull(eachMovie);
	}
	
	@Test
	public void testRating()
	{

		for (Rating rating : ratings)
		{
			movieRecommender.addRating(rating.userId, rating.movieId, rating.rating);
		}

		assertEquals (ratings.length, movieRecommender.getRatings().size());
		movieRecommender.addRating(Long.valueOf(2), Long.valueOf(2), -1);
		assertEquals (ratings.length, movieRecommender.getRatings().size());
	}
}