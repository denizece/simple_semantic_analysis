package util;

public class Sentence {
		public Sentence(String substring) {
		this.sentence = substring;
		}

		String sentence;
		public String getSentence() {
			return sentence;
		}
		public void setSentence(String sentence) {
			this.sentence = sentence;
		}

		double sentiment_value;
		public double getSentiment_value() {
			return sentiment_value;
		}
		public void setSentiment_value(double sentiment_value) {
			this.sentiment_value = sentiment_value;
		}
}
