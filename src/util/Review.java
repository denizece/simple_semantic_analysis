package util;

import com.google.gson.annotations.SerializedName;

public class Review {
	@SerializedName("Ratings") private Rating rating;
	@SerializedName("AuthorLocation") private String authorLocation;
	@SerializedName("Title") private String title;
	@SerializedName("Author") private String author;
	@SerializedName("Content") private String content;
}
