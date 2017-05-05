package util;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Hotel {
	@SerializedName("Reviews") private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}
}
