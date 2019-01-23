package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2447_other {
	// https://joosjuliet.github.io/2447/
	// 규칙을 찾아내어 풀이한 색다른 방법이다. 이런 방법이 있구나
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		process(Integer.parseInt(br.readLine()));
		br.close();
	}

	private static void process(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = i, y = j;
				while (x > 0) {
					if (x % 3 == 1 && y % 3 == 1)
						break;
					x /= 3;
					y /= 3;
				}
				// 1,4,7 즉 나머지가 1인 것들만 자기 숫자가 나오고 아닌 것들은 0이 된다.
				sb.append(x == 0 ? '*' : ' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
