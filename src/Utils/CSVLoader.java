package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.MovieRecommenderAPI;
import Model.Movie;
import Model.Rating;
import Model.User;

public class CSVLoader {
	
	public List<User> parseUsers(String datastores) throws Exception {
	File datastore = new File("datastore.xml");
	Serialiser serialiser = new XMLSerializer(datastore);
	MovieRecommenderAPI movieRecommenderAPI = new MovieRecommenderAPI(serialiser);
	if(datastore.isFile()) 
	{
		movieRecommenderAPI.load();
	}
	
	String delims = "[|]";
	List <User> users = new ArrayList<User>();
    Scanner sc = new Scanner(new File("moviedata_small/users5.dat"));
    while (sc.hasNextLine()) {
        String userDetails = sc.nextLine();
        // parse user details string
        String[] userTokens = userDetails.split(delims);
        String convertString = userTokens[3];
        int age = Integer.parseInt(convertString);

        movieRecommenderAPI.addUser(userTokens[1], userTokens[2], age, userTokens[4], userTokens[5]);
    }
    return users;
}

	public List<Movie> parseMovies(String datastores) throws Exception {
		File datastore = new File("datastore.xml");
		Serialiser serialiser = new XMLSerializer(datastore);
		MovieRecommenderAPI movieRecommenderAPI = new MovieRecommenderAPI(serialiser);
		if(datastore.isFile()) 
		{
			movieRecommenderAPI.load();
		}
		
		String delims = "[|]";
		List <Movie> movies = new ArrayList<Movie>();
	    Scanner sc = new Scanner(new File("moviedata_small/items5.dat"));
	    while (sc.hasNextLine()) {
	        String movieDetails = sc.nextLine();
	        // parse user details string
	        String[] movieTokens = movieDetails.split(delims);
	        String convertString = movieTokens[2];
	        int year = Integer.parseInt(convertString);

	        movieRecommenderAPI.addMovie(movieTokens[1], year, movieTokens[3]);
	        
	    }
	    return movies;
	    
	}
	
	public List<Rating> parseRatings(String datastores) throws Exception {
		File datastore = new File("datastore.xml");
		Serialiser serialiser = new XMLSerializer(datastore);
		MovieRecommenderAPI movieRecommenderAPI = new MovieRecommenderAPI(serialiser);
		if(datastore.isFile()) 
		{
			movieRecommenderAPI.load();
		}
		
		String delims = "[|]";
		List <Rating> ratings = new ArrayList<Rating>();
	    Scanner sc = new Scanner(new File("moviedata_small/ratings5.dat"));
	    while (sc.hasNextLine()) {
	        String ratingDetails = sc.nextLine();
	        // parse user details string
	        String[] ratingTokens = ratingDetails.split(delims);
	        String convertString = ratingTokens[3];
	        int ratingValue = Integer.parseInt(convertString);
	        String convertString2 = ratingTokens[1];
	        Long userID = Long.parseLong(convertString2);
	        String convertString3 = ratingTokens[2];
	        Long movieID = Long.parseLong(convertString3);

	        movieRecommenderAPI.addRating(userID, movieID, ratingValue);
	        
	    }
	    sc.close();
	    
	    return ratings;   
	}
}
