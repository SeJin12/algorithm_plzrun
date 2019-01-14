package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc6588 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = 0; // 6<= <= 100_0000
		while ((input = Integer.parseInt(br.readLine())) != 0) {
			int i;
			for (i = 3; i <= input / 2; i++) {
				if (isPrime(i) && isPrime(input - i)) {
					bw.write(input + " = " + i + " + " + (input - i));
					bw.newLine();
					break;
				}
			}
			if (i > input) {
				bw.write("Goldbach's conjecture is wrong.");
				bw.newLine();
			}
			bw.flush();
		}

		bw.close();
		br.close();
	}

	static boolean isPrime(int n) {
		if (n == 1 || n == 2)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
