package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public class OpCode99 extends OpCode {

	public OpCode99() {
		outputMode = (list, pos, value) -> System.out.println(inputModes.get(0).apply(list, pos));
	}

	@Override
	public Integer apply(final List<Integer> list, final int posOfOpCode) {
		System.out.println("Parando!!!!!!");
		return posOfOpCode + getNumParameters();
	}

	@Override
	public int getNumParameters() {
		return 1;
	}

	@Override
	public void parseMode(final String modesString) {
		inputModes.clear();
		inputModes.add(parseInput(modesString.charAt(2)));
	}

	@Override
	public boolean shouldStop() {
		return true;
	}

}
