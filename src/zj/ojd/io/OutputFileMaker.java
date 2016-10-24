package zj.ojd.io;

import java.util.Vector;

import zj.ojd.app.Main;

public class OutputFileMaker {

	public static void compute(Vector<String> files) {
		for (String filename : files) {
			RedirectTools.setIO(filename);
			Main.main(null);// Try to call Main.main
		}
	}
}
