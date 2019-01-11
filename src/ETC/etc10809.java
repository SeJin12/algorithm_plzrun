package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class etc10809 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();

		int[] store = new int[26];
		Arrays.fill(store, -1);
		
		for (int i = 0; i < word.length; ++i) {
			if(store[word[i] - 'a']>=0)
				continue;
			store[word[i] - 'a'] = i;
		}

		for (int i = 0; i < store.length; ++i)
			System.out.print(store[i] + " ");

		br.close();
	}
}
