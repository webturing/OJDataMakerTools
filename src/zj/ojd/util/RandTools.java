package zj.ojd.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandTools {
    public static String[] FAKE_NAMES = "Barbra Lathrop Kelby Abbey Zayden Aison Rocia Verlene Eri Creda Victoria Tamika Gar Lawrence Diann Lucille Adrianne Leane Hogan Deena Hillary Gard Cater Shelly Nalany Kegan Alem Arleen Anais Kalil Bruno Onesimus Celia Doyle Barnaby Kanga Amanda Paris Kenneth Mate Debby Ethelbert Asher Kaloosh Gazelle Hilliard Normandy Wilhelmine Gaston Xavier Orion Carlton Gideon Aleda Garwood Abbie Phillida Chuck Laverne Thema Darby Kaya Gereldine Flavian Ursala Topaza Conway Vynona Braden Deanna Eleanora Percival Ella Peers Roxy Oshun Ajani Terris Bjorn Aurelie"
            .trim().split("\\s+");

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
        if (size == 1) {
            ans[0] = a;
            return ans;
        }
        a = Math.max(1, a);
        double r = Math.pow(b / a, 1.0 / (size - 1));
        for (int i = 0; i < size - 1; i++) {
            ans[i] = Math.max(1, (int) (a * Math.pow(r, i)));
        }
        ans[0] = a;
        for (int i = 1; i < size; i++) {
            ans[i] = Math.max(ans[i], ans[i - 1] + 1);
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
       // Arrays.sort(result);
        shuffle(result);
        return result;
    }

    public static int randInt10() {
        return randInt(10);
    }

    public static int randInt100() {
        return randInt(100);
    }

    public static int randInt(int end) {
        return randInt(0, end);
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

    public static String randString(char table[], int lengthLeft, int lengthRight) {
        char cs[] = new char[randInt(lengthLeft, lengthRight)];
        for (int i = 0; i < cs.length; i++)
            cs[i] = randChar(table);
        return new String(cs);
    }

    public static String[] randStrings(char table[], int lengthLeft, int lengthRight, int count) {
        String ss[] = new String[count];
        for (int i = 0; i < ss.length; i++)
            ss[i] = randString(table, lengthLeft, lengthRight);
        return ss;
    }

    public static String randLetters(int lengthLeft, int lengthRight) {
        return randString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(), lengthLeft,
                lengthRight);
    }

    public static String randLetterAndNumberStrings(int lengthLeft, int lengthRight) {
        return randString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(), lengthLeft,
                lengthRight);
    }

    public static String randWord(String[] name) {
        return name[randInt(0, name.length - 1)];
    }

    public static String[] randWords(String[] name, int tot) {
        String[] data = new String[tot];
        for (int i = 0; i < tot; i++)
            data[i] = new String(name[randInt(0, name.length - 1)]);
        return data;
    }

    public static String[] randUniqueWords(String[] S, int tot) {
        if (tot > S.length)
            return S;
        List<String> L = Arrays.asList(S);
        Collections.shuffle(L);
        String[] data = new String[tot];
        for (int i = 0; i < tot; i++) {
            data[i] = L.get(i);
        }
        return data;
    }

    public static String randName() {
        return randWord(FAKE_NAMES);
    }

    public static String[] randNames(int tot) {
        return randWords(FAKE_NAMES, tot);
    }

    public static long randLong() {
        long res = 0;
        for (int i = 0; i < 63; i++) {
            long d = Math.random() < 0.5 ? 0 : 1;
            res = res * 2 + d;
        }
        return res;
    }

    public static Date randDate(String beginDate, String endDate, String df) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(df);
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if (start.getTime() >= end.getTime()) {
                return null;
            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date randDate(String beginDate, String endDate) {
        return randDate(beginDate, endDate, new String("yyyy/mm/dd"));

    }

    public static Date randDate() {
        return randDate("1900/1/1", "2099/1/1");
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genUniformRandomDistribution(1, 1024, 10)));
        System.out.println(Arrays.toString(genEqualDifferenceDistribution(1, 1024, 10)));
        System.out.println(Arrays.toString(genLogorithmDistribution(1, 1024, 10)));
        System.out.println(Arrays.toString(genLogorithmDistribution(1, 20, 10)));
        System.out.println(Arrays.asList(randNames(10)));
        System.out.println(
                Arrays.asList(randUniqueWords("zero one two three four five six seven eight nine ten".split(" "), 3)));
        System.out.println(randDate("1970/01/01", "2030/1/1", "yyyy/mm/dd"));
    }

    public static void shuffle(int data[]) {
        for (int i = 0; i < data.length; i++) {
            int j = randInt(i, data.length - 1);
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

    }

    public static int[][] randGraph(int vn, int en) {
        int[] data = new int[vn * vn];
        Arrays.fill(data, 0, en, 1);
        shuffle(data);
        int[][] g = new int[vn][vn];
        for (int i = 0; i < vn * vn; i++) {
            g[i / vn][i % vn] = data[i];
        }
        return g;

    }
}
