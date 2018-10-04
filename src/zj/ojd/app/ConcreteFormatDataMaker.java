package zj.ojd.app;

import zj.ojd.format.FormatDataMaker;
import zj.ojd.util.RandTools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ConcreteFormatDataMaker extends FormatDataMaker {
    public ConcreteFormatDataMaker() {
        // //////////////////////////////////////////////////////
        super.count = 10; // 测试文件对数
        super.path += "2597";// 题目的OJ序号
        // //////////////////////////////////////////////////////
    }

    public void make(String pathname) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(pathname + ".in"));
            // //////////////////////////////////////////////////////
            int r = Integer.parseInt(pathname.substring(pathname.length() - 1));
            if (r == 0) r += 10;
            int a = 1, b = 1000;
            double q = Math.pow(b / a, 1.0 / 9);
            int c = (int) (a * Math.pow(q, r - 1));
            c = c / 10 * 10 + 1;
            pw.println(c);
            String colors[] = "green red blue white purple yellow black orange gray pink".split(" ");
            pw.println(colors[RandTools.randInt(0, 9)]);
            for (int i = 0; i < c-1; i++) {
                pw.println(colors[i % 10]);
            }
            // //////////////////////////////////////////////////////
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
