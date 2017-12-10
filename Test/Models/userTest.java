package Models;

import static Models.fixtures.users;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import Model.User;

public class userTest {
	
	User homer = new User("homer", "simpson", 25, "Male", "House Husband", "homer", "secret");
	
	@Test
	public void testCreate() {
		assertEquals("homer", homer.firstName);
		assertEquals("simpson", homer.lastName);
		assertEquals(25 , homer.age);
		assertEquals("Male", homer.gender);
		assertEquals("House Husband", homer.occupation);
	}
	
	@Test
	  public void testIds()
	  {
	    Set<Long> ids = new HashSet<>();
	    for (User user : users)
	    {
	      ids.add(user.userId);
	    }
	    assertEquals (users.length, ids.size());
	  }
	
	@Test
	public void testToString()
	  {
	    assertEquals ("User{" + homer.userId + ", homer, simpson, 25, Male, House Husband}", homer.toString());
	  }
	
	@Test
	  public void testEquals()
	  { 
	    User bart   = new User ("bart", "simpson", 10, "Male", "Student", "bart", "secret"); 

	    assertEquals(homer, homer);
	    assertSame(homer, homer);
	    assertNotSame(homer, bart);
	    assertNotEquals(homer, bart);
	  }
}
