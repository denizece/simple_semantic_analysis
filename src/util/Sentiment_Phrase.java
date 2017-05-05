package util;

import com.google.gson.annotations.SerializedName;

public class Sentiment_Phrase {

	public String getPhrase() {
		return phrase;
	}
	public int getValue() {
		return value;
	}
	public double getMultiplier() {
		return multiplier;
	}
	@SerializedName("phrase") private String phrase;
	@SerializedName("value") private int value;
	@SerializedName("multiplier") private double multiplier;
}
