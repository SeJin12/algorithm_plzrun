package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc10820 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String words = "";
		while( (words = br.readLine()) != null ) {
			print(words);
		}
		
		br.close();
	}
	
	static void print(final String s) {
		char[] word = s.toCharArray();

		int[] classify = new int[4];

		for (int i = 0; i < word.length; ++i) {
			char c = word[i];
			if ('a' <= c && c <= 'z')
				classify[0] += 1;
			if ('A' <= c && c <= 'Z')
				classify[1] += 1;
			if ('0' <= c && c <= '9')
				classify[2] += 1;
			if (c == ' ')
				classify[3] += 1;
		}

		for (int i = 0; i < classify.length; ++i)
			System.out.print(classify[i] + " ");

	}
}
