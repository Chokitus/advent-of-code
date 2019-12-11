package br.chokitus.advent_code.days.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.chokitus.advent_code.days.Day;

public class Day6 implements Day {

	Map<String, Orbiter> map = new HashMap<>();

	private class Orbiter {
		private final List<Orbiter> orbiters = new ArrayList<>();

		public void addOrbiter(final Orbiter orb) {
			orbiters.add(orb);
		}
	}

	private void parse(final String orbited, final String orbiter) {
		final Orbiter orbitedObj = getOrbit(orbited);
		final Orbiter orbiterObj = getOrbit(orbiter);
		orbitedObj.addOrbiter(orbiterObj);
	}

	private Orbiter getOrbit(final String orbit) {
		if (map.containsKey(orbit)) {
			return map.get(orbit);
		}
		final Orbiter orbiter = new Orbiter();
		map.put(orbit, orbiter);
		return orbiter;
	}

	@Override
	public void run() {
		input.lines().map(p -> p.split("\\)")).forEach(p -> parse(p[0], p[1]));
//		testInput.lines().map(p -> p.split("\\)")).forEach(p -> parse(p[0], p[1]));
		final Orbiter orbiter = map.get("COM");
		final Map<Integer, Integer> count = new HashMap<>();

		List<Orbiter> list = new ArrayList<>(Arrays.asList(orbiter));
		int degree = 0;
		do {
			final List<Orbiter> newList = new ArrayList<>();
			for (final Orbiter orbit : list) {
				for (final Orbiter newOrbit : orbit.orbiters) {
					newList.add(newOrbit);
				}
			}
			count.put(degree++, list.size());
			list = newList;
		} while (!list.isEmpty());
		degree = 0;
		int totalCount = 0;
		while (count.get(degree) != null) {
			totalCount += count.get(degree) * degree++;
		}
		System.out.println(count);
		System.out.println(totalCount);

	}

	public static void main(final String[] args) {
		new Day6().run();
	}

	String testInput = "COM)B\n" + "B)C\n" + "C)D\n" + "D)E\n" + "E)F\n" + "B)G\n" + "G)H\n" + "D)I\n" + "E)J\n"
			+ "J)K\n" + "K)L\n";

	String input = "P1T)TR7\n" + "3NS)SL6\n" + "JMH)MLH\n" + "K57)Z9Q\n" + "F4G)TCS\n" + "LLY)5D3\n" + "6KR)J86\n"
			+ "SH2)TMQ\n" + "5WZ)Z2M\n" + "ZLL)XYP\n" + "F4R)NT5\n" + "36G)8KS\n" + "7LB)YRG\n" + "V9L)585\n"
			+ "22Y)KT1\n" + "5DN)KY3\n" + "Q2W)YNJ\n" + "VRK)FVT\n" + "ZL3)59Z\n" + "75K)QC8\n" + "GPB)5V8\n"
			+ "S4B)N8N\n" + "WQG)4R7\n" + "HJ1)PYT\n" + "LD6)ZPY\n" + "72F)42V\n" + "GP3)GSX\n" + "QJV)RJZ\n"
			+ "S88)3B1\n" + "Q7Y)T1L\n" + "JL9)2CN\n" + "CVS)BZH\n" + "7DF)5T6\n" + "Z4G)5SD\n" + "XHJ)SN3\n"
			+ "XF7)J8C\n" + "K3P)6S7\n" + "JLM)7KS\n" + "6JS)75X\n" + "12Y)CRB\n" + "5GS)71S\n" + "2BW)RT5\n"
			+ "X7F)1VJ\n" + "H9T)L2K\n" + "WKY)YPH\n" + "Z3X)MT5\n" + "R83)HYS\n" + "7QY)YQV\n" + "LMD)SAN\n"
			+ "SD3)C8V\n" + "44R)ZJG\n" + "78Y)X4F\n" + "NQP)9P4\n" + "GQG)MRV\n" + "1ZK)1W6\n" + "LWY)Z9M\n"
			+ "NBS)8G7\n" + "VTV)1ZK\n" + "L77)DDQ\n" + "Y9H)8KD\n" + "DTL)T6T\n" + "MCC)3ZX\n" + "7J3)YMZ\n"
			+ "XS1)26Z\n" + "V2F)ZQ6\n" + "68X)Z7N\n" + "F4G)283\n" + "BX7)495\n" + "CH1)7K3\n" + "R2N)S99\n"
			+ "1T4)B4F\n" + "177)8W7\n" + "N7L)3T4\n" + "97G)F7W\n" + "QMJ)K3N\n" + "TTK)ZTW\n" + "NQN)698\n"
			+ "YQ3)R83\n" + "TN1)76X\n" + "ZS3)89H\n" + "46Y)3ZR\n" + "56V)7V7\n" + "J3J)5L4\n" + "31N)NRZ\n"
			+ "MJC)NFJ\n" + "8HB)S4W\n" + "L8N)YNH\n" + "MXB)B9J\n" + "Z12)7LB\n" + "7YP)M93\n" + "4JP)FH2\n"
			+ "5QN)4SH\n" + "H2F)GWK\n" + "9JF)M3J\n" + "ZZJ)X6Y\n" + "PCL)J91\n" + "FZM)LWX\n" + "9N5)2KQ\n"
			+ "VLQ)KD2\n" + "N9B)STL\n" + "M9G)DYV\n" + "NFJ)R78\n" + "PZ1)R1Q\n" + "JMM)RJJ\n" + "NM8)KTH\n"
			+ "V48)Q2C\n" + "QX7)9MB\n" + "SCG)JPR\n" + "N1G)96H\n" + "8BD)BSH\n" + "PMS)75K\n" + "J2S)ML9\n"
			+ "L32)29L\n" + "TQS)VN8\n" + "ZJG)1M7\n" + "PT2)JWZ\n" + "7Q4)PVJ\n" + "38Z)TD4\n" + "LJM)676\n"
			+ "VRK)Y9H\n" + "ZLZ)KF2\n" + "HYW)XCM\n" + "L3Z)M3M\n" + "9H7)FDW\n" + "BYQ)C9Z\n" + "4H9)PHX\n"
			+ "TLQ)Z99\n" + "7WW)BNC\n" + "NS4)TS7\n" + "CF8)PMS\n" + "BHJ)19P\n" + "CT8)4Z5\n" + "GDR)61S\n"
			+ "Y46)36B\n" + "FM3)565\n" + "5PQ)VMG\n" + "JQ4)PSS\n" + "QLT)2MX\n" + "975)DPS\n" + "DYC)XS3\n"
			+ "Y11)SD3\n" + "YL4)9W9\n" + "SDH)YFD\n" + "96R)X23\n" + "92D)VZG\n" + "V7G)954\n" + "CJ3)Y8F\n"
			+ "GRY)45K\n" + "Z78)VM1\n" + "CRB)2J3\n" + "PTK)39Z\n" + "C8D)2VY\n" + "4R7)16Z\n" + "HQM)SCG\n"
			+ "Y82)SC1\n" + "CRG)RKZ\n" + "YSC)DWW\n" + "VH6)QX7\n" + "GWK)WM2\n" + "1W6)PWJ\n" + "LWG)B4K\n"
			+ "B7Z)5GS\n" + "MS8)5FK\n" + "QY6)F5G\n" + "QB3)5R5\n" + "TXR)V96\n" + "QL6)PV7\n" + "D5M)145\n"
			+ "K27)WTX\n" + "LB7)8BC\n" + "J1Q)V49\n" + "RWL)SQ6\n" + "B4K)M5T\n" + "Y1D)5QL\n" + "BJ6)4RP\n"
			+ "BXH)QM7\n" + "MPT)BVQ\n" + "G56)9V7\n" + "NYP)9C5\n" + "SDK)95K\n" + "1BX)3F8\n" + "15N)4VQ\n"
			+ "4V7)Z2W\n" + "S7Q)PDS\n" + "RM4)FYP\n" + "ZW3)7D9\n" + "Z9Q)K7G\n" + "YKF)9TB\n" + "JG9)Y1R\n"
			+ "VMD)NQP\n" + "5B4)WQ2\n" + "D5J)63S\n" + "VKJ)MC9\n" + "3RN)32K\n" + "BRK)PXV\n" + "P59)VKZ\n"
			+ "PSK)6KV\n" + "C6N)RHK\n" + "11F)RPT\n" + "Z8Q)472\n" + "V3D)97S\n" + "8J4)1T8\n" + "S8T)W6D\n"
			+ "PVJ)FVR\n" + "CRB)NDJ\n" + "26Z)7GC\n" + "YZV)4J8\n" + "6BK)9S6\n" + "5SD)VZB\n" + "FM7)L76\n"
			+ "QG6)XZM\n" + "DDQ)46Y\n" + "WNK)F4G\n" + "W1R)L1Q\n" + "T1M)S9Q\n" + "GWP)Z59\n" + "9HD)K88\n"
			+ "XKJ)VJS\n" + "YG7)BDZ\n" + "3T4)CH1\n" + "WTX)FM7\n" + "31W)TP6\n" + "7ZN)TH2\n" + "D1Q)MVY\n"
			+ "Y9Y)K93\n" + "VN8)75L\n" + "VSJ)44R\n" + "D95)ZLZ\n" + "3YQ)DC3\n" + "T15)HC3\n" + "HRV)K9F\n"
			+ "3F8)D5Q\n" + "RRF)Z78\n" + "XZM)73S\n" + "GBK)82T\n" + "HWF)LZ9\n" + "SWS)9LG\n" + "TJL)Q5V\n"
			+ "MYB)7F1\n" + "3Y8)PV1\n" + "DD6)6HF\n" + "X49)C8D\n" + "QC8)ZW3\n" + "9MS)9VX\n" + "49G)GXH\n"
			+ "5W9)4JW\n" + "6TS)3W6\n" + "D4P)C12\n" + "BNJ)YTY\n" + "3PP)36K\n" + "XVV)STY\n" + "SL6)TNL\n"
			+ "R2B)N3R\n" + "RM9)SWS\n" + "X8L)WH7\n" + "4SH)1CF\n" + "R6P)TRQ\n" + "MJM)727\n" + "Q7C)RNF\n"
			+ "NT5)F4M\n" + "2ST)41Z\n" + "T5S)HVK\n" + "8KP)P59\n" + "FRK)DR3\n" + "SR2)F4B\n" + "BQH)NF6\n"
			+ "SL5)5BB\n" + "9V4)K27\n" + "D97)KLS\n" + "42B)NS4\n" + "RDN)Y9M\n" + "2Q8)H2J\n" + "Z6D)GDZ\n"
			+ "HTZ)TZX\n" + "DB1)5P5\n" + "FVR)Z82\n" + "PD2)L32\n" + "37G)M49\n" + "8PV)6JM\n" + "7LJ)8H9\n"
			+ "69P)BXH\n" + "ZQJ)924\n" + "HSR)DTJ\n" + "WF2)CSV\n" + "53J)SJS\n" + "L94)QGJ\n" + "HX7)K9J\n"
			+ "9W9)T2D\n" + "YMZ)VD5\n" + "SJV)138\n" + "V9H)JGY\n" + "BJW)78V\n" + "CZ2)TR8\n" + "MKC)W5R\n"
			+ "2CN)YG8\n" + "BFX)7QY\n" + "MB1)54Q\n" + "SVM)QPT\n" + "Z21)R6P\n" + "YW4)FJQ\n" + "S1W)NM5\n"
			+ "919)975\n" + "RFQ)1JT\n" + "53G)6JS\n" + "R2B)DLB\n" + "8W7)2BW\n" + "KLS)4CG\n" + "3L6)YJY\n"
			+ "56K)5QF\n" + "S99)72L\n" + "R5G)2QV\n" + "C6R)9HD\n" + "676)3B5\n" + "8N9)24S\n" + "ZYN)ST9\n"
			+ "7TB)S6L\n" + "689)MBJ\n" + "QGS)XZS\n" + "YGH)SRP\n" + "865)H27\n" + "YJY)RHY\n" + "JTZ)C5T\n"
			+ "JZB)6F3\n" + "2Q6)YG7\n" + "6LZ)R9Z\n" + "F5G)CQ3\n" + "NK6)N1C\n" + "R41)49G\n" + "GNC)J8Q\n"
			+ "258)X6J\n" + "P67)7YX\n" + "7J8)PWS\n" + "P5B)YW4\n" + "N18)T89\n" + "W67)RFQ\n" + "1CV)YBH\n"
			+ "Y73)T1Z\n" + "JM9)TPJ\n" + "RP6)783\n" + "Z4J)LB7\n" + "K3N)4F4\n" + "6JM)NPS\n" + "RZD)2ZC\n"
			+ "JTZ)QBX\n" + "TCS)3LD\n" + "HQL)CW5\n" + "J82)XJ3\n" + "6F3)8ZN\n" + "NRZ)X27\n" + "4DK)FB1\n"
			+ "339)WFC\n" + "973)S4B\n" + "D4N)X49\n" + "LWX)FCP\n" + "45K)TT6\n" + "F1B)WJF\n" + "YPH)ZPJ\n"
			+ "BVD)DCC\n" + "3FR)5MZ\n" + "CR2)3PP\n" + "FZG)SNR\n" + "18M)RRQ\n" + "2PR)C7H\n" + "DX6)DJV\n"
			+ "VMG)NK2\n" + "843)WLT\n" + "MY4)XPZ\n" + "QPB)53G\n" + "RZH)B2K\n" + "13Y)B95\n" + "6LS)1T4\n"
			+ "G9N)F55\n" + "RLR)9R7\n" + "8RV)HCG\n" + "73S)K57\n" + "J9N)QD8\n" + "576)QGS\n" + "J5Y)4CC\n"
			+ "F25)1C6\n" + "52D)BQH\n" + "RX4)WVZ\n" + "X1Z)BV2\n" + "4ZX)F4P\n" + "GMJ)4D7\n" + "JB5)GT7\n"
			+ "KTL)T4S\n" + "W8N)XCW\n" + "J8Q)N2G\n" + "Q98)YRX\n" + "WV2)SLL\n" + "12T)53K\n" + "6S7)CK5\n"
			+ "2RW)WPR\n" + "S84)F25\n" + "RV4)PB5\n" + "QZG)15P\n" + "8RQ)9KD\n" + "Z45)96R\n" + "PVJ)F4R\n"
			+ "HMT)F54\n" + "96H)4Z8\n" + "TS1)PCL\n" + "VS1)G33\n" + "Q6L)JZB\n" + "XPM)WF8\n" + "QJF)2YY\n"
			+ "PV7)VTV\n" + "MSJ)KPJ\n" + "RB5)61Z\n" + "SFD)TR5\n" + "8CJ)MYB\n" + "7HW)DNT\n" + "5FK)CPL\n"
			+ "2BP)2FK\n" + "6D5)48N\n" + "83G)956\n" + "8HB)J3F\n" + "JGY)XN1\n" + "ZRD)FSF\n" + "4CG)VYJ\n"
			+ "6QW)FHP\n" + "T9P)KW4\n" + "B9J)GF6\n" + "X8C)8J4\n" + "ML7)R4C\n" + "W7D)1VB\n" + "Q6Q)NQN\n"
			+ "Q69)ZYN\n" + "53K)5TX\n" + "9TB)973\n" + "BSR)HK3\n" + "T8X)GTN\n" + "29L)ZRB\n" + "GG3)JL9\n"
			+ "WKN)D4N\n" + "32K)W69\n" + "JPR)WDB\n" + "4H9)PK2\n" + "4BL)X6X\n" + "ZXH)KZ7\n" + "WGY)D1N\n"
			+ "DF9)49P\n" + "KBD)WFB\n" + "71S)5B4\n" + "5HC)D9J\n" + "SGW)R6R\n" + "QSF)D97\n" + "KC4)4B6\n"
			+ "8MN)2T7\n" + "3MC)C6R\n" + "CY8)CZ2\n" + "2QR)M2X\n" + "6T1)F1B\n" + "TFZ)YRV\n" + "WGJ)R31\n"
			+ "JW7)HB7\n" + "T9B)GX7\n" + "YG8)W1B\n" + "51W)DCP\n" + "T89)NY7\n" + "P3G)PCS\n" + "GYH)DNM\n"
			+ "KN3)27M\n" + "VZB)1W8\n" + "Z6S)LD3\n" + "SYN)4D4\n" + "DR3)3FG\n" + "QD8)J1Q\n" + "PCS)NYP\n"
			+ "L65)DN6\n" + "BDN)WGJ\n" + "5P5)WD2\n" + "DCC)DKR\n" + "Z1Y)6CX\n" + "T6L)Y25\n" + "PHX)VKJ\n"
			+ "STJ)PGB\n" + "HVK)SYM\n" + "SLC)56V\n" + "CV8)F1D\n" + "CK5)R5X\n" + "YND)6T1\n" + "11S)Z1Y\n"
			+ "MTL)M9M\n" + "8XF)D96\n" + "85Z)NSY\n" + "TQ9)QR9\n" + "RHY)X8L\n" + "TS1)89S\n" + "5DN)88C\n"
			+ "W3S)GG9\n" + "DTJ)T5Y\n" + "YK6)H2M\n" + "Z82)J2P\n" + "D3G)RL2\n" + "61Z)11F\n" + "19Q)ZVW\n"
			+ "X6Y)RC3\n" + "NBS)Z69\n" + "1VJ)Q7F\n" + "2F4)9M6\n" + "8BD)CBZ\n" + "1JT)2ZB\n" + "4FG)CJ3\n"
			+ "GG9)177\n" + "36B)T44\n" + "WGV)2ST\n" + "H9Y)WV2\n" + "WLN)9MZ\n" + "F24)46P\n" + "FYP)9DF\n"
			+ "N86)6MT\n" + "GP3)3YL\n" + "F55)CSK\n" + "3HH)J1F\n" + "Y5V)QQ8\n" + "D3S)K1V\n" + "2HC)1H1\n"
			+ "KM9)3WZ\n" + "5L8)WXB\n" + "TZB)F7H\n" + "26G)NK6\n" + "NR1)B3H\n" + "GXH)R45\n" + "QFT)DC7\n"
			+ "4TP)71Q\n" + "7QY)B5P\n" + "F4M)ZNC\n" + "PSB)2Q8\n" + "TRQ)N5V\n" + "BGZ)4SN\n" + "NDP)8KT\n"
			+ "S4W)7TQ\n" + "9B3)T4T\n" + "82T)W47\n" + "NCJ)TFZ\n" + "LZQ)T6L\n" + "R31)35H\n" + "YTY)JS5\n"
			+ "BNJ)1RV\n" + "WTB)RV9\n" + "SK4)NLQ\n" + "8Q2)SWW\n" + "H3X)YNQ\n" + "WDX)PD8\n" + "F1J)7JX\n"
			+ "Y9Z)VW4\n" + "7K7)MF3\n" + "13R)B8W\n" + "4SN)X1Z\n" + "5GT)KM9\n" + "PXV)RJK\n" + "KF2)9JF\n"
			+ "7D5)85C\n" + "DQK)B87\n" + "C5T)RP6\n" + "BHL)NM8\n" + "ZQD)287\n" + "6YR)2SY\n" + "QSG)H7H\n"
			+ "2YY)M62\n" + "C7W)TWW\n" + "96K)C97\n" + "3GG)ZZW\n" + "CSV)6LS\n" + "SJ4)6RQ\n" + "15X)X9J\n"
			+ "J5Y)8BD\n" + "T82)WGY\n" + "5WP)72Z\n" + "FW2)KN8\n" + "ZRD)2QR\n" + "Z2Z)5W9\n" + "K7R)VV3\n"
			+ "MLJ)BDH\n" + "G33)LDC\n" + "543)15X\n" + "P7Z)21Q\n" + "T24)WCS\n" + "5YC)RCM\n" + "PMB)SK4\n"
			+ "YDB)S4M\n" + "HVB)R9K\n" + "C7Z)LSD\n" + "BZ6)LMD\n" + "N4M)7K7\n" + "KYB)JMQ\n" + "951)DCN\n"
			+ "9LG)ZQD\n" + "75Q)GHX\n" + "3CN)957\n" + "S9Q)KWF\n" + "S44)ZRD\n" + "JS5)Y66\n" + "MTM)B7Z\n"
			+ "Y9M)VLQ\n" + "WM6)QV1\n" + "XJB)T5M\n" + "PZC)YB8\n" + "HG5)TZ9\n" + "CW5)ZFH\n" + "NPS)T82\n"
			+ "JM6)WN8\n" + "KG5)GDR\n" + "1RN)N3Y\n" + "2YF)FLB\n" + "P4X)F74\n" + "NQJ)JXZ\n" + "J8C)6V4\n"
			+ "R78)GT3\n" + "CPY)Q8H\n" + "NF6)V2F\n" + "ZG2)WKY\n" + "585)ZXH\n" + "P48)339\n" + "ZPY)TJL\n"
			+ "CHX)5J9\n" + "YL4)Y73\n" + "H9G)DSC\n" + "BDH)G5F\n" + "JVQ)S34\n" + "Z3T)NPR\n" + "HHK)CL2\n"
			+ "727)576\n" + "72T)CTM\n" + "RWD)GQG\n" + "CMB)TN1\n" + "BRG)5WP\n" + "98Q)Z3T\n" + "NF3)JBC\n"
			+ "KKB)K9D\n" + "T4S)7PW\n" + "4XG)GMV\n" + "H1B)S5L\n" + "J95)HSR\n" + "6FL)JDZ\n" + "GNK)TTC\n"
			+ "VKZ)ZLL\n" + "7PW)R2B\n" + "DSC)QP2\n" + "QTD)66W\n" + "XL2)KN2\n" + "KDT)6SY\n" + "RNK)L9H\n"
			+ "HWV)V3S\n" + "276)8W8\n" + "7VK)RNS\n" + "3PM)DYC\n" + "WF8)RTT\n" + "13M)TZB\n" + "TNL)FNP\n"
			+ "RNF)RJW\n" + "WYF)BRK\n" + "Y9P)PZ1\n" + "Q9M)TS1\n" + "JNF)QJF\n" + "S79)YFR\n" + "K4H)Y82\n"
			+ "LWG)NQ6\n" + "DHH)ZS3\n" + "8G7)S7Q\n" + "FJT)HHK\n" + "5PK)4S8\n" + "CVR)P12\n" + "R9Z)N9B\n"
			+ "17Y)BSR\n" + "M7J)7NR\n" + "C6R)W1R\n" + "Y56)5GT\n" + "NT5)XJB\n" + "2Q2)SL5\n" + "6NP)S31\n"
			+ "L19)2HC\n" + "TVT)415\n" + "3ZH)S93\n" + "91L)39L\n" + "FVK)N18\n" + "R67)V8R\n" + "TMD)FL5\n"
			+ "4F4)SG2\n" + "XBV)Z18\n" + "GFD)MS8\n" + "9V4)JNC\n" + "554)XS1\n" + "9M3)18M\n" + "CTQ)HYW\n"
			+ "LY4)WTB\n" + "HY3)LL3\n" + "2J3)XL2\n" + "VC1)YOU\n" + "JMY)RD8\n" + "XK2)D5K\n" + "KD2)7J8\n"
			+ "JD1)258\n" + "S1C)SLC\n" + "R6R)WXM\n" + "6MT)33D\n" + "QJB)4TP\n" + "287)CSC\n" + "FVR)JQ4\n"
			+ "35H)BCS\n" + "WQ2)YL4\n" + "DX6)STJ\n" + "X42)348\n" + "J3V)XDK\n" + "YSM)DZN\n" + "6LZ)ZQ8\n"
			+ "HVH)2TR\n" + "GB3)Y5V\n" + "FHP)Y46\n" + "61S)6LJ\n" + "FPK)XTY\n" + "P1X)F6N\n" + "TZJ)YHR\n"
			+ "XHG)N5L\n" + "8PS)4ZX\n" + "JNC)FFT\n" + "412)4XG\n" + "YQP)YST\n" + "GMJ)SYF\n" + "ZJD)FRK\n"
			+ "Q23)DTL\n" + "V3P)W1H\n" + "KMY)H3X\n" + "C8K)TJD\n" + "WQN)5NY\n" + "XZS)3SY\n" + "PWJ)Z93\n"
			+ "37Z)BGV\n" + "CFQ)72T\n" + "GDZ)FCS\n" + "82T)WYX\n" + "DLH)HQM\n" + "MLH)Z8Q\n" + "9YV)72F\n"
			+ "GX7)CTN\n" + "YW4)MJC\n" + "RWK)CT8\n" + "2SY)QB3\n" + "16K)MXB\n" + "2DQ)LWY\n" + "R6R)M4K\n"
			+ "BZH)84R\n" + "CBZ)L77\n" + "947)WYF\n" + "CT8)Q3L\n" + "DNM)15N\n" + "TX1)VBN\n" + "JXZ)3CN\n"
			+ "VT4)3WX\n" + "3RH)STW\n" + "GRB)V7G\n" + "8FS)LD1\n" + "3WC)51W\n" + "M1D)H9G\n" + "TSM)F8F\n"
			+ "ZQ6)KDT\n" + "F4P)6FD\n" + "NK2)NQS\n" + "VXV)JFT\n" + "C97)C7W\n" + "1YR)VMR\n" + "YXC)LG6\n"
			+ "STW)17M\n" + "1V5)74R\n" + "6VZ)S9Z\n" + "WV2)SRW\n" + "R45)56K\n" + "75L)DD1\n" + "7ZV)6LZ\n"
			+ "T5M)T15\n" + "RCC)D4P\n" + "3W6)5K5\n" + "FBQ)TXR\n" + "7V7)VPC\n" + "TWW)M2Z\n" + "7DF)Z41\n"
			+ "Z31)8HB\n" + "M2Z)13M\n" + "ZZW)Q9M\n" + "5XZ)CZF\n" + "BFX)JG9\n" + "ZSH)CMC\n" + "D36)CY1\n"
			+ "MWD)8CJ\n" + "W6D)TVT\n" + "39Z)HVH\n" + "9CG)XKJ\n" + "XJ3)3PM\n" + "84R)N9C\n" + "1C8)2NW\n"
			+ "DC3)ZJP\n" + "P67)947\n" + "7GT)NVV\n" + "J91)MWD\n" + "R9Z)NKQ\n" + "415)8VG\n" + "T6T)B4L\n"
			+ "6J7)F1J\n" + "QBX)ZJD\n" + "4XC)CVS\n" + "3ZM)D1K\n" + "NQJ)BGQ\n" + "J2P)4QZ\n" + "RGW)GB3\n"
			+ "8KD)37Z\n" + "56P)S8T\n" + "711)KBM\n" + "QL5)4H9\n" + "GP9)SH2\n" + "DKR)ZPS\n" + "F4R)K5L\n"
			+ "54Q)P1P\n" + "6L1)NZR\n" + "RPT)9CG\n" + "G8S)6QW\n" + "4JW)KB5\n" + "ZTK)F24\n" + "SWW)GBK\n"
			+ "B7V)J5C\n" + "Z6S)PD2\n" + "N9S)CF8\n" + "8BC)Q69\n" + "283)543\n" + "TMD)7LC\n" + "QV1)RDN\n"
			+ "6FD)KKB\n" + "BTS)2WG\n" + "3ZR)CY5\n" + "5TX)arg0ZKY\n" + "9NL)KB8\n" + "97T)GMJ\n" + "68B)GRF\n"
			+ "FVC)DW2\n" + "L7D)RYL\n" + "RL3)B4C\n" + "7YX)JJX\n" + "NCX)X21\n" + "BJ8)GPB\n" + "YST)ZZ1\n"
			+ "MCS)3Z7\n" + "ZXG)FZY\n" + "RYL)4Q9\n" + "5NY)GTK\n" + "YQ1)T9P\n" + "CF6)46K\n" + "F7W)WQG\n"
			+ "77Z)CY8\n" + "6W2)HJ1\n" + "TT6)R5K\n" + "F68)W3S\n" + "DSD)VR2\n" + "JWZ)8FS\n" + "YSQ)W67\n"
			+ "J8D)W1P\n" + "6KV)BX7\n" + "ZRB)WT8\n" + "3B1)RHJ\n" + "2FK)K3P\n" + "Q49)ZYK\n" + "8DN)9CR\n"
			+ "SBT)GL4\n" + "HK3)4XL\n" + "FFH)X2T\n" + "VWG)VZL\n" + "954)J78\n" + "2MX)CYB\n" + "JM6)S1W\n"
			+ "LRZ)SVM\n" + "H1F)9YV\n" + "C12)FSH\n" + "D9J)CTH\n" + "9LV)S3K\n" + "RJK)DZ7\n" + "5HZ)9WL\n"
			+ "ZKK)K4H\n" + "TH2)8QQ\n" + "P12)QJV\n" + "2HT)Z31\n" + "7K3)WZ5\n" + "3C4)TZK\n" + "66D)Q7C\n"
			+ "TQ1)7GT\n" + "2MX)GRY\n" + "LQ1)7LJ\n" + "46P)YL8\n" + "6SY)2VR\n" + "Y6Q)VP8\n" + "YNQ)LRZ\n"
			+ "DKS)MKC\n" + "Z69)D9N\n" + "V96)DGD\n" + "YN9)XKF\n" + "KF1)JR4\n" + "LW6)W9S\n" + "31W)S55\n"
			+ "J1F)WR4\n" + "3ZX)JW7\n" + "4CC)V53\n" + "SJ4)GQC\n" + "BXM)VC1\n" + "PV1)JJF\n" + "5F3)G28\n"
			+ "WC1)XPM\n" + "KY3)78Y\n" + "B4C)9YW\n" + "8KS)M6N\n" + "ZTW)554\n" + "ZSS)SLS\n" + "GNW)KC4\n"
			+ "4S8)Y1N\n" + "7TR)4V7\n" + "C7H)3RD\n" + "LSD)T9B\n" + "VQG)11S\n" + "PSS)Z12\n" + "MRV)RB5\n"
			+ "WS6)NQ5\n" + "SBS)711\n" + "42N)3RN\n" + "CLL)TX1\n" + "K5S)32G\n" + "VR2)7S9\n" + "NPR)12Y\n"
			+ "924)NCK\n" + "BYX)NR1\n" + "Y6D)7D5\n" + "23G)6BT\n" + "N9C)W6X\n" + "K52)FZM\n" + "5NP)ZJB\n"
			+ "Q37)R2N\n" + "JZY)66D\n" + "NZJ)Q23\n" + "WK9)YN9\n" + "S27)D5M\n" + "Y1N)WJK\n" + "CJ4)5YC\n"
			+ "LDC)N86\n" + "LJM)69P\n" + "6BT)R5V\n" + "LL3)RYK\n" + "PMJ)3PF\n" + "S44)TZD\n" + "D3D)VMD\n"
			+ "D1K)4BL\n" + "WR4)MB1\n" + "GF6)J9D\n" + "9KV)5H7\n" + "SFM)ZPF\n" + "KZ7)S79\n" + "DRJ)ZL3\n"
			+ "MFQ)CMB\n" + "4XL)ZG2\n" + "SYM)7YP\n" + "FH2)K6Q\n" + "PVB)LK7\n" + "BVQ)J95\n" + "9S6)GYH\n"
			+ "VMR)PMJ\n" + "LPK)9NL\n" + "MXC)6J7\n" + "K93)ZGG\n" + "MDK)GNK\n" + "C9L)56Q\n" + "46K)H1Z\n"
			+ "FTB)3DY\n" + "6CX)X9Z\n" + "CB6)2YF\n" + "SNR)NF3\n" + "J78)XHJ\n" + "9V7)R54\n" + "3LD)S1C\n"
			+ "M4K)WF2\n" + "TRQ)MHC\n" + "BGV)CR2\n" + "LLN)2DY\n" + "NQ6)F8B\n" + "F6N)31N\n" + "74N)TZZ\n"
			+ "YHR)M72\n" + "BF6)1YR\n" + "7LG)P6F\n" + "KTH)X28\n" + "4ZT)T11\n" + "S55)Q98\n" + "PB5)J3V\n"
			+ "YG8)X8C\n" + "DPM)HW6\n" + "KW4)4HL\n" + "ZMY)P4S\n" + "J3F)Z2L\n" + "NSY)9WX\n" + "YVM)XDF\n"
			+ "CL2)85Y\n" + "K5L)RNK\n" + "J2K)1KC\n" + "VV3)V4L\n" + "Y88)7XT\n" + "F4N)ZVH\n" + "6HF)NZJ\n"
			+ "3WZ)N7L\n" + "GV5)M7J\n" + "KPJ)7XK\n" + "S9Q)MQ5\n" + "Q3L)TP5\n" + "6HF)RVK\n" + "ZR1)P5B\n"
			+ "JMQ)QL5\n" + "R5Y)LHV\n" + "RMD)38Z\n" + "VKP)8MN\n" + "XPZ)J82\n" + "CR3)61H\n" + "R1Q)DD6\n"
			+ "N5L)RLR\n" + "FFT)LPK\n" + "WM2)WC4\n" + "HG2)QNN\n" + "S34)SJV\n" + "X4F)MTL\n" + "SLS)82Q\n"
			+ "32G)TTK\n" + "J9M)YXC\n" + "R9K)P6T\n" + "BNC)MPT\n" + "3B5)VS1\n" + "VZH)SGW\n" + "MJM)334\n"
			+ "8PS)WGD\n" + "S5L)D1Q\n" + "138)GBT\n" + "VTJ)JMM\n" + "ZJP)C85\n" + "FZY)W4B\n" + "SHW)3WC\n"
			+ "DB1)TQS\n" + "9VX)19Z\n" + "CF8)HQL\n" + "WYX)Z4G\n" + "J1J)Q37\n" + "Z75)P3V\n" + "PGB)77Z\n"
			+ "1C6)SJX\n" + "XPG)Q84\n" + "4F1)M9G\n" + "D4N)JMD\n" + "7JX)Q4X\n" + "BMG)V33\n" + "J86)JD1\n"
			+ "KN2)KBD\n" + "B87)XDJ\n" + "VYJ)4FG\n" + "XDF)7ZN\n" + "HLF)YQP\n" + "7YP)PSB\n" + "WRK)6FL\n"
			+ "QNN)PL6\n" + "BP7)QW9\n" + "DMQ)BJ8\n" + "Q5V)N4M\n" + "XS3)CF5\n" + "WXB)C9Q\n" + "P4S)8WW\n"
			+ "Z8V)53J\n" + "SLL)TQ9\n" + "71Q)Q6Q\n" + "3H4)CVR\n" + "XHJ)X4Q\n" + "3SY)DHH\n" + "5W7)DFV\n"
			+ "9MB)HY3\n" + "61H)H14\n" + "JR4)ZGR\n" + "FDW)11Z\n" + "V3H)H7D\n" + "R5K)KH2\n" + "KFK)ZVL\n"
			+ "CQ3)Y5S\n" + "W6X)16K\n" + "BSW)FKY\n" + "TMQ)1T2\n" + "S4M)BP7\n" + "C9Z)L2J\n" + "GRF)Z6D\n"
			+ "1T8)2DQ\n" + "D97)WHF\n" + "ZST)9R5\n" + "VZG)CTQ\n" + "CB6)PZC\n" + "ZTY)TVW\n" + "ZGR)8XF\n"
			+ "41Z)F9Y\n" + "Q8H)SHW\n" + "WVZ)KB6\n" + "3PF)7QD\n" + "BDZ)YVM\n" + "W1H)7ZV\n" + "F5G)DR7\n"
			+ "NM5)3MT\n" + "72L)G62\n" + "1H1)68B\n" + "WN8)Q2W\n" + "9M3)756\n" + "5H7)1RN\n" + "DGD)RGQ\n"
			+ "DLB)5VL\n" + "HZV)VKP\n" + "7X3)4WP\n" + "NZR)TLD\n" + "21Q)MLL\n" + "X77)4JP\n" + "5R5)7DQ\n"
			+ "X28)Y1Q\n" + "YRV)BJW\n" + "M14)6KB\n" + "VZL)FBQ\n" + "WD3)CV8\n" + "J9R)KWG\n" + "C3G)Y74\n"
			+ "P5B)BHL\n" + "HHN)WD3\n" + "FNP)KTL\n" + "QGJ)P9B\n" + "B6G)9H7\n" + "YFR)919\n" + "FVX)M74\n"
			+ "7XK)V3H\n" + "ZVH)ZZJ\n" + "TSH)6NP\n" + "63H)M1K\n" + "W4C)RZH\n" + "ZZ1)P48\n" + "QGS)69H\n"
			+ "5J9)YDB\n" + "S8L)P4X\n" + "TP6)MJM\n" + "JJF)Z3L\n" + "KN2)P7Z\n" + "CPK)H1B\n" + "3SN)WKF\n"
			+ "DCC)F4W\n" + "5H6)2F4\n" + "MVY)412\n" + "NRL)GP3\n" + "T44)F4N\n" + "T8X)Z3X\n" + "8LZ)GR6\n"
			+ "8KT)Q4C\n" + "M74)MCC\n" + "2L9)S27\n" + "36K)G2N\n" + "957)WS5\n" + "TXR)7VJ\n" + "B95)ZJR\n"
			+ "K9J)BM9\n" + "ZVL)CGZ\n" + "7QD)P8Y\n" + "ZYK)239\n" + "XTY)YSM\n" + "4VQ)MYM\n" + "SLZ)YGH\n"
			+ "L76)ZB9\n" + "DDQ)MNC\n" + "P9B)WQN\n" + "DW2)H9Y\n" + "WKF)W37\n" + "48V)FHH\n" + "76X)3FR\n"
			+ "TZZ)8RQ\n" + "YDS)NBJ\n" + "R4C)C1Q\n" + "258)7WF\n" + "B3H)TSM\n" + "4Z1)L98\n" + "C8V)9NJ\n"
			+ "ZKY)D3G\n" + "J3G)7Q4\n" + "XN1)S88\n" + "RJZ)6KR\n" + "YFD)GSS\n" + "8H9)WLN\n" + "TTW)D95\n"
			+ "F7H)J9R\n" + "H7D)Z2Z\n" + "Y25)Q6L\n" + "PDC)FZG\n" + "783)7TR\n" + "8M9)FPK\n" + "2GT)PSK\n"
			+ "XZG)42B\n" + "1KC)PTK\n" + "TVK)BHJ\n" + "TVH)XMK\n" + "2KQ)DPF\n" + "ZNC)7DF\n" + "VJS)5NP\n"
			+ "RV9)375\n" + "RWY)31W\n" + "3RS)J5Y\n" + "SHF)Y88\n" + "PWS)J2K\n" + "VK8)9B6\n" + "J1F)WS6\n"
			+ "5V8)Y9Y\n" + "RC3)L7D\n" + "2YF)K52\n" + "VV3)TZN\n" + "6KB)P78\n" + "7BP)CF6\n" + "R5V)GJS\n"
			+ "B2K)CR3\n" + "8MX)LWG\n" + "YG7)NND\n" + "SD3)PVB\n" + "CHP)NLM\n" + "HYS)19Q\n" + "T2D)D6H\n"
			+ "SQ6)BYX\n" + "NVV)C3G\n" + "TVW)L19\n" + "8W8)SBZ\n" + "3Y4)L5V\n" + "L2S)XHG\n" + "QM7)WQS\n"
			+ "239)NCJ\n" + "DHH)S2P\n" + "1W8)13R\n" + "NQ5)7LT\n" + "RJK)9J3\n" + "CMK)YRY\n" + "STL)5L8\n"
			+ "RYJ)SG8\n" + "3Z7)9V4\n" + "46Y)C6N\n" + "GFH)QZG\n" + "CMC)FJT\n" + "81H)DRJ\n" + "L94)8DW\n"
			+ "W1X)2P4\n" + "9VT)DF9\n" + "X9J)N9S\n" + "CYB)H1F\n" + "SJX)VQG\n" + "4RP)WM6\n" + "HYW)1C8\n"
			+ "XMJ)Y6Q\n" + "TR5)5XZ\n" + "LS7)91J\n" + "CXM)276\n" + "WH7)BJ6\n" + "FRD)7X3\n" + "BCS)K46\n"
			+ "FKY)BXM\n" + "TBN)4Z1\n" + "54B)99H\n" + "2B9)JXH\n" + "DWW)WL5\n" + "ZS3)SR2\n" + "MDR)DDS\n"
			+ "KJD)LZQ\n" + "WBM)HX7\n" + "KDP)T5S\n" + "2WG)BF6\n" + "RFJ)L65\n" + "3N4)KLK\n" + "Q7F)5WZ\n"
			+ "K4P)P67\n" + "SS1)PT2\n" + "LV4)11L\n" + "8VG)HZV\n" + "GL4)BSW\n" + "7LC)QSF\n" + "RNS)23G\n"
			+ "FCS)XLB\n" + "LHV)B8K\n" + "MD3)8M9\n" + "YRG)SBS\n" + "3MP)FXS\n" + "Z75)T1M\n" + "RRQ)VXV\n"
			+ "LD1)7LG\n" + "ZFB)Z42\n" + "56J)Q7Y\n" + "8ZQ)R43\n" + "N3R)5HC\n" + "Y1R)2RW\n" + "GMZ)6MN\n"
			+ "ZQ8)6YR\n" + "GQC)WDX\n" + "RD8)D5J\n" + "HCG)Y11\n" + "NCK)2L9\n" + "911)Z16\n" + "G81)CJ4\n"
			+ "NTY)3NS\n" + "SBZ)HG2\n" + "2VR)SBT\n" + "WYX)NQJ\n" + "6QQ)6NT\n" + "P1P)1CV\n" + "CGZ)V48\n"
			+ "RTT)5H6\n" + "7D9)KMY\n" + "VTV)54B\n" + "F74)FT6\n" + "KB8)RZD\n" + "3MT)JWC\n" + "56Q)H9C\n"
			+ "RHK)865\n" + "XCM)ZQJ\n" + "T5Y)GNC\n" + "W9S)ZFB\n" + "9WL)GV5\n" + "DN6)RX4\n" + "SG8)NCX\n"
			+ "P3V)7WW\n" + "B8K)8PS\n" + "78V)VWZ\n" + "FSH)VT4\n" + "KH2)BQP\n" + "DJV)N2D\n" + "WT8)BVM\n"
			+ "ZB9)ZMY\n" + "CTH)YKB\n" + "24S)FGH\n" + "FBQ)7VK\n" + "C85)V3D\n" + "PK2)RWD\n" + "BQP)W84\n"
			+ "H1Z)DNQ\n" + "VP8)K4P\n" + "DZ7)XPG\n" + "45R)PDC\n" + "SG5)52G\n" + "69H)RM4\n" + "DR7)9M3\n"
			+ "X23)TLQ\n" + "VPC)ZQR\n" + "5SL)97P\n" + "Z59)9LV\n" + "JJX)HRV\n" + "J9D)Q4S\n" + "RJW)WKN\n"
			+ "6RQ)QLT\n" + "TLR)LLY\n" + "KBM)13Y\n" + "L9H)952\n" + "XDJ)3RS\n" + "JFT)Q1Z\n" + "NJ6)XVV\n"
			+ "FL5)5TK\n" + "L1Q)TK3\n" + "PDS)X7F\n" + "5BB)QZB\n" + "1RV)154\n" + "PWJ)LZ4\n" + "QPT)5DN\n"
			+ "N9C)RCC\n" + "DLH)NRL\n" + "Z9M)2Q2\n" + "FXS)66F\n" + "ZSD)R5G\n" + "GMZ)1G1\n" + "K6Q)YQ1\n"
			+ "QHH)SHF\n" + "WD2)GFH\n" + "MYM)ZP3\n" + "5QF)LQ1\n" + "N2G)C35\n" + "MLL)5QY\n" + "JW7)QY6\n"
			+ "X4Q)81H\n" + "97S)1L9\n" + "S4G)5QN\n" + "9DF)6BG\n" + "LMD)HLF\n" + "VBN)VHW\n" + "4JP)Z13\n"
			+ "ZTW)J8D\n" + "V8R)7Q9\n" + "5HZ)2B9\n" + "WV7)K7R\n" + "DYV)KJD\n" + "1VB)VNX\n" + "16Z)52D\n"
			+ "M74)J1J\n" + "L7D)D3D\n" + "D1N)RFJ\n" + "GX7)6MS\n" + "19Z)H99\n" + "COM)RV4\n" + "B5P)SDH\n"
			+ "W1P)M33\n" + "DC7)SQ7\n" + "BTS)85Z\n" + "88C)T24\n" + "NDJ)KG5\n" + "4HL)KF1\n" + "M5T)MDS\n"
			+ "4YY)GRB\n" + "C1Q)K9V\n" + "TBN)Y56\n" + "WS5)W1X\n" + "BBX)Z8G\n" + "XWS)6TS\n" + "7DQ)2HT\n"
			+ "698)MXC\n" + "KV9)CB6\n" + "TD4)S4G\n" + "B7Z)H4Q\n" + "7D9)DWX\n" + "Z3L)2PR\n" + "S9Z)2BP\n"
			+ "YQF)YND\n" + "G62)3Y4\n" + "VNX)GMZ\n" + "T6L)S8L\n" + "Z13)Z21\n" + "WQS)JM9\n" + "5J8)M14\n"
			+ "15P)8ZQ\n" + "CPL)DYL\n" + "PL6)R5Y\n" + "L8N)MFQ\n" + "89H)6W2\n" + "JBC)LW6\n" + "ZP3)XP5\n"
			+ "T2D)G56\n" + "TLD)ZSS\n" + "M3J)WK9\n" + "85Y)D5R\n" + "FNG)BZ6\n" + "74R)RMD\n" + "48N)TZJ\n"
			+ "RJJ)ZJV\n" + "V4L)M1D\n" + "SN3)JZY\n" + "85D)1FQ\n" + "CY5)SDK\n" + "7WW)741\n" + "2KQ)G8S\n"
			+ "91J)L8N\n" + "LQ1)JHC\n" + "66W)Y9Z\n" + "GNC)FXP\n" + "Z7N)V97\n" + "ZM5)92D\n" + "XDK)911\n"
			+ "M6N)W82\n" + "95K)LS7\n" + "VBN)TLR\n" + "TK3)TVH\n" + "NBJ)45R\n" + "1K7)M7X\n" + "S31)P3G\n"
			+ "WBM)2V5\n" + "7LT)LLN\n" + "9NJ)9VT\n" + "MLL)SFM\n" + "3DY)L3Z\n" + "348)S44\n" + "N8N)YSC\n"
			+ "5T6)JB5\n" + "2VY)93L\n" + "D96)LV4\n" + "SG2)YKF\n" + "YB8)LY4\n" + "96H)RGW\n" + "W4B)X6N\n"
			+ "5L4)KV9\n" + "YQV)GWP\n" + "TWX)3MP\n" + "H99)DSD\n" + "WFB)7J3\n" + "C5T)3MC\n" + "6F9)1YX\n"
			+ "DWX)XTR\n" + "7WF)SFJ\n" + "Q1Z)8N9\n" + "YMZ)ZSD\n" + "11L)T23\n" + "6LV)W2B\n" + "PXS)K6M\n"
			+ "952)BYQ\n" + "WL5)H9T\n" + "GLK)1V5\n" + "XLB)Z75\n" + "4LC)TTW\n" + "Y77)FRD\n" + "P4X)9W8\n"
			+ "TZ9)JDT\n" + "KWG)SG5\n" + "T15)FM3\n" + "2CZ)W8N\n" + "4Q9)MCS\n" + "K9F)HTD\n" + "GTK)B6G\n"
			+ "741)VZH\n" + "4D4)4YY\n" + "9S6)6SG\n" + "FGH)GNW\n" + "X21)QL6\n" + "W1R)JM6\n" + "89S)JMH\n"
			+ "9R5)96K\n" + "H2J)C9G\n" + "9WX)J9M\n" + "WXM)XWS\n" + "MQ5)3Q8\n" + "XMK)Z6S\n" + "472)FVX\n"
			+ "7Q9)QSG\n" + "J5C)5GZ\n" + "FVT)MTM\n" + "M49)85D\n" + "13N)BFX\n" + "TJD)RM9\n" + "SYF)SJ4\n"
			+ "S3K)9MS\n" + "V3S)ZXG\n" + "3YL)3HH\n" + "ML9)6F9\n" + "BGQ)WC1\n" + "NLM)KDP\n" + "2ZC)7TB\n"
			+ "F8B)83G\n" + "4QZ)Y6D\n" + "MZ4)1JW\n" + "6V4)YK6\n" + "FCP)QJB\n" + "Q84)GP9\n" + "TZK)91L\n"
			+ "TS7)4NJ\n" + "7VJ)5PQ\n" + "B8K)C8K\n" + "T4T)B7V\n" + "2NW)843\n" + "HNP)PXS\n" + "B5P)9KV\n"
			+ "XTR)Q49\n" + "FSF)RWK\n" + "WGD)ZTY\n" + "GLK)RWY\n" + "TTC)J2S\n" + "ZVW)DQK\n" + "R5X)YDS\n"
			+ "NNW)ZM5\n" + "K6M)4ZT\n" + "QR9)2GT\n" + "Q4C)BDN\n" + "S2P)22Y\n" + "T23)SFD\n" + "8KS)RYJ\n"
			+ "7TQ)1PP\n" + "KPL)48V\n" + "D5Q)BMG\n" + "1RN)41Q\n" + "W5R)8BB\n" + "5VL)HTZ\n" + "B4F)HG5\n"
			+ "ZJR)R41\n" + "2TR)5PK\n" + "JP3)NLZ\n" + "59Z)NBS\n" + "FJQ)VSJ\n" + "DPS)HMT\n" + "4D7)TBN\n"
			+ "1G1)MLJ\n" + "P7T)65X\n" + "SDH)W7D\n" + "WYF)KN3\n" + "S6L)HWF\n" + "DCP)TVK\n" + "LK7)W4C\n"
			+ "GT7)ZNS\n" + "ZJV)TKJ\n" + "ZPJ)Y9P\n" + "33D)TQ1\n" + "2QV)Y77\n" + "XCW)4DK\n" + "NQ6)3Y8\n"
			+ "72Z)8PV\n" + "YL8)YCD\n" + "JHC)6QQ\n" + "F54)DPM\n" + "YQ1)5NR\n" + "9W8)BNJ\n" + "GSS)JNF\n"
			+ "V49)BGZ\n" + "S4B)DMQ\n" + "9CR)1BX\n" + "C35)GFD\n" + "KFK)YQF\n" + "JD7)46T\n" + "Z16)J3G\n"
			+ "SWW)CFQ\n" + "K46)ZSH\n" + "154)8KP\n" + "Q4X)8RV\n" + "KWF)5HZ\n" + "NKQ)T8X\n" + "M4F)DB1\n"
			+ "YL8)8Q2\n" + "27M)YQ3\n" + "49P)TFC\n" + "956)X42\n" + "JWC)FW2\n" + "YXF)H2F\n" + "FLB)P1X\n"
			+ "GSX)81F\n" + "XTR)26G\n" + "88W)3SN\n" + "8DW)FFH\n" + "W84)BS6\n" + "Z2L)YSQ\n" + "X9Z)4LC\n"
			+ "YRY)3ZM\n" + "CF5)97G\n" + "31Z)FTB\n" + "VHW)YXF\n" + "MPT)DNF\n" + "G5F)DLH\n" + "VM1)BRG\n"
			+ "Q4S)ML7\n" + "ST9)JP3\n" + "XMK)P7T\n" + "83G)WGV\n" + "ZNV)P1T\n" + "TKJ)63H\n" + "6NT)QMJ\n"
			+ "SH2)FVC\n" + "W1B)Z4J\n" + "1M7)PMB\n" + "9W8)31Z\n" + "R83)WV7\n" + "MC9)PX3\n" + "ZGG)QPB\n"
			+ "1L9)4XC\n" + "DPF)RL3\n" + "F8F)C45\n" + "PYT)YVL\n" + "9MZ)74N\n" + "59Z)3RH\n" + "MHC)8SM\n"
			+ "SFJ)SLZ\n" + "R43)8W5\n" + "7KS)J6V\n" + "N3Y)3R8\n" + "L2K)WNK\n" + "9P4)XF7\n" + "DNF)377\n"
			+ "XYP)3GG\n" + "QZB)1K7\n" + "GMV)N1G\n" + "6SG)YZV\n" + "P8Y)XBV\n" + "GPT)S7K\n" + "Q5V)KYB\n"
			+ "X27)4JC\n" + "756)M4F\n" + "FT6)JD7\n" + "RHJ)98Q\n" + "FXP)7HW\n" + "XFS)HWV\n" + "C9G)689\n"
			+ "Y1Q)J9N\n" + "46T)JLM\n" + "J86)S84\n" + "BM9)NJ6\n" + "F4B)VWG\n" + "GF2)VRK\n" + "W82)56J\n"
			+ "JXH)3C4\n" + "VXV)R67\n" + "WCS)C9L\n" + "5TX)CMK\n" + "Z41)L2S\n" + "RVK)TSH\n" + "M7X)Y1D\n"
			+ "TZN)73T\n" + "JVN)FRX\n" + "P6T)3YQ\n" + "M33)VH6\n" + "YRX)VK8\n" + "93L)6LV\n" + "ZFH)X77\n"
			+ "GTN)TWX\n" + "S93)NDP\n" + "LZ9)12T\n" + "WHF)3ZH\n" + "H4Q)8DN\n" + "Z42)17Y\n" + "HW6)V9H\n"
			+ "NQS)3N4\n" + "1PP)MD3\n" + "CZF)BVD\n" + "TP5)56P\n" + "M72)XK2\n" + "CSC)LTB\n" + "8QQ)ZTK\n"
			+ "TZX)XMJ\n" + "YNQ)C7Z\n" + "WJF)37G\n" + "5QY)ZR1\n" + "WFC)D3S\n" + "YVL)QZC\n" + "SRW)5SL\n"
			+ "KYB)G81\n" + "6LJ)8JZ\n" + "NCK)JVQ\n" + "KB6)GF2\n" + "9YW)CLF\n" + "9M6)6L1\n" + "F1D)ZKK\n"
			+ "7S9)DLM\n" + "Y5S)68X\n" + "C9Z)K5S\n" + "L98)CCR\n" + "RCM)2Q6\n" + "8H9)7BP\n" + "4Z5)KFK\n"
			+ "CTN)NNW\n" + "LV4)97T\n" + "1C8)VBZ\n" + "GBK)QHH\n" + "3YL)ZST\n" + "M1W)6D5\n" + "MNC)42N\n"
			+ "D6H)DKS\n" + "VKJ)5W7\n" + "FRX)CHP\n" + "NY7)8LZ\n" + "Z2W)MZ4\n" + "DFV)TMD\n" + "K9V)HNP\n"
			+ "K88)3H4\n" + "F4W)V9L\n" + "QQ8)2CZ\n" + "MBJ)GPT\n" + "M2X)Z8V\n" + "3Q8)GG3\n" + "RL2)4F1\n"
			+ "81H)WRK\n" + "3WX)GQ2\n" + "WDB)BBX\n" + "JMD)J3J\n" + "HC3)9B3\n" + "CLF)G9N\n" + "SL5)LD6\n"
			+ "5F3)MDK\n" + "X6N)JVN\n" + "B4L)HHN\n" + "YPT)F68\n" + "B8W)5F3\n" + "N1C)DX6\n" + "WLT)88W\n"
			+ "Y66)D36\n" + "X6J)XZG\n" + "CMC)36G\n" + "T1Z)3L6\n" + "ZPF)JTZ\n" + "C45)MY4\n" + "QPT)YPT\n"
			+ "5QL)9N5\n" + "LD3)LJM\n" + "TFC)RWL\n" + "YQV)CPY\n" + "85C)75Q\n" + "TR7)CLL\n" + "TZZ)ZNV\n"
			+ "NND)GLK\n" + "GQ2)WBM\n" + "QP2)L94\n" + "WJK)HVB\n" + "3R8)QG6\n" + "7NR)6BK\n" + "2V5)V3P\n"
			+ "LZ4)CHX\n" + "M3M)NTY\n" + "3FG)5J8\n" + "BSH)Z45\n" + "1BX)MSJ\n" + "S7K)HF8\n" + "Z93)BTS\n"
			+ "5VL)SYN\n" + "CTM)MDR\n" + "YNJ)951\n" + "D5K)CXM\n" + "JDZ)XFS\n" + "4CC)FVK\n" + "D9N)KPL\n"
			+ "4J8)CRG\n" + "YBH)QFT\n" + "W47)QTD\n" + "XYP)13N\n" + "8SM)SS1\n" + "MT5)VTJ\n" + "2ZB)6VZ\n"
			+ "SC1)FNG\n" + "4Z8)RRF\n" + "XKF)M1W\n" + "5NR)CPK\n" + "ZPS)JMY\n" + "RHJ)8MX\n";

}
