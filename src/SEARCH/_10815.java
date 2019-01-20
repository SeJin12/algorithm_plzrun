package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] myCard = new int[N];

		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			myCard[i] = Integer.parseInt(tmp[i]);
		Arrays.sort(myCard);

		int M = Integer.parseInt(br.readLine().trim());
		int[] checkCard = new int[M];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			checkCard[i] = Integer.parseInt(tmp[i]);

		for (int i = 0; i < M; i++) {
			int front = 0;
			int rear = N - 1;
			int middle;
			int key = checkCard[i];
			int ret = 0;
			while (front < rear) {
				middle = (front + rear) / 2;
				if (key == myCard[front] || key == myCard[middle] || key == myCard[rear]) {
					ret = 1;
					break;
				}
				if (key < myCard[middle]) {
					rear = middle - 1;
				} else {
					front = middle + 1;
				}
			}
			System.out.print(ret + " ");
		}

		br.close();
	}

}
