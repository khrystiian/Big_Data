package movie;

import java.util.ArrayList;

public class Movie {

	public String movieId;
	public String title;
	public int year;
	public String summary;
	public String posterLink;
	public double score;
	public ArrayList<Genre> genres;

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	public Movie(){
		
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPosterLink() {
		return posterLink;
	}

	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getMovieId(){
		return movieId;
	}
	
	public void setMoviId(String movieId){
		this.movieId = movieId;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", summary=" + summary
				+ ", posterLink=" + posterLink + ", score=" + score + ", genres=" + genres + "]";
	}
	
	
	
}
