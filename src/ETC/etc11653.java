package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc11653 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 1000_0000(Ãµ¸¸)
		int div = 2;
		while (N != 1) {
			if (N % div == 0) {
				bw.write(div + "\n");
				N /= div;
			} else
				div++;
		}
		bw.flush();

		bw.close();
		br.close();
	}

}
