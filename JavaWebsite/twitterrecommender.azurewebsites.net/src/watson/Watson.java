package watson;


import java.io.FileNotFoundException;
import twitter.GetTweets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;

public class Watson {

	public JsonObject getWatson(String user) throws FileNotFoundException{

		JsonParser parser = new JsonParser();

		PersonalityInsights service = new PersonalityInsights();
		service.setUsernameAndPassword("f2e4d523-9b71-4ab9-8bc9-c2a1d49d276c", "T8PqcbwuZdHI");
		service.setEndPoint("https://gateway-fra.watsonplatform.net/personality-insights/api");
		
		String text = GetTweets.getAllTweets(user);

		Profile profile = service.getProfile(text).execute();
		JsonObject json = parser.parse(profile.toString()).getAsJsonObject();
		return json;

	}
}
