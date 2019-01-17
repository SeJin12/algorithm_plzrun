package GRAPH;

import java.util.ArrayList;
import java.util.Scanner;

public class _2331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int P = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		list.add(A);
		int idx = 0;

		while (true) {
			int tmp = 0;
			while (A != 0) {
				tmp += Math.pow(A % 10, P);
				A /= 10;
			}
			A = tmp;
			if (list.contains(A)) {
				idx = list.indexOf(A);
				break;
			}
			list.add(A);
		}
		System.out.println(idx);

		sc.close();
	}
}
