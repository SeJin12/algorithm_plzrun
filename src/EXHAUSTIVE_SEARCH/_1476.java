package EXHAUSTIVE_SEARCH;

import java.util.Scanner;

public class _1476 {
	static int E, S, M;// [1 - 15] 28] 19]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		sc.close();

		int year = 1;
		int myE = 1;
		int myS = 1;
		int myM = 1;

		while (true) {
			if (myE == E && myS == S && myM == M) {
				System.out.println(year);
				break;
			}
			if (myE == 15)
				myE = 1;
			else
				myE++;

			if (myS == 28)
				myS = 1;
			else
				myS++;

			if (myM == 19)
				myM = 1;
			else
				myM++;
			year++;

		}
	}

}
