package br.chokitus.advent_code.days.day5.operations;

import java.util.List;

public interface Operation {

	Integer apply(List<Integer> list, int posOfOpCode);
	int getNumParameters();

	default boolean shouldStop() {
		return false;
	}

	static Integer getPosMode(final List<Integer> list, final int position) {
		return list.get(list.get(position));
	}

	static void setPosMode(final List<Integer> list, final int position, final int value) {
		list.set(list.get(position), value);
	}

	static Integer getImmMode(final List<Integer> list, final int position) {
		return list.get(position);
	}

	static void setImmMode(final List<Integer> list, final int position, final int value) {
		list.set(position, value);
	}

	static Integer getInputFromUser(final List<Integer> list, final int position) {
		return OpCode.getMyInput();
	}
}
