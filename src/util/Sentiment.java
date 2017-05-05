package util;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Sentiment {
	public List<Sentiment_Phrase> getPositives() {
		return positives;
	}
	public List<Sentiment_Phrase> getNegatives() {
		return negatives;
	}
	public List<Sentiment_Phrase> getIntensifiers() {
		return intensifiers;
	}
	@SerializedName("positive") private List<Sentiment_Phrase>positives;
	@SerializedName("negative") private List<Sentiment_Phrase>negatives;
	@SerializedName("intensifier") private List<Sentiment_Phrase>intensifiers;
}
