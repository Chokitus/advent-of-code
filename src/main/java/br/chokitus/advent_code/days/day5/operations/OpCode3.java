package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public class OpCode3 extends OpCode {

	public OpCode3() {
		inputModes.add(Operation::getInputFromUser);
		outputMode = Operation::setPosMode;
	}

	@Override
	public Integer apply(final List<Integer> list, final int posOfOpCode) {
		final Integer input1 = inputModes.get(0).apply(list, posOfOpCode+1);
		outputMode.consume(list, posOfOpCode+1, input1);
		return posOfOpCode + getNumParameters();
	}

	@Override
	public int getNumParameters() {
		return 2;
	}
}
