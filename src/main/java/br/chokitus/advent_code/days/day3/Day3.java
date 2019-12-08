package br.chokitus.advent_code.days.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import br.chokitus.advent_code.days.Day;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

public class Day3 implements Day {

	public final Map<Character, Function<Integer, Function<Ponto, Ponto>>> actions = new HashMap<>();

	public Day3() {
		actions.put('R', intensidade -> origem -> origem.move(intensidade, 0));
		actions.put('L', intensidade -> origem -> origem.move(intensidade, 0));
		actions.put('U', intensidade -> origem -> origem.move(0, intensidade));
		actions.put('D', intensidade -> origem -> origem.move(0, intensidade));
	}

	@Getter
	@ToString
	private class Linha {
		private final Ponto ponto;
		private final Vetor vetor;
		private final Ponto destino;

		@ToString.Exclude
		private final Function<Linha, Integer> constraintDefiner;

		@ToString.Exclude
		private final Function<Linha, Integer> reachDefiner;

		public Linha(final Ponto ponto, final Vetor vetor, final Ponto destino) {
			this.ponto = ponto;
			this.vetor = vetor;
			this.destino = destino;
			constraintDefiner = vetor.isVertical() ? p -> p.getPonto().getY() : p -> p.getPonto().getX();
			reachDefiner = vetor.isVertical() ? p -> p.getPonto().getX() : p -> p.getPonto().getY();
		}
	}

	@Getter
	@RequiredArgsConstructor
	@ToString
	private class Ponto {
		final int x;
		final int y;
		final int steps;

		public Ponto move(final int x, final int y) {
			return new Ponto(x + this.x, y + this.y, steps + Math.abs(x + y));
		}
	}

	@Getter
	@ToString
	private class Vetor {

		public Vetor(final String action) {
			final char actionChar = action.charAt(0);
			vertical = actionChar == 'U' || actionChar == 'D';
			str = ("UR".indexOf(String.valueOf(actionChar)) >= 0 ? 1 : -1) * Integer.valueOf(action.substring(1));
			mover = actions.get(actionChar).apply(str);
		}

		int str;
		boolean vertical;
		Function<Ponto, Ponto> mover;
	}

	@RequiredArgsConstructor
	@Getter
	@ToString
	private class Intersection {
		final int distance;
		final int steps;
	}

	final String input1 = "R990,D362,L316,U101,R352,U798,L314,D564,R961,D634,L203,U601,R973,U227,R996,D639,L868,D135,L977,D201,R911,D486,R906,U719,L546,U324,R302,D200,L879,D206,L872,U681,R628,D272,R511,D827,L929,U915,L399,U696,R412,D640,R234,U487,R789,U354,L620,D914,L7,D228,L55,D591,L250,D228,R816,U935,R553,U98,L833,D418,R582,D793,R804,U283,R859,D206,L842,U663,L935,U495,L995,D181,R75,D33,R126,U489,L894,D675,R33,U239,L623,D931,L830,U63,R77,D576,L85,D415,R443,U603,R654,U495,L273,U583,R10,D648,L840,U904,R489,D655,R997,U559,L614,U917,R809,U540,L41,U519,R256,U111,R29,D603,L931,U518,R443,D51,L788,U483,L665,U890,L392,D701,R907,D125,L438,D107,L266,U766,R743,D343,R898,U293,L318,U417,L23,U44,L668,U614,R83,U31,R452,U823,R16,D418,R68,U823,L53,D638,L394,D714,R992,U196,R913,D526,L458,U428,L412,U901,R610,U348,L904,D815,R274,U439,R207,D81,L20,D507,L179,U249,L221,U603,L897,U490,R127,U99,L709,U925,L818,D777,R292,U935,R801,U331,R412,U759,L698,D53,L969,U492,L502,D137,R513,D999,L808,D618,L240,U378,L284,D726,L609,U530,R537,D36,L504,D26,R244,D692,L186,U767,L690,U182,R559,D926,R706,D132,L325,D846,R494,U238,L519,U655,R57,U658,L471,D717,L964,D346,L448,U286,L457,D504,R614,U652,R583,D780,R882,U417,R573,D297,L144,U347,L254,D589,L387,U309,L88,D510,R435,U636,L640,U801,R774,U678,R247,D846,L775,U527,L225,U798,R577,U897,R11,U153,L297,D748,L284,U806,R512,U906,L181,U39,R264,D47,L561,D441,L181,U210,L278,U998,R256,D278,R350,U466,L335,D310,L4,U298,L531,D423,R851,U285,L235,D139,R209,U882,R801,D36,L777,D153,L63";
	final String input2 = "L995,D598,R577,U346,L797,D375,R621,D709,R781,U55,R965,U327,L479,U148,L334,U93,R644,U632,L557,D136,L690,D548,R982,D703,L971,U399,R600,D785,L504,U984,R18,U190,L755,D737,L787,D921,R303,U513,L544,U954,L814,U239,R550,D458,R518,D538,R362,D350,L103,U17,L362,D480,L80,U639,L361,D75,L356,D849,R635,U633,R934,U351,L314,U960,R657,U802,L687,U385,L558,D984,L996,U765,L147,D366,R908,U981,R44,U336,R396,U85,R819,D582,L21,D920,L627,D103,R922,U195,L412,D385,L159,U446,L152,U400,L303,U549,R734,D709,R661,U430,R177,U857,L53,U555,R35,D919,L163,D630,L162,U259,R46,D89,R965,D410,R37,U39,R621,D606,L816,D659,L668,D418,L775,D911,R296,U488,L129,U869,L455,U663,L942,U813,L274,D677,R161,D338,R455,D580,R976,D984,L336,U742,R334,U130,L210,U523,R958,U177,R126,U469,L513,D14,L772,D423,L369,D661,R167,D449,L685,U871,L930,U630,L54,D581,L921,U839,R782,D844,L581,D995,R110,U365,L594,D595,R391,D298,R297,U469,L148,D34,R5,D609,L654,U172,R940,D858,L682,D92,R395,D683,R947,U311,L850,U151,R452,U641,L599,D640,R86,U584,L518,D597,L724,D282,L691,D957,L119,U30,L8,D514,R237,U599,R775,U413,R802,D132,R925,U133,L980,D981,R272,U632,R995,U427,R770,D722,L817,D609,R590,D799,L699,U923,L881,U893,R79,U327,L405,D669,L702,D612,R895,D132,R420,U958,L955,U993,L817,D492,R453,D342,L575,D253,R97,U54,R456,U748,L912,U661,L987,D182,L816,U218,R933,D797,L207,D71,R546,U578,L894,D536,L253,D525,L164,D673,R784,U915,L774,U586,R733,D80,L510,U449,L403,D915,L612,D325,L470,U179,L460,U405,R297,D803,R637,U893,R565,U952,R550,U936,R378,D932,L669";

	public static void main(final String[] args) {
		new Day3().run();
	}

	@Override
	public void run() {
		final List<Linha> linhas1 = new ArrayList<>();
		final List<Vetor> vetores = new ArrayList<>();

		Ponto oldPonto = new Ponto(0, 0, 0);

		parseInput(input1, vetores);
		for (final Vetor vetor : vetores) {
			final Ponto newPonto = vetor.getMover().apply(oldPonto);
			final Linha linha = new Linha(oldPonto, vetor, newPonto);
			linhas1.add(linha);
			oldPonto = newPonto;
		}

		oldPonto = new Ponto(0, 0, 0);
		parseInput(input2, vetores);

		final List<Intersection> intersects = new ArrayList<>();
		for (final Vetor vetor : vetores) {
			final Ponto newPonto = vetor.getMover().apply(oldPonto);
			final Linha linha = new Linha(oldPonto, vetor, newPonto);
			oldPonto = newPonto;
			linhas1.stream()
			.filter(origin -> isPerpendicular(origin, linha))
			.filter(origin -> isBetween(origin, linha))
			.filter(origin -> doesReach(origin, linha))
			.map(origin -> getDistance(origin, linha))
			.forEach(intersects::add);
		}
		final Comparator<Intersection> bySteps = (a, b) -> a.getSteps() - b.getSteps();
		final Comparator<Intersection> byDistance = (a, b) -> a.getDistance() - b.getDistance();
		intersects.sort(bySteps);
		intersects.forEach(System.out::println);
	}

	public Intersection getDistance(final Linha origem, final Linha linha) {

		final Ponto inter = origem.getVetor().isVertical() ?				new Ponto(origem.getPonto().getX(), linha.getPonto().getY(), origem.getPonto().getSteps() + linha.getPonto().getSteps()) :
					new Ponto(linha.getPonto().getX(), origem.getPonto().getY(), origem.getPonto().getSteps() + linha.getPonto().getSteps());
		final int distance = Math.abs(inter.getX()) + Math.abs(inter.getY());

		if (origem.getPonto().getSteps() + linha.getPonto().getSteps() == 7625) {
			System.out.println("a");
		}
		return new Intersection(distance, inter.steps + distance(inter, linha.getPonto()) + distance(inter, origem.getPonto()));
	}

	private int distance(final Ponto inter, final Ponto ponto) {
		return Math.abs(inter.getX() - ponto.getX()) + Math.abs(inter.getY() - ponto.getY());
	}

	private boolean doesReach(final Linha origem, final Linha linha) {
		final Integer keyCoordinate = linha.getReachDefiner().apply(origem);
		final Integer lineCoordinate = linha.getReachDefiner().apply(linha);
		if (origem.getPonto().getSteps() + linha.getPonto().getSteps() == 7625) {
			System.out.println("a");
		}
		return keyCoordinate <= lineCoordinate && keyCoordinate + origem.vetor.str >= lineCoordinate
				|| keyCoordinate + origem.vetor.str <= lineCoordinate && keyCoordinate >= lineCoordinate;
	}

	private boolean isPerpendicular(final Linha p, final Linha linha) {
		return linha.vetor.isVertical() != p.vetor.isVertical();
	}

	private boolean isBetween(final Linha origem, final Linha linha) {
		final Integer chave = linha.constraintDefiner.apply(origem);
		int menor = 0;
		int maior = 0;
		if (linha.vetor.str < 0) {
			maior = linha.constraintDefiner.apply(linha);
			menor = maior + linha.vetor.str;
		} else {
			menor = linha.constraintDefiner.apply(linha);
			maior = menor + linha.vetor.str;
		}
		if (origem.getPonto().getSteps() + linha.getPonto().getSteps() == 7625) {
			System.out.println("a");
		}
		return chave <= maior && chave >= menor;
	}

	private void parseInput(final String input, final List<Vetor> vetores) {
		vetores.clear();
		for (final String act : input.split(",")) {
			vetores.add(new Vetor(act));
		}
	}
}
