package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc11576 {
	// ref : http://dionysus2074.tistory.com/92
	// 못 푼 이유 : 문제를 계속하여 정독하였지만 이해를 하지 못했다.
	// m은 A진법의 자리수를 뜻하며, 예제출력에서 답이 6 2 가 나오는 것은
	// 62(8진법) 각 자리수를 뜻한다
	// 2개의 저장공간 [2][16](17진법) -> 50(10진법) -> 62(8진법)
	static int[] arr = new int[26];

	static int AtoTen(int A, int m) {
		int ans = 0;
		for (int i = 1; i <= m; i++) {
			ans = ans * A + arr[i]; // A진법을 10진수로 바꾸는 방법
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
		int A = Integer.parseInt(s[0]); // 미래 진법
		int B = Integer.parseInt(s[1]); // 현재 진법
		int m = Integer.parseInt(br.readLine()); // 숫자의 자리수의 개수
		s = br.readLine().split(" ");

		for (int i = 1; i <= m; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
		}

		int number = AtoTen(A, m);
		TentoB(number, B);

		br.close();
	}

}