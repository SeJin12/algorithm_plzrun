package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {
	static int L, C; // 3 <= L <= C <= 15
	static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
	static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++)
			arr[i] = st.nextToken().charAt(0);
		
		Arrays.sort(arr);

		for (int i = 0; i <= C - L; i++) {
			dfs(i, 1, "" + arr[i]);
		}

		br.close();
	}

	static boolean check(String s) {
		int vowel = 0;
		for(int i=0;i<L;i++) {
			for(int j=0;j<vowels.length;j++) {
				if(s.charAt(i)==vowels[j]) {
					vowel++;
					break;
				}
			}
		}
		int consonant = L-vowel;
		if(vowel>=1 && consonant>=2)
			return true;
		return false;
	}

	static void dfs(int cur, int cnt, String s) {
		if (cnt == L)
			if (check(s)) {
				System.out.println(s);
				return;
			}

		for (int i = cur + 1; i < C; i++) {
			dfs(i, cnt + 1, s + arr[i]);
		}
	}

}
