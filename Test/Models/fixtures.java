package Models;

import Model.Movie;
import Model.Rating;
import Model.User;

public class fixtures {

	  public static User[] users =
	  {
	    new User ("marge", "simpson", 32,"F", "housewife", "marge", "secret"),
	    new User ("lisa",  "simpson",  10,"F", "student", "lisa", "secret"),
	    new User ("bart",  "simpson", 12,"M", "student", "bart", "secret"),
	    new User ("maggie","simpson", 2,"M", "none", "maggie", "secret"),
	    new User ("homer","simpson", 35,"M","physicist", "homer", "secret"),
		}; 
	  
	  
	  public static Movie[] movies =
		  {
		  new Movie ("Good Will Hunting", "1997", "www.netflix.com"),
		  new Movie ("Gladiator", "2000", "www.netflix.com"),
		  new Movie ("Forrest Gump", "1994", "www.netflix.com"),
		  new Movie ("Braveheart", "1995", "www.netflix.com"),
		  };
	  
	  public static Rating[] ratings =
			{
			new Rating(Long.valueOf(0), Long.valueOf(0), -2),
			new Rating(Long.valueOf(1), Long.valueOf(1), -2),  
			new Rating(Long.valueOf(2), Long.valueOf(3), 4),
			new Rating(Long.valueOf(3), Long.valueOf(3), -4),
			new Rating(Long.valueOf(4), Long.valueOf(2), -3),
			
			};
	}
