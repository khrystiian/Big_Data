package movie;

public class Genre {
	
	public String name;
	public String movieId;
	public Genre(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "Genre [name=" + name + ", movieId=" + movieId + "]";
	}
	
	
	
}
