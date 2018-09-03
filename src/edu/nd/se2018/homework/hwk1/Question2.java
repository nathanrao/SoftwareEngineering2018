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
		
		String[] divideInput = input.split(" ");
		String[] divideStopWords = stopwords.split(" ");
		
		for (int i = 0; i<divideInput.length; i++) {
			if(!map.containsKey(divideInput[i])) {
				map.put(divideInput[i],1);
			}
			else {
				map.put(divideInput[i], (Integer) map.get(divideInput[i])+1);
			}
		}
		
		for (int i = 0; i<divideStopWords.length; i++) {
			if(map.containsKey(divideStopWords[i])) {
				map.remove(divideStopWords[i]);
			}
		}
		
		String maxKey = null;
		int maxVal = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxVal) {
				maxKey = entry.getKey();
				maxVal = entry.getValue();
			}
			else if (entry.getValue() == maxVal) {
				maxKey = null;
			}
		}
		
		for (int i = 0; i < divideInput.length; i++) {
			if(map.containsKey(divideInput[i])) {
				map.remove(divideInput[i]);
			}
		}
		
		return maxKey;
		
	}
}
