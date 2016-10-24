package zj.ojd.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * �ض��򹤾���
 * 
 * @author Administrator
 * 
 */
public class RedirectTools {
	public static void setStdin(String filename) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (fis != null)
			System.setIn(fis);
	}

	public static void setStdout(String filename) {

		PrintStream out = null;
		try {
			out = new PrintStream(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (out != null)
			System.setOut(out);
	}

	public static void setIO(String filename) {
		setStdin(filename + ".in");
		setStdout(filename + ".out");
	}
}
