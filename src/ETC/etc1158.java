package ETC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class etc1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Queue<Integer> output = new LinkedList<>();
		LinkedList<Integer> circle = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			circle.add(i);

		int kill = 0;
		while (!circle.isEmpty()) {
			kill = (kill + M - 1) % circle.size();
			output.add(circle.remove(kill));
		}

		System.out.print("<");
		while (!output.isEmpty()) {
			System.out.print(output.poll());
			if (!output.isEmpty())
				System.out.print(", ");
		}

		System.out.println(">");

		sc.close();
	}

}
