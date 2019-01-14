package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc1929 {

	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp = br.readLine().split(" ");
		M = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);


		for (int i = M; i <= N; i++)
			if(isPrime(i))
				bw.write(i+"\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static boolean isPrime(int num) {
		if (num == 1)
			return false;

		for (int i = 2; i * i <= num; i++)
			if (num % i == 0) {
				return false;
			}
		
		return true;
	}

}
