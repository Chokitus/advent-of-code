package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public class OpCode7 extends OpCode {

	@Override
	public Integer apply(final List<Integer> list, final int posOfOpCode) {
		final Integer input1 = inputModes.get(0).apply(list, posOfOpCode + 1);
		final Integer input2 = inputModes.get(1).apply(list, posOfOpCode + 2);
		outputMode.consume(list, posOfOpCode + 3, input1 < input2 ? 1 : 0);
		return posOfOpCode + getNumParameters();
	}

	@Override
	public int getNumParameters() {
		return 4;
	}

	@Override
	public void parseMode(final String modesString) {
		super.parseMode(modesString);
		inputModes.clear();
		inputModes.add(parseInput(modesString.charAt(2)));
		inputModes.add(parseInput(modesString.charAt(1)));
		outputMode = parseOutput(modesString.charAt(0));
	}

}
