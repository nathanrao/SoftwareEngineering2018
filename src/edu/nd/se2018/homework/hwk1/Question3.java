package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		
    	int length = numbers.length;
    	int total = 0;
    	int highest = 0;
    	for (int i = 0; i < length; i++) {
    		total = 0;
    		for (int j = length - 1; i + total < length && j > -1; j--) {
    			if (numbers[i + total] == numbers[j]) {
    				total++;
    			}
    			else {
    				if (total > 0) {
    					highest = Math.max(total, highest);
    					total = 0;
    				}
    			}
    		}
    		highest = Math.max(total, highest);
    	}
    	return highest;	
	}
}
