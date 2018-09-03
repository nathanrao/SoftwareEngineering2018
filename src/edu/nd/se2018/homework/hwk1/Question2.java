package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import java.lang.String;

public class Question2 {

	Map<String, Integer> map;
	
	public Question2(){
		map = new HashMap<String, Integer>();
	}
	
	public String getMostFrequentWord(String input, String stopwords){
		
		String[] divideInput = input.split(" "); //divide input string into array of words
		String[] divideStopWords = stopwords.split(" "); //divide stop words string into array of words
		
		for (int i = 0; i<divideInput.length; i++) { //loop through words to place them in hashmap
			if(!map.containsKey(divideInput[i])) {
				map.put(divideInput[i],1);
			}
			else { //if the word already appears, increment appearance count
				map.put(divideInput[i], (Integer) map.get(divideInput[i])+1);
			}
		}
		
		for (int i = 0; i<divideStopWords.length; i++) { //loop through hashmap to remove stopwords
			if(map.containsKey(divideStopWords[i])) {
				map.remove(divideStopWords[i]);
			}
		}
		
		//iterate through hashmap to find the word(s) with the highest appearance count
		String maxKey = null;
		int maxVal = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxVal) {
				maxKey = entry.getKey();
				maxVal = entry.getValue();
			}
			else if (entry.getValue() == maxVal) { //more than one word with the same highest appearance count, set key to null
				maxKey = null;
			}
		}
		
		for (int i = 0; i < divideInput.length; i++) { //clear hashmap for next test
			if(map.containsKey(divideInput[i])) {
				map.remove(divideInput[i]);
			}
		}
		
		return maxKey;
		
	}
}
