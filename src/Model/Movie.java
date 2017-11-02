package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

public class Movie {
	//Declaring attributes
    public static Long counter= 0l;
    
	public Long movieId;
	public String title;
	public int year;
	public String URL;
	
	public List<Rating> ratings = new ArrayList<Rating>();
	
	// Creating a constructor for movies
	public Movie(String title, int year, String URL) {
		this.movieId = counter++;
		this.title = title;
		this.year = year;
		this.URL = URL;
	}
	
	public Long getMovieId() {
		return movieId;
	}
	
	public String getMovieTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return toStringHelper(this).addValue(movieId)
				                   .addValue(title)
								   .addValue(year)
								   .addValue(URL)
								   .toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.movieId, this.title,this.year,this.URL);
	}
	
	@Override
	 public boolean equals(final Object obj) {
		 if(obj instanceof Movie){
			 final Movie other= (Movie) obj;
			 return Objects.equal(movieId, other.movieId)
				 && Objects.equal(title, other.title)
				 && Objects.equal(year, other.year)
				 && Objects.equal(URL, other.URL);
		 }
		 else {
			 return false;
		 }
	 }
}