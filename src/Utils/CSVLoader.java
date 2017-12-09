package Utils;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;
import Model.Movie;
import Model.Rating;
import Model.User;

public class CSVLoader {
	public List<User> parseUsers(String filename) throws Exception {
		In inUsers = new In(filename);

		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while (!inUsers.isEmpty()) {
			String userDetails = inUsers.readLine();
			String[] ratingTokens = userDetails.split(delims);
			if (ratingTokens.length == 7) {
				String firstName = ratingTokens[1];
				String lastName = ratingTokens[2];
				int age = Integer.valueOf(ratingTokens[3]);
				String gender = ratingTokens[4];
				String occupation = ratingTokens[5];
				String userName= "";
				String password= "";

				users.add(new User(firstName, lastName, age, gender,occupation, userName, password));
			} else {
				throw new Exception("Invalid member length: "
						+ ratingTokens.length);
			}
		}
		return users;
	}

	public List<Rating> parseRatings(String filename) throws Exception {
		In inRatings = new In(filename);

		String delims = "[|]";
		List<Rating> ratings = new ArrayList<Rating>();
		while (!inRatings.isEmpty()) {
			String ratingDetails = inRatings.readLine();
			String[] ratingTokens = ratingDetails.split(delims);
			if (ratingTokens.length == 4) {
				Long userId = Long.valueOf(ratingTokens[0]);
				Long movieId = Long.valueOf(ratingTokens[1]);
				int ratingValue = Integer.valueOf(ratingTokens[2]);

				ratings.add(new Rating(userId, movieId, ratingValue));
			} else {
				throw new Exception("Invalid member length: "
						+ ratingTokens.length);
			}
		}
		return ratings;
	}

	public List<Movie> parseMovies(String filename) throws Exception {
		In inMovies = new In(filename);

		String delims = "[|]";
		List<Movie> movies = new ArrayList<Movie>();
		while (!inMovies.isEmpty()) {
			String movieDetails = inMovies.readLine();
			String[] movieTokens = movieDetails.split(delims);
			// only parsing in the first four fields
			if (movieTokens.length == 23) {
				String title = movieTokens[1];
				String year = movieTokens[2];
				String url = movieTokens[3];

				movies.add(new Movie(title, year, url));
			} else {
				throw new Exception("Invalid member length: "
						+ movieTokens.length);
			}
		}
		return movies;
	}
}