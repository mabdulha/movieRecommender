package Controller;

import Controller.MovieRecommenderAPI;
import static org.junit.Assert.*;

import java.io.File;

import Model.Movie;
import Model.Rating;
import Model.User;

import org.junit.Test;

import Utils.Serialiser;
import Utils.XMLSerializer;
import static Models.fixtures.users;
import static Models.fixtures.movies;
import static Models.fixtures.ratings;


public class PersistenceTest {
	MovieRecommenderAPI movieRecommender;

	void populate(MovieRecommenderAPI movieRecommender) {
		User.counter = 0l;
		Movie.counter = 0l;

		for (User user : users) {
			movieRecommender.addUser(user.firstName, user.lastName,
					user.age, user.gender, user.occupation, user.userName, user.password, user.role);
		}

		for (Movie movie : movies) {
			movieRecommender.addMovie(movie.title, movie.year, movie.URL);
		}
		for (Rating rating : ratings) {
			movieRecommender.addRating(rating.userId, rating.movieId,
					rating.rating);
		}
	}

	@Test
	public void testEmptyBeforePopulate() {
		movieRecommender = new MovieRecommenderAPI(null);
		assertEquals(0, movieRecommender.getUsers().size());
		assertEquals(0, movieRecommender.getMovies().size());
		assertEquals(0, movieRecommender.getRatings().size());
		populate(movieRecommender);
	}

	@Test
	public void testPopulate() {
		movieRecommender = new MovieRecommenderAPI(null);
		assertEquals(0, movieRecommender.getUsers().size());
		assertEquals(0, movieRecommender.getMovies().size());
		assertEquals(0, movieRecommender.getRatings().size());
		populate(movieRecommender);

		assertEquals(5, movieRecommender.getUsers().size());
		assertEquals(4, movieRecommender.getMovies().size());
		assertEquals(5, movieRecommender.getRatings().size());
	}

	void deleteFile(String fileName) {
		File datastore = new File("testdatastore2.xml");
		if (datastore.exists()) {
			datastore.delete();
		}
	}

	@Test
	public void testXMLSerializer() throws Exception {
		String datastoreFile = "testdatastore.xml";

		Serialiser serialiser = new XMLSerializer(new File(datastoreFile));

		movieRecommender = new MovieRecommenderAPI(serialiser);
		assertEquals(0, movieRecommender.getUsers().size());
		assertEquals(0, movieRecommender.getMovies().size());
		assertEquals(0, movieRecommender.getRatings().size());

		populate(movieRecommender);
		movieRecommender.store();

		MovieRecommenderAPI movieRecommender2 = new MovieRecommenderAPI(serialiser);
		movieRecommender2.load();

		assertEquals(movieRecommender.getUsers().size(), movieRecommender2.getUsers()
				.size());
		for (User user : movieRecommender.getUsers()) {
			assertTrue(movieRecommender2.getUsers().contains(user));
		}
	}
}