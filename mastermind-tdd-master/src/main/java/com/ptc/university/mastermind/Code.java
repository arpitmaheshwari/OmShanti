package com.ptc.university.mastermind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code {

	private CodeColour first;
	private CodeColour second;
	private CodeColour third;
	private CodeColour fourth;

	public Code(CodeColour first, CodeColour second, CodeColour third, CodeColour fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public CodeColour getFirst() {
		return first;
	}

	public CodeColour getSecond() {
		return second;
	}

	public CodeColour getThird() {
		return third;
	}

	public CodeColour getFourth() {
		return fourth;
	}

}
