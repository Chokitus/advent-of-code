package br.chokitus.advent_code.days.day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import br.chokitus.advent_code.days.Day;
import br.chokitus.advent_code.days.day5.operations.OpCode;
import br.chokitus.advent_code.days.day5.operations.OpCode1;
import br.chokitus.advent_code.days.day5.operations.OpCode2;
import br.chokitus.advent_code.days.day5.operations.OpCode3;
import br.chokitus.advent_code.days.day5.operations.OpCode4;
import br.chokitus.advent_code.days.day5.operations.OpCode5;
import br.chokitus.advent_code.days.day5.operations.OpCode6;
import br.chokitus.advent_code.days.day5.operations.OpCode7;
import br.chokitus.advent_code.days.day5.operations.OpCode8;
import br.chokitus.advent_code.days.day5.operations.OpCode99;

public class Day5 implements Day {

	Map<String, OpCode> ops = new HashMap<>();

	public Day5() {
		ops.put("01", new OpCode1());
		ops.put("02", new OpCode2());
		ops.put("03", new OpCode3());
		ops.put("04", new OpCode4());
		ops.put("05", new OpCode5());
		ops.put("06", new OpCode6());
		ops.put("07", new OpCode7());
		ops.put("08", new OpCode8());
		ops.put("99", new OpCode99());
	}

	private void newExec(final List<Integer> list) {
		int pc = 0;
		OpCode opCode = parseOpCode(list.get(pc));
		while (!opCode.shouldStop()) {
			pc = opCode.apply(list, pc);
			opCode = parseOpCode(list.get(pc));
		}
	}

	private OpCode parseOpCode(final Integer integer) {
		final String fullOpCode = StringUtils.leftPad(String.valueOf(integer), 5, "0");
		final OpCode operation = ops.get(fullOpCode.substring(3));
		operation.parseMode(fullOpCode.substring(0, 3));
		return operation;
	}

	@Override
	public void run() {
		OpCode.setMyInput(5);
		newExec(Arrays.asList(3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 1101, 72, 36, 225, 1101, 87, 26, 225, 2,
				144, 13, 224, 101, -1872, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 2, 224, 1, 223, 224, 223, 1102,
				66, 61, 225, 1102, 25, 49, 224, 101, -1225, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 5, 224, 1,
				223, 224, 223, 1101, 35, 77, 224, 101, -112, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 2, 224, 1,
				223, 224, 223, 1002, 195, 30, 224, 1001, 224, -2550, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 1, 224,
				1, 224, 223, 223, 1102, 30, 44, 225, 1102, 24, 21, 225, 1, 170, 117, 224, 101, -46, 224, 224, 4, 224,
				1002, 223, 8, 223, 101, 5, 224, 224, 1, 224, 223, 223, 1102, 63, 26, 225, 102, 74, 114, 224, 1001, 224,
				-3256, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 3, 224, 1, 224, 223, 223, 1101, 58, 22, 225, 101, 13,
				17, 224, 101, -100, 224, 224, 4, 224, 1002, 223, 8, 223, 101, 6, 224, 224, 1, 224, 223, 223, 1101, 85,
				18, 225, 1001, 44, 7, 224, 101, -68, 224, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 5, 224, 1, 223, 224,
				223, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1,
				99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999,
				1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101,
				294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0,
				106, 0, 0, 1105, 1, 99999, 7, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 329, 101, 1, 223, 223, 8, 677,
				226, 224, 1002, 223, 2, 223, 1005, 224, 344, 1001, 223, 1, 223, 1107, 677, 677, 224, 102, 2, 223, 223,
				1005, 224, 359, 1001, 223, 1, 223, 1107, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 374, 101, 1, 223,
				223, 7, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 389, 101, 1, 223, 223, 8, 226, 677, 224, 1002, 223,
				2, 223, 1005, 224, 404, 101, 1, 223, 223, 1008, 226, 677, 224, 1002, 223, 2, 223, 1005, 224, 419, 1001,
				223, 1, 223, 107, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 434, 101, 1, 223, 223, 1108, 677, 226,
				224, 1002, 223, 2, 223, 1006, 224, 449, 101, 1, 223, 223, 1108, 677, 677, 224, 102, 2, 223, 223, 1006,
				224, 464, 101, 1, 223, 223, 1007, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 479, 101, 1, 223, 223,
				1008, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 494, 101, 1, 223, 223, 108, 226, 226, 224, 1002, 223,
				2, 223, 1006, 224, 509, 101, 1, 223, 223, 107, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 524, 101, 1,
				223, 223, 1107, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 539, 1001, 223, 1, 223, 108, 226, 677, 224,
				1002, 223, 2, 223, 1005, 224, 554, 101, 1, 223, 223, 1007, 226, 226, 224, 102, 2, 223, 223, 1005, 224,
				569, 101, 1, 223, 223, 8, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 584, 101, 1, 223, 223, 1008, 677,
				677, 224, 1002, 223, 2, 223, 1005, 224, 599, 1001, 223, 1, 223, 107, 226, 677, 224, 1002, 223, 2, 223,
				1005, 224, 614, 1001, 223, 1, 223, 1108, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 629, 101, 1, 223,
				223, 7, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 644, 1001, 223, 1, 223, 108, 677, 677, 224, 102, 2,
				223, 223, 1005, 224, 659, 101, 1, 223, 223, 1007, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 674, 101,
				1, 223, 223, 4, 223, 99, 226));
	}

	public static void main(final String[] args) {
		new Day5().run();
	}

}
