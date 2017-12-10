package Models;

import static Models.fixtures.ratings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Model.Rating;

public class ratingTest { 
	Rating test = new Rating (Long.valueOf(1), Long.valueOf(3), Integer.valueOf(1));
	Rating test2 = new Rating (Long.valueOf(2), Long.valueOf(4), Integer.valueOf(2));
	Rating test3 = new Rating (Long.valueOf(1), Long.valueOf(3), Integer.valueOf(1));


	@Test
	public void testCreate()
	{  
		assertEquals (0, ratings[0].userId);
		assertEquals (0, ratings[0].movieId);
		assertEquals (-2, ratings[0].rating);
	}

@Test
public void testIds()
{
	assertNotEquals(ratings[1].userId, ratings[2].userId);
}

@Test
public void testEquals()
{
	assertFalse(test.equals(test2));
	assertTrue(test.equals(test3));
}

}