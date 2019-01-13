package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc9613 {
	// Ʋ�� ���� : �� ���� ù��°���� ������ �־�����.(���� ����� �б�)
	// ������ ȸ���� N^2(N<=100) �̰� �Է��� 100_0000 �̹Ƿ� ������� ������ int ���� �ʰ� long���� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		while (T-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int[] arr = new int[Integer.parseInt(tmp[0])];

			for (int i = 0; i < tmp.length - 1; i++)
				arr[i] = Integer.parseInt(tmp[i + 1]);

			long ret = 0;
			for (int i = 0; i < tmp.length - 1; i++)
				for (int j = i + 1; j < tmp.length - 1; j++)
					ret += gcd(arr[i], arr[j]);

			System.out.println(ret);
		}

		br.close();
	}

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

}
