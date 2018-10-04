package zj.ojd.format;

import java.util.Random;

import zj.ojd.io.InputFileMaker;
import zj.ojd.io.OutputFileMaker;

public abstract class FormatDataMaker {
	protected int count = 10;
	protected String path = "\\data";

	protected static Random random = new Random();

	public abstract void make(String pathname);

	public void make() {
		OutputFileMaker.compute(InputFileMaker.make(getClass().getName(), path,
				count));

	}

}
