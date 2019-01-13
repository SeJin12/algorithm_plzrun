package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1850 {
	
	// for�� ���� ���� �ϳ��� ����ϸ� �ð��� �� �ɸ�����
	// ��Ʈ�������� Ȱ���Ͽ� ���� �ذ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		long A = Long.parseLong(s[0]);
		long B = Long.parseLong(s[1]);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < gcd(A, B); i++)
			sb.append(1);
		
		System.out.println(sb);

		br.close();
	}

	static long gcd(long x, long y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

}
