package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public class OpCode4 extends OpCode {

	public OpCode4() {
		outputMode = (list, pos, value) -> System.out.println(inputModes.get(0).apply(list, pos));
	}

	@Override
	public Integer apply(final List<Integer> list, final int posOfOpCode) {
//		System.out.println("Printando na posição!");
		outputMode.consume(list, posOfOpCode+1, -999);
		return posOfOpCode + getNumParameters();
	}

	@Override
	public int getNumParameters() {
		return 2;
	}

	@Override
	public void parseMode(final String modesString) {
		super.parseMode(modesString);
		inputModes.clear();
		inputModes.add(parseInput(modesString.charAt(2)));
	}

}
