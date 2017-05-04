package util;

import com.google.gson.annotations.SerializedName;

public class Sentiment_Phrase {

	@SerializedName("phrase") private String phrase;
	@SerializedName("value") private int value;
	@SerializedName("multiplier") private double multiplier;
}
