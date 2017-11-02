package Models;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Movie;

public class movieTest {
	Movie movie = new Movie("Re-Animator", 2014, "http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024");
	
	@Test
	public void testCreate() {
			assertEquals("Re-Animator", movie.title);
			assertEquals(2014, movie.year);
			assertEquals("http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024", movie.URL);
	}
	
	@Test
	public void movieToString()
	{
		assertEquals ("Movie{" + movie.movieId + ", Re-Animator, 2014, http://www.imdb.com/scary-good/horror-movie-taglines/ls025201469/mediaviewer/rm1379329024}", movie.toString());
	}
}
