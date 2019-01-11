package ETC;

import java.util.Scanner;

public class etc11655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] words = sc.nextLine().toCharArray();

		for (int i = 0; i < words.length; i++) {
			char c = words[i];
			if ('a' <= c && c <= 'z') {
				int len = (c + 13 - 'a') % 26;
				words[i] = (char) ('a' + len);
			}
			if ('A' <= c && c <= 'Z') {
				int len = (c + 13 - 'A') % 26;
				words[i] = (char) ('A' + len);
			}
		}

		for (char c : words)
			System.out.print(c);

		sc.close();
	}

}
