package zj.ojd.util;

public class Printer {
    public static String toString(int arr[]) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i] + " ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    public static String toString(int arr[][]) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            buffer.append(toString(arr[i]) + "\n");
        }

        return buffer.toString();
    }

    public static String outputGraphAsMatrix(int[][] g) {
        return toString(g);
    }

    public static String outputGraphAsAdjacentTable(int[][] g) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == 1) {
                    buffer.append(i + " " + j + "\n");
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(toString(new int[] { 1, 2, 3 }));
        System.out.println(toString(new int[][] { { 1, 2, 3 }, { 1, 2, 3, }, { 1, 2, 3 } }));
        int[][] g = RandTools.randGraph(10, 20);
        System.out.println(Printer.outputGraphAsMatrix(g));
        System.out.println(Printer.outputGraphAsAdjacentTable(g));
    }

}