package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Rating {
	public int rating;
	public long userId;
	public long movieId;
	
	public List<Rating> ratings = new ArrayList<Rating>();

	
	//Constructor for movie rating 
	public Rating(Long userId, Long movieId, int rating) {
		this.userId = userId;
		this.movieId= movieId;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return toStringHelper(this).addValue(userId)
								   .addValue(movieId)
								   .addValue(rating)
								   .toString();
	}
	
	@Override
	 public int hashCode()
	 {
		 return Objects.hashCode(movieId, userId, this.rating);
	 }
	@Override
	 public boolean equals(final Object obj) {
		 if(obj instanceof Rating){
			 final Rating other= (Rating) obj;
			 return Objects.equal(userId, other.userId)
				 && Objects.equal(movieId, other.movieId)
				 && Objects.equal(rating, other.rating);
		 }
		 else {
			 return false;
		 }
	 }
}
