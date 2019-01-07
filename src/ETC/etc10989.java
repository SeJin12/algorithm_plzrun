package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc10989 {
	// sort시 최악의 복잡도로 O(N^2)의 시간이 걸릴 수 있기? 때문에 시간초과
	// 메모이제이션을 활용하여 시간을 줄인다.
	// System.out.println를 쓰면 시간초과가 걸리기 때문에 BufferedWriter를 쓴다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int[] cache = new int[10001];

		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp = Integer.parseInt(br.readLine().trim());
			cache[temp] += 1;
		}

		for (int i = 1; i <= 10000; ++i) {
			if (cache[i] > 0)
				for (int j = 0; j < cache[i]; j++)
					bw.write(i + "\n");
		}
		bw.close();
		br.close();
	}

}