package movie;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuildMovie {

	
	public Movie buildMovie(String mongoj){
		Movie movie = new Movie();
		
		ArrayList<Genre>genres = new ArrayList<>();
		JsonParser parser = new JsonParser();      	
		JsonObject json = parser.parse(mongoj.toString()).getAsJsonObject();
		String title = json.getAsJsonPrimitive("Title").toString();
		String id = json.getAsJsonPrimitive("_id").toString();
		
		movie.setMoviId(id.substring(1, id.length()-1));
		movie.setTitle(title.substring(1, title.length()-1));
		movie.setYear(Integer.parseInt(json.getAsJsonPrimitive("Year").toString()));
		movie.setSummary(json.getAsJsonPrimitive("PlotSummary").toString());
		movie.setPosterLink(json.getAsJsonPrimitive("PosterLink").toString());
		movie.setScore(Double.parseDouble(json.getAsJsonPrimitive("Score").toString()));
		
		JsonArray gen = json.getAsJsonArray("Genres");
		for(int i=0; i<gen.size(); i++){
			Genre genre = new Genre();
			JsonObject jgenre = (JsonObject) gen.get(i);
			String name = jgenre.getAsJsonPrimitive("GenreType").toString();
			genre.setMovieId(id.substring(1, id.length()-1));
			genre.setName(name.substring(1, name.length()-1));
			genres.add(genre);			
		}
		
		movie.setGenres(genres);		
		
		return movie;
	}
	
	
	
	
}
