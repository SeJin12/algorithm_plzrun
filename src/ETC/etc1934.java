package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);


			System.out.println(A * B / gcd(A, B));
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
