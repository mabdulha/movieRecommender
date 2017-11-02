package Models;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.User;

public class userTest {
	
	User homer = new User("homer", "simpson", 25, "Male", "House Husband");
	
	@Test
	public void testCreate() {
		assertEquals("homer", homer.firstName);
		assertEquals("simpson", homer.lastName);
		assertEquals(25 , homer.age);
		assertEquals("Male", homer.gender);
		assertEquals("House Husband", homer.occupation);
	}
	
	@Test
	public void testToString()
	  {
	    assertEquals ("User{" + homer.userId + ", homer, simpson, 25, Male, House Husband}", homer.toString());
	  }
	
	@Test
	  public void testEquals()
	  {
	    User homer2 = new User ("homer", "simpson", 25, "Male", "House Husband"); 
	    User bart   = new User ("bart", "simpson", 10, "Male", "Student"); 

	    assertEquals(homer, homer);
	    assertSame(homer, homer);
	    assertNotSame(homer, homer2);
	    assertNotEquals(homer, bart);
	  }
}
