package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public class OpCode5 extends OpCode {

	@Override
	public Integer apply(final List<Integer> list, final int posOfOpCode) {
		final Integer input1 = inputModes.get(0).apply(list, posOfOpCode+1);
		if(input1 > 0) {
			return inputModes.get(1).apply(list, posOfOpCode+2);
		}
		return posOfOpCode + getNumParameters();
	}

	@Override
	public int getNumParameters() {
		return 3;
	}

	@Override
	public void parseMode(final String modesString) {
		super.parseMode(modesString);
		inputModes.clear();
		inputModes.add(parseInput(modesString.charAt(2)));
		inputModes.add(parseInput(modesString.charAt(1)));
	}

}
