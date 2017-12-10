package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User { 
    public static long counter= 01;
    
	public long userId;
	public String firstName;
	public String lastName;
	public int age;
	public String gender;
	public String occupation;
	public String role;
	public String userName;
	public String password;
	
	// Had to change the java.awt to java.util because i was getting an error 
	public Map<Long, Rating> ratings = new HashMap<>();
	 
	
	public User(String firstName, String lastName, int age, String gender, String occupation, String userName, String password)
	  {
	    this(firstName,lastName, age, gender, occupation, userName, password, "default");
	  }
	
	//Constructor for the users
	 public User(String firstName, String lastName, int age, String gender, String occupation, String userName, String password, String role)
	  {
		this.userId 		=counter++ ;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.gender = gender;
	    this.occupation = occupation;
	    this.userName = userName;
	    this.password = password;
	    this.role = role;
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
				 					.addValue(userName)
				 					.addValue(password)
				 					.addValue(role)
				 					.toString();
	 }
	 
	 @Override
	 public int hashCode()
	 {
		 return Objects.hashCode(this.userId, this.firstName, this.lastName, this.age, this.gender, this.occupation, this.userName, this.password, this.role);
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
				 && Objects.equal(occupation, other.occupation)
				 && Objects.equal(userName, other.userName)
				 && Objects.equal(password, other.password)
				 && Objects.equal(role, other.role);
		 }
		 else {
			 return false;
		 }
	 }
}