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
		
		// ������ ATM ���� �ð��� ���� ����� ���� �̴� ���� �� �ð��� �ּҰ��� ���� �� �ִ�.
		// �׷��� �ʴٸ�, ���� �ð����� �����Ǿ� �� ���� �ð��� �ɸ��� �����̴�.
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
