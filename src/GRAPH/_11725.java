package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _11725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			list.add(new ArrayList<Integer>());

		for (int i = 1; i <= N - 1; i++) {
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}

		int[] arr = new int[N + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while (!q.isEmpty()) {
			int su = q.poll();
			for (int a : list.get(su)) {
				if (arr[a] == 0) {
					q.add(a);
					arr[a] = su;
				}
			}
		}

		for (int i = 2; i <= N; i++)
			System.out.println(arr[i]);

		br.close();
	}

}
