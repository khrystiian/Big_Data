package recommender;

import java.util.*;
import java.util.Map.Entry;

public class RObject {
	
	
	public String id;
	public double Openness;
	public double Conscientiousness;
	public double Extraversion;
	public double Agreeableness;
	public double EmotionalRrange;
	public double difValue;
	
	public RObject(){

	
	}
	

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		id = Id;
	}

	public double getOpenness() {
		return Openness;
	}

	public void setOpenness(double openness) {
		Openness = openness;
	}

	public double getConscientiousness() {
		return Conscientiousness;
	}

	public void setConscientiousness(double conscientiousness) {
		Conscientiousness = conscientiousness;
	}

	public double getExtraversion() {
		return Extraversion;
	}

	public void setExtraversion(double extraversion) {
		Extraversion = extraversion;
	}

	public double getAgreeableness() {
		return Agreeableness;
	}

	public void setAgreeableness(double agreeableness) {
		Agreeableness = agreeableness;
	}

	public double getEmotionalRrange() {
		return EmotionalRrange;
	}

	public void setEmotionalRrange(double emotionalRrange) {
		EmotionalRrange = emotionalRrange;
	}

	public RObject(String id, double openness, double conscientiousness, double extraversion, double agreeableness,
			double emotionalRrange) {
		super();
		this.id = id;
		Openness = openness;
		Conscientiousness = conscientiousness;
		Extraversion = extraversion;
		Agreeableness = agreeableness;
		EmotionalRrange = emotionalRrange;
	}

	@Override
	public String toString() {
		return "RObject [id=" + id + ", Openness=" + Openness + ", Conscientiousness=" + Conscientiousness
				+ ", Extraversion=" + Extraversion + ", Agreeableness=" + Agreeableness + ", EmotionalRrange="
				+ EmotionalRrange + "]";
	}
	
	
	
}
