package util;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

import com.google.gson.annotations.SerializedName;

public class Review {
	@SerializedName("Ratings") private Rating rating;
	@SerializedName("AuthorLocation") private String authorLocation;
	@SerializedName("Title") private String title;
	@SerializedName("Author") private String author;
	@SerializedName("Content") private String content;
	private ArrayList<Sentence>content_senteces;
	public ArrayList<Sentence> getContent_senteces() {
		return content_senteces;
	}
	public String getContent() {
		return this.content;
	}
}
