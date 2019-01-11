package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();

		int[] store = new int[26];
		for (int i = 0; i < word.length; ++i) {
			store[word[i] - 'a'] += 1;
		}

		for (int i = 0; i < store.length; ++i)
			System.out.print(store[i] + " ");

		br.close();
	}
}
