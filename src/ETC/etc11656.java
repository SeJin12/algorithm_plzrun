package ETC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class etc11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		String[] suffix = new String[word.length()];

		for (int i = 0; i < word.length(); i++) {
			suffix[i] = word.substring(i);
		}

		Arrays.sort(suffix, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		for (String s : suffix)
			System.out.println(s);

		sc.close();
	}
}
