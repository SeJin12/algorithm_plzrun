package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc2089 {
	// N = (-2) * 몫 + 나머지   형태가 된다.
	// 나머지를 축적하다가 몫이 1일 때 while문 빠져나오고
	// 몫 1을 축적시킨다.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		if (N == 0) {
			System.out.println(N);
			return;
		}

		while (N != 1) {
			sb.append(Math.abs(N % (-2)));
			N = (int) Math.ceil((double) N / (-2));
		}
		sb.append(N);

		System.out.println(sb.reverse());

		br.close();
	}

}