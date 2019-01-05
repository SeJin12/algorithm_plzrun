package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp11054 {

	static int[] seq, idp, ddp; // ¼ö¿­, increase, decrease

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		seq = new int[n];
		idp = new int[n];
		ddp = new int[n];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			seq[i] = Integer.parseInt(s[i]);

		for (int a = 0; a < n; a++) {
			for (int i = 0; i < a; i++) {
				if (seq[i] < seq[a])
					idp[a] = Math.max(idp[a], idp[i] + 1);
			}
		}

		for (int a = n - 1; a >= 0; a--) {
			for (int i = n - 1; i > a; i--) {
				if (seq[a] > seq[i])
					ddp[a] = Math.max(ddp[a], ddp[i] + 1);
			}
		}

		int ret = 0;
		for (int i = 0; i < n; i++)
			ret = Math.max(ret, idp[i] + ddp[i] + 1);

		System.out.println(ret);
		br.close();
	}

}
