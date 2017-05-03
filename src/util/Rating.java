package util;

import com.google.gson.annotations.SerializedName;

public class Rating {
	@SerializedName("Rooms") private int rooms;
	@SerializedName("Cleanliness") private int cleanliness;
	@SerializedName("Sleep Quality") private int sleep_quality;
	@SerializedName("Service") private int service;
	@SerializedName("Value") private int value;
	@SerializedName("Location") private int location;
	@SerializedName("Overall") private double overall;
}
