package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] tmp = br.readLine().split(" ");

		for (int i = 0; i < tmp.length; i++)
			arr[i] = Integer.parseInt(tmp[i]);

		int ret = 0;
		for (int i : arr)
			if (isPrime(i))
				ret++;

		System.out.println(ret);

		br.close();
	}

	static boolean isPrime(int num) {
		if (num == 1)
			return false;

		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		return true;
	}

}
