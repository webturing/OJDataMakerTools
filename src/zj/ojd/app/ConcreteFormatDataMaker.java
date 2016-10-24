package zj.ojd.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import zj.ojd.format.FormatDataMaker;
import zj.ojd.util.RandTools;

public class ConcreteFormatDataMaker extends FormatDataMaker {
	public ConcreteFormatDataMaker() {
		// //////////////////////////////////////////////////////
		super.count = 10; // 测试文件对数
		super.path += "1114";// 题目的OJ序号
		// //////////////////////////////////////////////////////
	}

	public void make(String pathname) {

		try {
			PrintWriter pw = new PrintWriter(new FileWriter(pathname + ".in"));
			// //////////////////////////////////////////////////////
			pw.println(String.format("%d %d", RandTools.randInt(0, 500),RandTools.randInt(500,100000)));
			// //////////////////////////////////////////////////////
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
