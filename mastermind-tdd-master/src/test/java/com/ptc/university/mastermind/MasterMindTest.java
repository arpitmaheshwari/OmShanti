package com.ptc.university.mastermind;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class MasterMindTest {

	@Test
	public void storeSecretCode() {

		ArrayList<String> code = getDummyCode();  

		MasterMind game = new MasterMind(code);

		assertEquals(game.hasSecretCode(),true);

	}

	
	private ArrayList<String> getDummyCode() {
		ArrayList<String> code= new ArrayList<String>();

		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		return code;
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotHaveMoreThan4Colors() {

		ArrayList<String> code= new ArrayList<String>();

		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); code.add("Pink");

		MasterMind game = new MasterMind(code);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotHaveLessThan4Colors() {
		ArrayList<String> code= new ArrayList<String>();

		code.add("Red"); code.add("Blue"); code.add("Green"); 

		MasterMind game = new MasterMind(code);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotBeNull() {
		ArrayList code = null;
		MasterMind game = new MasterMind(code);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotBeEmpty() {
		ArrayList <String>code = new ArrayList<String>();
		MasterMind game = new MasterMind(code);
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotHaveDuplicates() {
		ArrayList<String> code= new ArrayList<String>();

		code.add("Red"); code.add("Blue"); code.add("Green");
		code.add("Green");

		MasterMind game = new MasterMind( code );
	}

	@Test(expected=IllegalArgumentException.class)
	public void secretCodeShouldNotColorOtherThanGiven() {

		ArrayList<String> code= new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green");
		code.add("Black");
		MasterMind game = new MasterMind( code );

	}

	@Test
	public void inputAttempt1() {
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		//Input
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Blue"); inputCode.add("Green"); inputCode.add("Yellow"); 
		assertEquals(game.attemptInput(inputCode),"Accepted");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inputAttempt2() {
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		
		//Input
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Blue"); inputCode.add("Green"); 
		game.attemptInput(inputCode);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inputAttempt3() {
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		
		//Input
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Blue"); inputCode.add("Green"); inputCode.add("Green"); 
		game.attemptInput(inputCode);
		
		ArrayList<String> inputCode2 = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Pink"); inputCode.add("Green"); inputCode.add("Green"); 
		game.attemptInput(inputCode2);
	}
	
	/*
	 * Scoring Test Cases
	 */
	
	@Test
	public void test2Black2White(){
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Blue"); inputCode.add("Yellow"); inputCode.add("Green"); 
		game.attemptInput(inputCode);
		
		HashMap <String, Integer> scoreMap = game.getScore();
		assertEquals(scoreMap.get("White"), new Integer(2));
		assertEquals(scoreMap.get("Black"), new Integer(2));

	}
	
	@Test
	public void testAllBlack(){
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Red"); inputCode.add("Blue"); inputCode.add("Green"); inputCode.add("Yellow"); 
		game.attemptInput(inputCode);
		
		HashMap <String, Integer> scoreMap = game.getScore();
		assertEquals(scoreMap.get("White"), new Integer(0));
		assertEquals(scoreMap.get("Black"), new Integer(4));

	}
	
	@Test
	public void testAllWhite(){
		
		ArrayList<String> code = new ArrayList<String>();
		code.add("Red"); code.add("Blue"); code.add("Green"); code.add("Yellow"); 
		MasterMind game = new MasterMind(code);
		
		ArrayList<String> inputCode = new ArrayList<>();
		inputCode.add("Yellow"); inputCode.add("Green"); inputCode.add("Blue"); inputCode.add("Red"); 
		game.attemptInput(inputCode);
		
		HashMap <String, Integer> scoreMap = game.getScore();
		assertEquals(scoreMap.get("White"), new Integer(4));
		assertEquals(scoreMap.get("Black"), new Integer(0));

	}
	
	
}
