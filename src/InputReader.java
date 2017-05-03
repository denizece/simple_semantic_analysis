import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import util.Hotel;

public class InputReader {

	public void readReviews(String path)
	{
		Gson gson = new Gson();
		Hotel m_hotel = null;
		try {
			m_hotel = gson.fromJson(new FileReader(path), Hotel.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
