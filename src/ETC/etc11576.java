package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc11576 {
	// ref : http://dionysus2074.tistory.com/92
	// �� Ǭ ���� : ������ ����Ͽ� �����Ͽ����� ���ظ� ���� ���ߴ�.
	// m�� A������ �ڸ����� ���ϸ�, ������¿��� ���� 6 2 �� ������ ����
	// 62(8����) �� �ڸ����� ���Ѵ�
	// 2���� ������� [2][16](17����) -> 50(10����) -> 62(8����)
	static int[] arr = new int[26];

	static int AtoTen(int A, int m) {
		int ans = 0;
		for (int i = 1; i <= m; i++) {
			ans = ans * A + arr[i]; // A������ 10������ �ٲٴ� ���
		}
		return ans;
	}

	static void TentoB(int n, int B) {
		int r = 0;
		ArrayList<Integer> v = new ArrayList<>();
		while (n != 0) {
			r = n % B;
			n /= B;
			v.add(r);
		}
		for (int i = v.size() - 1; i >= 0; i--)
			System.out.print(v.get(i) + " ");
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]); // �̷� ����
		int B = Integer.parseInt(s[1]); // ���� ����
		int m = Integer.parseInt(br.readLine()); // ������ �ڸ����� ����
		s = br.readLine().split(" ");

		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
		}

		int number = AtoTen(A, m);
		TentoB(number, B);

		br.close();
	}

}