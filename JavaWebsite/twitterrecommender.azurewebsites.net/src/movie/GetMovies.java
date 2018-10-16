package movie;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class GetMovies {

	private Connection con;
	
		public Movie getMovie(String movieId) {
			ResultSet results;
			Movie movie = new Movie();
			PreparedStatement prepSt = null;
			
			String query = "SELECT MovieId, Title, Year, PlotSummary, PosterLink, Score FROM MOVIES WHERE MovieId = ?";

			try {
				prepSt = con.prepareStatement(query);
				prepSt.setString(1, movieId);
				prepSt.setQueryTimeout(5);
				results = prepSt.executeQuery();

				if (results.next()) {
					movie = buildMovie(results);
					prepSt.close();
				} else {
					movie = null;
				}
			} catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return movie;
		}
	
	private Movie buildMovie(ResultSet results){
		Movie mov = new Movie();
		try{
			mov.setMoviId(results.getString("MovieId"));
			mov.setTitle(results.getString("Title"));
			mov.setYear(results.getInt("Year"));
			mov.setSummary(results.getString("PlotSummary"));
			mov.setPosterLink(results.getString("PosterLink"));
			mov.setScore(results.getDouble("Score"));
			mov.setGenres(getGenres(results.getString("MovieId")));
		} catch (Exception e) {
			System.out.println("Error in building the Movie object");
		}
		return mov;
	}
	
	
	private Genre buildGenre(ResultSet results){
		Genre gen  = new Genre();	
		try{
			gen.setMovieId(results.getString("MovieId"));
			gen.setName(results.getString("Genre"));
		}catch (Exception e) {
			System.out.println("Error in building the Genre object");	
		
		}
		return gen;
	}
	
	
	private ArrayList<Genre> getGenres(String movieId){
		
		ResultSet results;
		ArrayList<Genre> genres = new ArrayList<Genre>();
		PreparedStatement prepSt = null;	
		String query = "SELECT MovieId, Genre FROM Genres WHERE MovieId = ?";
		
		try {
			prepSt = con.prepareStatement(query);
			prepSt.setString(1, movieId);
			prepSt.setQueryTimeout(5);
			results = prepSt.executeQuery();

			while (results.next()) {
				Genre genre = new Genre();
				genre = buildGenre(results);				
				genres.add(genre);
			}				
				prepSt.close();
		
		} catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return genres;		
	}
}
