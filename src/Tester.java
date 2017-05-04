import java.util.ArrayList;

import util.Hotel;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader ir =new InputReader();
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		if(hotels != null)
		ir.readReviews("./inputFiles/reviews/",hotels);
		System.out.println("========");
		ir.readSemantics("./inputFiles/semantics/semantics.json");
		System.out.println("========");
	}

}
