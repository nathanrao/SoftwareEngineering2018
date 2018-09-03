package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import java.lang.String;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		
		Map<String, Integer> numWords = new HashMap<>();
		
		String[] inputString = input.split(" ");
		String[] stopWordString = input.split(" ");
		
		for(String i:inputString) {
			Integer stopWordCheck = 0;
			for(String j:stopWordString) {
				if (i.equals(j)) {
					stopWordCheck = 1;
					break;
				}
			}
			if (stopWordCheck==0) {
				Integer increment = 1;
				if(numWords.get(i) != null) {
					increment = numWords.get(i);
				}
				numWords.put(i,increment+1);
			}
		}
		
		Map.Entry<String, Integer> maxEntry = null;
		
		for(Map.Entry<String, Integer> entry : numWords.entrySet()) {
			if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		
		Integer tied = 0;
		for(Map.Entry<String, Integer> secondEntry : numWords.entrySet()) {
			if (secondEntry.getValue().compareTo(maxEntry.getValue()) == 0 && !secondEntry.getKey().equals(maxEntry.getKey())) {
				tied = 1;
			}
		}
		
		/*String check = maxEntry.getKey();
		if (tied == 1) {
			check = null;
		}*/
		return stopWordString[1];
		
	}
}
