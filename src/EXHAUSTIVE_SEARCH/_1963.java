package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1963 {

	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		list = new ArrayList<String>();
		String[] st = new String[2];

		for (int i = 1000; i < 10000; i++) {
			if (isPrime(i))
				list.add(String.valueOf(i));
		}

		while (T-- > 0) {
			st = br.readLine().split(" ");
			String prePass = st[0];
			String postPass = st[1];

			if (prePass.equals(postPass)) {
				System.out.println(0);
				continue;
			}
			int[] check = new int[list.size()];
			Arrays.fill(check, -1);

			Queue<String> q = new LinkedList<>();
			q.add(prePass);
			check[list.indexOf(prePass)] = 0;

			while (!q.isEmpty()) {
				String tmpS = q.poll();
				for (int i = 0; i < list.size(); i++) {
					if (check[i] == -1 && isOneCnt(tmpS, list.get(i))) {
						q.add(list.get(i));
						check[i] = check[list.indexOf(tmpS)] + 1;
					}
				}
			}
			if (check[list.indexOf(postPass)] == -1)
				System.out.println(0);
			else
				System.out.println(check[list.indexOf(postPass)]);

		}

		br.close();
	}

	static boolean isOneCnt(String from, String to) {
		int differCnt = 0;
		for (int i = 0; i < 4; i++) {
			if (from.charAt(i) != to.charAt(i))
				differCnt++;
		}
		if (differCnt == 1)
			return true;
		return false;
	}

	static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}
