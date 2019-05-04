package zj.ojd.util;

import java.util.Arrays;
import java.util.Random;

public class RandTools {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genUniformRandomDistribution(1, 1024, 10)));
        System.out.println(Arrays.toString(genEqualDifferenceDistribution(1, 1024, 10)));
        System.out.println(Arrays.toString(genLogorithmDistribution(1, 1024, 10)));
    }

    private static Random random = new Random();

    private RandTools() {
    }

    /**
     * [a,b]区间的等差分布
     *
     * @param a
     * @param b
     * @param size
     * @return
     */
    public static int[] genEqualDifferenceDistribution(int a, int b, int size) {
        int ans[] = new int[size];
        int dif = (b - a) / (size - 1);
        for (int i = 0; i < size - 1; i++)
            ans[i] = a + dif * i;
        ans[size - 1] = b;
        return ans;
    }

    /**
     * [a,b]区间的等比分布
     *
     * @param a
     * @param b
     * @param size
     * @return
     */
    public static int[] genLogorithmDistribution(int a, int b, int size) {
        int ans[] = new int[size];
        a = Math.max(1, a);
        double r = Math.pow(b / a, 1.0 / (size - 1));
        for (int i = 0; i < size - 1; i++) {
            ans[i] = (int) (a * Math.pow(r, i));
        }
        ans[size - 1] = b;
        return ans;
    }

    /**
     * [a,b]区间的均匀随机分布
     *
     * @param left
     * @param right
     * @param count
     * @return
     */
    public static int[] genUniformRandomDistribution(int left, int right, int count) {
        int[] result = new int[count];
        for (int i = 1; i < count - 1; i++)
            result[i] = randInt(left, right);
        result[0] = left;
        result[count - 1] = right;
        Arrays.sort(result);
        return result;
    }


    public static int randInt(int left, int right) {
        return random.nextInt(right - left + 1) + left;
    }

    public static double randDouble(double left, double right) {
        return random.nextDouble() * (right - left) + left;
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
