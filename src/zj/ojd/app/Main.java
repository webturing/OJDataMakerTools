package zj.ojd.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int from = cin.nextInt(), to = cin.nextInt();
		if (from <= 100)
			from = 100;
		if (to >= 999)
			to = 999;
		for (int i = from; i <= to; i++) {

			int a = i / 100;
			int b = (i % 100 / 10);
			int c = (i % 10);
			if (i == a * a * a + b * b * b + c * c * c)
				System.out.println(String.format("%d", i));
		}
	}
}
