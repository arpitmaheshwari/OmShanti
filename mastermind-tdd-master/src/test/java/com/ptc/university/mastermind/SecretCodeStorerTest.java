package com.ptc.university.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class SecretCodeStorerTest {

	private MasterMind mastermind = new MasterMind();

	@Test
	public void shouldStoreFourUniqueColors() {
		Code code = new Code(CodeColour.RED,CodeColour.BLUE,CodeColour.GREEN,CodeColour.PINK);
		boolean stored = mastermind.storeSecretCode(code);
		Assert.assertTrue(stored);
	}
	
	@Test
	public void shouldStoreFourUniqueColors2() {
		Code code = new Code(CodeColour.RED,CodeColour.BROWN,CodeColour.GREEN,CodeColour.YELLOW);
		boolean stored = mastermind.storeSecretCode(code);
		Assert.assertTrue(stored);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNonUniqueColors() {
		Code code = new Code(CodeColour.RED,CodeColour.RED,CodeColour.GREEN,CodeColour.PINK);
		mastermind.storeSecretCode(code);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNonUniqueColors2() {
		Code code = new Code(CodeColour.RED,CodeColour.GREEN,CodeColour.RED,CodeColour.GREEN);
		mastermind.storeSecretCode(code);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForLessThanFourColors() {
		Code code = new Code(CodeColour.RED,CodeColour.BLUE,CodeColour.GREEN,null);
		mastermind.storeSecretCode(code);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForLessThanFourColors2() {
		Code code = new Code(CodeColour.RED,null,CodeColour.GREEN,null);
		mastermind.storeSecretCode(code);
	}
	
}
