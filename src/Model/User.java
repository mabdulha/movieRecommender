package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.List;
import java.util.ArrayList;

import com.google.common.base.Objects;

public class User { 
    public static long counter= 01;
    
	public long userId;
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;
	
	// Had to change the java.awt to java.util because i was getting an error 
	public List<Rating> ratings = new ArrayList<Rating>();
	 
	//Constructor for the users
	 public User(String firstName, String lastName, int age, String gender, String occupation)
	  {
		this.userId 		=counter++ ;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.gender = gender;
	    this.occupation = occupation;
	  }
	 
	 public Long getUserId() {
		 return userId;
	 }
	 
	 @Override
	 public String toString() {
		 return toStringHelper(this).addValue(userId)
		 							.addValue(firstName)
				 					.addValue(lastName)
				 					.addValue(age)
				 					.addValue(gender)
				 					.addValue(occupation)
				 					.toString();
	 }
	 
	 @Override
	 public int hashCode()
	 {
		 return Objects.hashCode(this.userId, this.firstName, this.lastName, this.age, this.gender, this.occupation);
	 }
	 
	 @Override
	 public boolean equals(final Object obj) {
		 if(obj instanceof User){
			 final User other= (User) obj;
			 return Objects.equal(userId, other.userId)
				 && Objects.equal(firstName, other.firstName)
				 && Objects.equal(lastName, other.lastName)
				 && Objects.equal(age, other.age)
				 && Objects.equal(gender, other.gender)
				 && Objects.equal(occupation, other.occupation);
		 }
		 else {
			 return false;
		 }
	 }
}