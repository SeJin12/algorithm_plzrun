package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]); // GIRL
		int M = Integer.parseInt(st[1]); // BOY
		int K = Integer.parseInt(st[2]);

		int cntTeam = 0;
		// 여자(N)과 남자(M)을 비교할 때, 2명인 여자를 먼저 뺀다고 가정한다.
		// why? 1명으로 팀을 이룰 수 있는 남자 쪽이 유리하기 때문에
		while (K-- > 0) {
			if (N / 2 >= M)
				N--;
			else
				M--;
		}

		cntTeam = N / 2 <= M ? N / 2 : M;

		System.out.println(cntTeam);

		br.close();
	}
}
