package zj.ojd.format;

import zj.ojd.io.InputFileMaker;
import zj.ojd.io.OutputFileMaker;

import java.io.IOException;

public abstract class FormatDataMaker {
    protected int count = 10;
    protected String path = "AOJdata/";


    public abstract void make(String pathname);

    public void make() {
        OutputFileMaker.compute(InputFileMaker.make(getClass().getName(), path,
                count));

    }

}
