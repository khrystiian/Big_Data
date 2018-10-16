package recommender;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuildRObject {

	public RObject buildRObject(String obj){
		RObject rob = new RObject();
		JsonParser parser = new JsonParser();      	
		JsonObject json = parser.parse(obj).getAsJsonObject();
		String id = json.getAsJsonPrimitive("_id").toString();
		
		rob.setId(id.substring(1, id.length()-1));
		rob.setOpenness(Double.parseDouble(json.getAsJsonPrimitive("Openness").toString()));
		rob.setAgreeableness(Double.parseDouble(json.getAsJsonPrimitive("Agreeableness").toString()));
		rob.setConscientiousness(Double.parseDouble(json.getAsJsonPrimitive("Conscientiousness").toString()));
		rob.setEmotionalRrange(Double.parseDouble(json.getAsJsonPrimitive("EmotionalRrange").toString()));
		rob.setExtraversion(Double.parseDouble(json.getAsJsonPrimitive("Extraversion").toString()));

		return rob;
	}

}
