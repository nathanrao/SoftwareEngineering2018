package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;
import java.util.Set;
import java.lang.Integer;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		Set<Integer> alreadyFound = new HashSet<>();
		Integer sum = 0;
		for(Integer i:numbers) {
			if(alreadyFound.contains(i)) {
				continue;
			}
			else {
				alreadyFound.add(i);
				sum += i;
			}
		}
		return sum;	
	}
}
