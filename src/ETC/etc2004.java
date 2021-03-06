package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		long n = Long.parseLong(tmp[0]);
		long m = Long.parseLong(tmp[1]);

		long cnt2 = 0, cnt5 = 0;

		for (long i = 2; i <= n; i *= 2) {
			cnt2 += n / i;
			if (i <= m) // i가 m이 될때까지 분자 n!의 2의 개수와 같기 때문에 m될때까지 같이 빼준다.
				cnt2 -= m / i;
			if (i <= (n - m)) // 마찬가지, 그 이후에는 안빼준다.
				cnt2 -= (n - m) / i;
		}
		for (long i = 5; i <= n; i *= 5) {
			cnt5 += n / i;
			if (i <= m)
				cnt5 -= m / i;
			if (i <= n - m)
				cnt5 -= (n - m) / i;
		}

		System.out.println(Math.min(cnt2, cnt5)); // 0의 개수 출력

		br.close();
	}

}
