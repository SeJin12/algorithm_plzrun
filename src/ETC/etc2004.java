package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc2004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);

		int cnt2 = 0, cnt5 = 0;

		for (int i = 2; i <= n; i *= 2) {
			cnt2 += n / i;
			if (i <= m) // i�� m�� �ɶ����� ���� n!�� 2�� ������ ���� ������ m�ɶ����� ���� ���ش�.
				cnt2 -= n / i;
			if (i <= (n - m)) // ��������, �� ���Ŀ��� �Ȼ��ش�.
				cnt2 -= n / i;
		}

		for (int i = 5; i <= n; i *= 5) {
			cnt5 += n / i;
			if (i <= m)
				cnt5 -= n / i;
			if (i <= n - m)
				cnt5 -= n / i;
		}

		System.out.println(Math.min(cnt2, cnt5)); // 0�� ���� ���

		br.close();
	}

}
