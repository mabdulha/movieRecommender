package Models;

import static Models.fixtures.movies;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import Model.Movie;

public class movieTest {
	Movie ani = new Movie("Re-Animator", "2014", "http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024");
	
	@Test
	public void testCreate() {
			assertEquals("Re-Animator", ani.title);
			assertEquals("2014", ani.year);
			assertEquals("http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024", ani.URL);
	}
	
	@Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (Movie movie : movies)
	    {
	      ids.add(movie.movieId);
	    }
	    assertEquals (movies.length, ids.size());
	  }
	
	@Test
	public void movieToString()
	{
		assertEquals ("Movie{" + ani.movieId + ", Re-Animator, 2014, http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024}", ani.toString());
	}
	
	@Test
	  public void testEquals()
	  { 
	    Movie glad   = new Movie ("Gladiator", "2000", "www.netflix.com"); 
	    
	    assertEquals(ani, ani);
	    assertSame(ani, ani);
	    assertNotSame(ani, glad);
	    assertNotEquals(ani, glad);
	  }
}
