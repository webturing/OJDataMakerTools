package zj.ojd.util;

import java.util.Arrays;
import java.util.Random;

public class RandTools {
	private static Random random = new Random();

	private RandTools() {
	}

	public static int randInt(int left, int right) {
		return random.nextInt(right - left + 1) + left;
	}

	public static double randDouble(double left, double right) {
		return random.nextDouble() * (right - left) + left;
	}

	public static int[] randInts(int left, int right, int count) {
		int[] result = new int[count];
		for (int i = 0; i < count; i++)
			result[i] = randInt(left, right);
		Arrays.sort(result);
		return result;
	}

	public static double[] randDoubles(double left, double right, int count) {
		double[] result = new double[count];
		for (int i = 0; i < count; i++)
			result[i] = randDouble(left, right);
		Arrays.sort(result);
		return result;
	}

	public static char randLowChar() {
		return (char) ('a' + randInt(0, 25));
	}

	public static char randUpperChar() {
		return (char) ('A' + randInt(0, 25));
	}

	public static char randChar() {
		return random.nextBoolean() ? randLowChar() : randUpperChar();
	}

	public static String randString(int length) {
		char cs[] = new char[length];
		for (int i = 0; i < cs.length; i++)
			cs[i] = randChar();
		return new String(cs);
	}

	public static char randChar(char cs[]) {
		return cs[randInt(0, cs.length - 1)];
	}

	public static String randString(char table[], int length) {
		char cs[] = new char[length];
		for (int i = 0; i < cs.length; i++)
			cs[i] = randChar(table);
		return new String(cs);
	}

	public static String[] randStrings(char table[], int length, int count) {
		String ss[] = new String[count];
		for (int i = 0; i < ss.length; i++)
			ss[i] = randString(table, length);
		return ss;
	}

	public static String randString(char table[], int lengthLeft,
			int lengthRight) {
		char cs[] = new char[randInt(lengthLeft, lengthRight)];
		for (int i = 0; i < cs.length; i++)
			cs[i] = randChar(table);
		return new String(cs);
	}

	public static String[] randStrings(char table[], int lengthLeft,
			int lengthRight, int count) {
		String ss[] = new String[count];
		for (int i = 0; i < ss.length; i++)
			ss[i] = randString(table, lengthLeft, lengthRight);
		return ss;
	}
}
