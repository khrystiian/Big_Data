package watson;

import java.io.FileNotFoundException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BuildPersonality {

	private Watson watson = new Watson();
	private Personality personality = new Personality();
	
	
	
	
	public Personality buildPersonality(String user) throws FileNotFoundException{
			
	JsonObject responseJson = watson.getWatson(user);
	
	JsonObject rootjson = responseJson.getAsJsonObject("tree");
	JsonArray treelist = rootjson.getAsJsonArray("children");

	
	JsonObject big5 = (JsonObject) treelist.get(0);

	JsonArray big5array = big5.getAsJsonArray("children");
	
	JsonObject big = (JsonObject) big5array.get(0);
	JsonArray bigarray = big.getAsJsonArray("children");
	JsonObject opennes = (JsonObject) bigarray.get(0);
	JsonObject conscientiousness = (JsonObject) bigarray.get(1);
	JsonObject extraversion = (JsonObject) bigarray.get(2);
	JsonObject agreeableness = (JsonObject) bigarray.get(3);
	JsonObject neuroticism = (JsonObject) bigarray.get(4);
	
	personality.setOpenness(Double.parseDouble(opennes.getAsJsonPrimitive("percentage").toString()));
	personality.setConscientiousness(Double.parseDouble(conscientiousness.getAsJsonPrimitive("percentage").toString()));
	personality.setExtraversion(Double.parseDouble(extraversion.getAsJsonPrimitive("percentage").toString()));
	personality.setAgreeableness(Double.parseDouble(agreeableness.getAsJsonPrimitive("percentage").toString()));
	personality.setNeuroticism(Double.parseDouble(neuroticism.getAsJsonPrimitive("percentage").toString()));
	
	JsonArray opennesArray = opennes.getAsJsonArray("children");
	JsonObject adventurousness = (JsonObject) opennesArray.get(0);
	JsonObject artisticInterests = (JsonObject) opennesArray.get(1);
	JsonObject emotionality = (JsonObject) opennesArray.get(2);
	JsonObject imagination = (JsonObject) opennesArray.get(3);
	JsonObject intellect = (JsonObject) opennesArray.get(4);
	JsonObject liberalism = (JsonObject) opennesArray.get(5);
	
	personality.setAdventurousness(Double.parseDouble(adventurousness.getAsJsonPrimitive("percentage").toString()));
	personality.setArtisticInterests(Double.parseDouble(artisticInterests.getAsJsonPrimitive("percentage").toString()));
	personality.setEmotionality(Double.parseDouble(emotionality.getAsJsonPrimitive("percentage").toString()));
	personality.setImagination(Double.parseDouble(imagination.getAsJsonPrimitive("percentage").toString()));
	personality.setIntellect(Double.parseDouble(intellect.getAsJsonPrimitive("percentage").toString()));
	personality.setLiberalism(Double.parseDouble(liberalism.getAsJsonPrimitive("percentage").toString()));
	
	
	JsonArray conscientiousnessArray = conscientiousness.getAsJsonArray("children");
	JsonObject achievementStriving = (JsonObject) conscientiousnessArray.get(0);
	JsonObject cautiousness = (JsonObject) conscientiousnessArray.get(1);
	JsonObject dutifulness = (JsonObject) conscientiousnessArray.get(2);
	JsonObject orderliness = (JsonObject) conscientiousnessArray.get(3);
	JsonObject selfDiscipline = (JsonObject) conscientiousnessArray.get(4);
	JsonObject selfEfficacy = (JsonObject) conscientiousnessArray.get(5);
	
	personality.setAchievementStriving(Double.parseDouble(achievementStriving.getAsJsonPrimitive("percentage").toString()));
	personality.setCautiousness(Double.parseDouble(cautiousness.getAsJsonPrimitive("percentage").toString()));
	personality.setDutifulness(Double.parseDouble(dutifulness.getAsJsonPrimitive("percentage").toString()));
	personality.setOrderliness(Double.parseDouble(orderliness.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfDiscipline(Double.parseDouble(selfDiscipline.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfEfficacy(Double.parseDouble(selfEfficacy.getAsJsonPrimitive("percentage").toString()));
	
	
	JsonArray extraversionArray = extraversion.getAsJsonArray("children");
	JsonObject activityLevel = (JsonObject) extraversionArray.get(0);
	JsonObject assertiveness = (JsonObject) extraversionArray.get(1);
	JsonObject cheerfulness = (JsonObject) extraversionArray.get(2);
	JsonObject excitementSeeking = (JsonObject) extraversionArray.get(3);
	JsonObject friendliness = (JsonObject) extraversionArray.get(4);
	JsonObject gregariousness = (JsonObject) extraversionArray.get(5);
	
	personality.setActivityLevel(Double.parseDouble(activityLevel.getAsJsonPrimitive("percentage").toString()));
	personality.setAssertiveness(Double.parseDouble(assertiveness.getAsJsonPrimitive("percentage").toString()));
	personality.setCheerfulness(Double.parseDouble(cheerfulness.getAsJsonPrimitive("percentage").toString()));
	personality.setExcitementSeeking(Double.parseDouble(excitementSeeking.getAsJsonPrimitive("percentage").toString()));
	personality.setFriendliness(Double.parseDouble(friendliness.getAsJsonPrimitive("percentage").toString()));
	personality.setGregariousness(Double.parseDouble(gregariousness.getAsJsonPrimitive("percentage").toString()));
		
	
	JsonArray agreeablenessArray = agreeableness.getAsJsonArray("children");
	JsonObject altruism = (JsonObject) agreeablenessArray.get(0);
	JsonObject cooperation = (JsonObject) agreeablenessArray.get(1);
	JsonObject modesty = (JsonObject) agreeablenessArray.get(2);
	JsonObject morality = (JsonObject) agreeablenessArray.get(3);
	JsonObject sympathy = (JsonObject) agreeablenessArray.get(4);
	JsonObject trust = (JsonObject) agreeablenessArray.get(5);
	
	personality.setAltruism(Double.parseDouble(altruism.getAsJsonPrimitive("percentage").toString()));
	personality.setCooperation(Double.parseDouble(cooperation.getAsJsonPrimitive("percentage").toString()));
	personality.setModesty(Double.parseDouble(modesty.getAsJsonPrimitive("percentage").toString()));
	personality.setMorality(Double.parseDouble(morality.getAsJsonPrimitive("percentage").toString()));
	personality.setSympathy(Double.parseDouble(sympathy.getAsJsonPrimitive("percentage").toString()));
	personality.setTrust(Double.parseDouble(trust.getAsJsonPrimitive("percentage").toString()));
	
			
	JsonArray neuroticismArray = neuroticism.getAsJsonArray("children");
	JsonObject anger = (JsonObject) neuroticismArray.get(0);
	JsonObject anxiety = (JsonObject) neuroticismArray.get(1);
	JsonObject depression = (JsonObject) neuroticismArray.get(2);
	JsonObject immoderation = (JsonObject) neuroticismArray.get(3);
	JsonObject selfConsciousness = (JsonObject) neuroticismArray.get(4);
	JsonObject vulnerability = (JsonObject) neuroticismArray.get(5);
	
	personality.setAnger(Double.parseDouble(anger.getAsJsonPrimitive("percentage").toString()));
	personality.setAnxiety(Double.parseDouble(anxiety.getAsJsonPrimitive("percentage").toString()));
	personality.setDepression(Double.parseDouble(depression.getAsJsonPrimitive("percentage").toString()));
	personality.setImmoderation(Double.parseDouble(immoderation.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfConsciousness(Double.parseDouble(selfConsciousness.getAsJsonPrimitive("percentage").toString()));
	personality.setVulnerability(Double.parseDouble(vulnerability.getAsJsonPrimitive("percentage").toString()));
	
	
	JsonObject needs = (JsonObject) treelist.get(1);
	JsonArray needsArray = needs.getAsJsonArray("children");
	JsonObject needsObj = (JsonObject) needsArray.get(0);
	JsonArray needsArrayObj = needsObj.getAsJsonArray("children");
	JsonObject challenge = (JsonObject) needsArrayObj.get(0);
	JsonObject closeness = (JsonObject) needsArrayObj.get(1);
	JsonObject curiosity = (JsonObject) needsArrayObj.get(2);
	JsonObject excitement = (JsonObject) needsArrayObj.get(3);
	JsonObject harmony = (JsonObject) needsArrayObj.get(4);
	JsonObject ideal = (JsonObject) needsArrayObj.get(5);
	JsonObject liberty = (JsonObject) needsArrayObj.get(6);
	JsonObject love = (JsonObject) needsArrayObj.get(7);
	JsonObject practicality = (JsonObject) needsArrayObj.get(8);
	JsonObject selfExpression = (JsonObject) needsArrayObj.get(9);
	JsonObject sability = (JsonObject) needsArrayObj.get(10);
	JsonObject structure = (JsonObject) needsArrayObj.get(11);
	
	personality.setChallenge(Double.parseDouble(challenge.getAsJsonPrimitive("percentage").toString()));
	personality.setCloseness(Double.parseDouble(closeness.getAsJsonPrimitive("percentage").toString()));
	personality.setCuriosity(Double.parseDouble(curiosity.getAsJsonPrimitive("percentage").toString()));
	personality.setExcitement(Double.parseDouble(excitement.getAsJsonPrimitive("percentage").toString()));
	personality.setHarmony(Double.parseDouble(harmony.getAsJsonPrimitive("percentage").toString()));
	personality.setIdeal(Double.parseDouble(ideal.getAsJsonPrimitive("percentage").toString()));
	personality.setLiberty(Double.parseDouble(liberty.getAsJsonPrimitive("percentage").toString()));
	personality.setLove(Double.parseDouble(love.getAsJsonPrimitive("percentage").toString()));
	personality.setPracticality(Double.parseDouble(practicality.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfExpression(Double.parseDouble(selfExpression.getAsJsonPrimitive("percentage").toString()));
	personality.setSability(Double.parseDouble(sability.getAsJsonPrimitive("percentage").toString()));
	personality.setStructure(Double.parseDouble(structure.getAsJsonPrimitive("percentage").toString()));
	
	
	JsonObject values = (JsonObject) treelist.get(2);
	JsonArray valuesArray = values.getAsJsonArray("children");
	JsonObject valuesObj = (JsonObject) valuesArray.get(0);
	JsonArray valuesArrayObj = valuesObj.getAsJsonArray("children");
	JsonObject conservation = (JsonObject) valuesArrayObj.get(0);
	JsonObject opennessToChange = (JsonObject) valuesArrayObj.get(1);
	JsonObject hedonism = (JsonObject) valuesArrayObj.get(2);
	JsonObject selfEnhancement = (JsonObject) valuesArrayObj.get(3);
	JsonObject selfTranscendence = (JsonObject) valuesArrayObj.get(4);
	
	personality.setConservation(Double.parseDouble(conservation.getAsJsonPrimitive("percentage").toString()));
	personality.setOpennessToChange(Double.parseDouble(opennessToChange.getAsJsonPrimitive("percentage").toString()));
	personality.setHedonism(Double.parseDouble(hedonism.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfEnhancement(Double.parseDouble(selfEnhancement.getAsJsonPrimitive("percentage").toString()));
	personality.setSelfTranscendence(Double.parseDouble(selfTranscendence.getAsJsonPrimitive("percentage").toString()));
	
	return personality;
	
	}
	
}
