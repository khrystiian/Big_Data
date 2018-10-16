package recommender;

import DbConnection.DbConnection;
import movie.GetMovies;
import movie.Movie;


import twitter4j.*;

import watson.BuildPersonality;
import watson.Personality;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Arlena on 04/05/2017.
 */
public class ComparisonController   {
	public ArrayList<Movie> top5(String user) throws TwitterException, IOException, JSONException{
		ArrayList<Movie> top5 = new ArrayList<>();
		Movie movie = new Movie();
		DbConnection con = new DbConnection();
		List<RObject> rObj = recommendMovies(user);
		for (RObject rObject : rObj) {
			String id = rObject.getId();
			movie = con.getMovie(id);
			top5.add(movie);
		}
		
		return top5;
	}
    public List<RObject> recommendMovies(String user) throws TwitterException, IOException, JSONException {

    	BuildPersonality build = new BuildPersonality();
    	DbConnection con = new DbConnection();
        Personality userInsight = build.buildPersonality(user);
        RObject rObj = new RObject();
        rObj.setAgreeableness(userInsight.getAgreeableness());
        rObj.setConscientiousness(userInsight.getConscientiousness());
        rObj.setEmotionalRrange(userInsight.getNeuroticism());
        rObj.setExtraversion(userInsight.getExtraversion());
        rObj.setOpenness(userInsight.getOpenness());

        DbConnection connection = new DbConnection();
        ArrayList<RObject> movieInsights = con.getrecommenderRObjects();

        return compare(rObj, movieInsights);        
    }

    public Personality getUserInsights(String user) throws FileNotFoundException{
    	
    	BuildPersonality build = new BuildPersonality();
        Personality userInsight = build.buildPersonality(user);
        RObject rObj = new RObject();
        rObj.setAgreeableness(userInsight.getAgreeableness());
        rObj.setConscientiousness(userInsight.getConscientiousness());
        rObj.setEmotionalRrange(userInsight.getNeuroticism());
        rObj.setExtraversion(userInsight.getExtraversion());
        rObj.setOpenness(userInsight.getOpenness());

        return userInsight;
    }
    
    private List<RObject> compare(RObject userInsight, List<RObject> movieInsights) throws IOException {

    	for (RObject movieInsight : movieInsights) {

            double distance = 0.0;

            distance += returnDif(movieInsight.Openness, userInsight.Openness);
            distance += returnDif(movieInsight.Agreeableness, userInsight.Agreeableness);
            distance += returnDif(movieInsight.Conscientiousness, userInsight.Conscientiousness);
            distance += returnDif(movieInsight.Extraversion, userInsight.Extraversion);
            distance += returnDif(movieInsight.EmotionalRrange, userInsight.EmotionalRrange);
            
               movieInsight.difValue = distance;
                    }
        // sort the list by distance
        Collections.sort(movieInsights, new Comparator<RObject>() {
            @Override
            public int compare(RObject i1, RObject i2) {
                if (i1.difValue > i2.difValue)
                    return 1;
                if (i1.difValue < i2.difValue)
                    return -1;
                return 0;
            }
        });
        List<RObject> returnList = new ArrayList<RObject>();
        // print out top 5
        for (int i = 0; i < 5; i++) {
            RObject movie = movieInsights.get(i);
            returnList.add(movie);
        }
        return returnList;

    }
    
    private double returnDif(double value1, double value2){
    	if(value1 >= value2){
    		return value1-value2;
    	}
    	return value2-value1;
    }


}
