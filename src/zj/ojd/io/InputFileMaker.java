package zj.ojd.io;

import java.io.File;
import java.util.Vector;

import zj.ojd.format.FormatDataMaker;

public class InputFileMaker {

	static void make(String className, String filenamePrefix) {
		try {
			// 反射的使用:利用字符串获得运行的类名
			((FormatDataMaker) Class.forName(className).newInstance())
					.make(filenamePrefix);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Vector<String> make(String className, String path, int m) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		Vector<String> vectors = new Vector<String>();
		for (int i = 1; i <= m; i++) {
			String filename = String.format("%s\\data%d", path, i);
			InputFileMaker.make(className, filename);
		}
		String infiles[] = file.list();// 过滤文件列表把已有的.in合并到输出列表中去
		for (String temp : infiles) {
			if (temp.endsWith(".in")) {
				vectors.add(path + "\\" + temp.substring(0, temp.length() - 3));
			}
		}
		return vectors;

	}
}
