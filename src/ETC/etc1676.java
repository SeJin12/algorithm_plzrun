package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 0<= <=12

		int cnt2 = 0;
		int cnt5 = 0;

		for (int i = 2; i <= N; i++) {
			int num = i;
			while (true) {
				if (num % 2 == 0) {
					cnt2++;
					num /= 2;
				} else if (num % 5 == 0) {
					cnt5++;
					num /= 5;
				} else {
					break;
				}
			}
		} // End for

		System.out.println(Math.min(cnt2, cnt5));

		br.close();
	}

}
