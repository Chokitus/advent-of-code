package br.chokitus.advent_code.days.day5.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import lombok.Getter;
import lombok.Setter;

public abstract class OpCode implements Operation {

	protected String modesString;

	@Setter
	@Getter
	private static Integer myInput;

	@FunctionalInterface
	protected interface TriConsumer {
		void consume(List<Integer> list, Integer position, Integer value);
	}

	protected final List<BiFunction<List<Integer>, Integer, Integer>> inputModes = new ArrayList<>();
	protected TriConsumer outputMode;

	public void parseMode(final String modesString) {
		this.modesString = modesString;
	}

	protected BiFunction<List<Integer>, Integer, Integer> parseInput(final char charToMode) {
		if(charToMode == '0') {
			return Operation::getPosMode;
		}
		return Operation::getImmMode;
	}

	protected TriConsumer parseOutput(final char charToMode) {
		if(charToMode == '0') {
			return Operation::setPosMode;
		}
		return Operation::setImmMode;
	}
}
