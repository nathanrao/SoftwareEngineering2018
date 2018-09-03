package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		
    	int len = numbers.length;
    	int tot = 0;
    	int top = 0;
    	for (int i = 0; i < len; i++) {
    		tot = 0;
    		for (int j = len - 1; i + tot < len && j > -1; j--) {
    			if (numbers[i + tot] == numbers[j]) {
    				tot++;
    			}
    			else {
    				if (tot > 0) {
    					top = Math.max(tot, top);
    					tot = 0;
    				}
    			}
    		}
    		top = Math.max(tot, top);
    	}
    	return top;	
	}
}
