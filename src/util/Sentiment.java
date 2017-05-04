package util;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Sentiment {
	@SerializedName("positive") private List<Sentiment_Phrase>positives;
	@SerializedName("negative") private List<Sentiment_Phrase>negatives;
	@SerializedName("intensifier") private List<Sentiment_Phrase>intensifiers;
}
