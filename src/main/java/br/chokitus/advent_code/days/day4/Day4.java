package br.chokitus.advent_code.days.day4;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.chokitus.advent_code.days.Day;

public class Day4 implements Day {

	private final int maior = 919123;
	private final int menor = 387638;

	@Override
	public void run() {
		final List<String> possible = new ArrayList<>();
		for (int i = menor; i <= maior; i++) {
			possible.add(StringUtils.leftPad(String.valueOf(i), 6, "0"));
		}
		System.out.println(possible.stream()
				.filter(Day4::doNotDecrease)
				.filter(Day4::hasDouble).count());
//		.forEach(System.out::println);
	}

	public static boolean doNotDecrease(final String valor) {
		for(int i = 0; i < 5; i++) {
			if(Integer.valueOf(valor.charAt(i)) > Integer.valueOf(valor.charAt(i+1))) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasDouble(final String valor) {
		boolean d = false;
		int count = 1;
		for (int i = 0; i < 5; i ++) {
			if (valor.charAt(i) == valor.charAt(i + 1)) {
				count++;
			} else {
				if(count == 2) {
					d = true;
				}
				count = 1;
			}
		}
		if(count == 2) {
			d = true;
		}
		return d;
	}

	public static void main(final String[] args) {
		new Day4().run();
	}
}
