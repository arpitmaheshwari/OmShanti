package com.ptc.university.mastermind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class MasterMind
{

	private Code secretCode;

	public boolean storeSecretCode(Code code) {
		validateThatFourColorsAreGiven(code);
		validateUniqueness(code);
		this.secretCode = code;
		return true;
	}
	
	private void validateThatFourColorsAreGiven(Code code) {
		if(code.getFirst() == null || code.getSecond() == null || code.getThird() == null|| code.getFourth() == null){
			throw new IllegalArgumentException("Four Colours should be provided");
		}
	}

	private void validateUniqueness(Code code) {
		Set<CodeColour> givenColours = new HashSet<>(Arrays.asList(code.getFirst(), code.getSecond(), code.getThird() , code.getFourth() ));
		if(givenColours.size() != 4) throw new IllegalArgumentException("Colours should be uniuqe");
	}
    
}
