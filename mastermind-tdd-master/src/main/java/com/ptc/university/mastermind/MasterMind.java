package com.ptc.university.mastermind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class MasterMind
{
	private String[] colors = { "Red","Blue", "Green", "Brown", "Yellow", "Pink" };
	private List <String> code;
	private List<List<String>> inputCodes = new ArrayList<List<String>>();

	public MasterMind(List <String> code) {

		validateInputCode(code);
		this.code = code;

	}

	private void validateInputCode(List<String> code) {
		if(code == null || code.size() != 4){
			throw new IllegalArgumentException("Only four colors allowed");
		}

		if(unknownColor(code)){
			throw new IllegalArgumentException("Invalid Color.");
		}
		
		if( hasDuplicates(code) ){
			throw new IllegalArgumentException("Duplicate colors not allowed.");
		}
	}		 

	private boolean unknownColor(List<String> code) {
		for(int i = 0; i < code.size(); i++ ) {
			if( !allowedColor( code.get( i ))){
				return true;
			}
		}
		return false;
	}

	private boolean hasDuplicates( List<String> code ){
		Set colorSet = new HashSet<String>( code );
		if( colorSet.size() < code.size() ){
			return true;
		}
		return false;
	}

	private boolean allowedColor( String color ) {
		for( int i = 0 ; i < colors.length; i++ ){
			if( colors[i].equals(color)){
				return true;
			}
		}
		return false;
	}

	public boolean hasSecretCode() {
		if(code != null){
			return true;
		}
		return false;
	}

	public String attemptInput(ArrayList<String> inputCode) {
		
		validateInputCode(inputCode);
		
		inputCodes.add(inputCode);
		
		return "Accepted";
	}

	public HashMap<String, Integer> getScore() {
		
		int whites = calculateWhites();
		int blacks = calculateBlacks();
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		map.put("White", whites);
		map.put("Black", blacks);
		return map;
		
	}

	private int calculateBlacks() {
		List <String> input = inputCodes.get(inputCodes.size()-1);
		int counter = 0;
		for(int i = 0; i<code.size(); i++){
			if(code.get(i).equals(input.get(i))){
				counter ++;
			}
		}
		return counter;
	}

	private int calculateWhites() {
		List <String> input = inputCodes.get(inputCodes.size()-1);
		int counter = 0;
		for(String color : input){
			if(code.contains(color) && (code.indexOf(color) != input.indexOf(color))){
				counter++;
			}
		}
		return counter;
	}

}
