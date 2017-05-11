import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import util.Hotel;
import util.Review;
import util.Sentence;
import util.Sentiment;
import util.Sentiment_Phrase;

public class SentimentAnalyzer {
	Sentiment s; 
	ArrayList<Hotel> hotels;
	HashMap<String, String[]> topicMap;
	SentimentAnalyzer()
	{
		s= new Sentiment();
		hotels = new ArrayList<Hotel>();
		topicMap = new HashMap<String, String[]>();
	}
	public void preprocess() {
		InputReader ir =new InputReader();
		if(hotels != null)
		ir.readReviews("./inputFiles/reviews/",hotels);
		System.out.println("========");
		s=ir.readSemantics("./inputFiles/semantics/semantics.json");
		topicMap = ir.createTopicMap("./inputFiles/semantics/topics.json");
		System.out.println("========");
		calculateSentenceValues();
		System.out.println("========");
	}
	private void calculateSentenceValues() {
		for (Hotel hotel : hotels) {
			for (Review review : hotel.getReviews()) {
				String content = review.getContent();
				if(!content.isEmpty())
				{
					BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
					iterator.setText(content);
					int start = iterator.first();
					for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) 
					{
					  Sentence this_sentence=new Sentence(content.substring(start,end));
					  this_sentence.setSentiment_value(calculateSenteceSentimentValue(this_sentence.getSentence()));
					  (review.getContent_senteces()).add(this_sentence);
					}
				}
			}
		}
	}
	private double calculateSenteceSentimentValue(String sentence2) {
		
		double value=0;
		for (Sentiment_Phrase phrase: s.getPositives()) {
			String sentence = sentence2;
			if(sentence.contains(phrase.getPhrase()))
			{
				value+=phrase.getValue();
				sentence.replace(phrase.getPhrase(), "");
			}
		}
		for (Sentiment_Phrase phrase: s.getNegatives()) {
			String sentence = sentence2;
			if(sentence.contains(phrase.getPhrase()))
			{
				value-=phrase.getValue();
				sentence.replace(phrase.getPhrase(), "");
			}
		}
		for (Sentiment_Phrase phrase: s.getIntensifiers()) {
			String sentence = sentence2;
			if(sentence.contains(phrase.getPhrase()))
			{
				value*=phrase.getMultiplier();
				sentence.replace(phrase.getPhrase(), "");
			}
		}
		
		return value;
	}
	
	private boolean containsTopic(String topic,String sentence)
	{
		boolean contains = false;
		String[]topic_words = topicMap.get(topic);
		for (int i = 0; i < topic_words.length; i++) {
			if(sentence.contains(topic_words[i]))
			{
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	private double calculateScoreForHotel(String topic,Hotel hotel)
	{ 
		double value = 0;
		for(Review r: hotel.getReviews())
		{
			for(Sentence s: r.getContent_senteces())
			{
				if(s.getSentence().containsTopic(topic, s.getSentence()))
				{
					value +=s.getSentiment_value();
				}
			}
		}
		return 0;
	}
}
