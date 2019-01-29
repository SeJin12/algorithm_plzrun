package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11399 {

	static int N; // ( 0,1000 ]

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(tmp[i]);
		
		// 무조건 ATM 인출 시간이 적은 사람이 먼저 뽑는 것이 총 시간의 최소값을 만들 수 있다.
		// 그렇지 않다면, 앞의 시간들이 누적되어 더 많은 시간이 걸리기 때문이다.
		Arrays.sort(arr);

		int time = arr[0];

		for (int i = 1; i < N; i++) {
			arr[i] += arr[i - 1];
			time += arr[i];
		}

		System.out.println(time);

		br.close();
	}

}
