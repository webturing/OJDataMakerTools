package zj.ojd.io;

import zj.ojd.app.Main;

import java.util.Vector;

public class OutputFileMaker {

    public static void compute(Vector<String> files) {
        for (String filename : files) {
            RedirectTools.setIO(filename);
            Main.main(null);// Try to call Main.main
        }
    }
}
