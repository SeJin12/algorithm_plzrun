package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc10872 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 0<= <=12

		int ret = factorial(N);
		bw.write(String.valueOf(ret));

		bw.flush();
		bw.close();
		br.close();
	}

	static int factorial(int n) {
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

}
