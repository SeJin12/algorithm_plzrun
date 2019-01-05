package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] sticker = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				String[] stmp = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					sticker[i][j] = Integer.parseInt(stmp[j - 1]);
				}
			}

			int[][] score = new int[2][N + 1];
			score[0][1] = sticker[0][1];
			score[1][1] = sticker[1][1];

			for (int i = 2; i <= N; i++) {
				score[0][i] = sticker[0][i] + Math.max(score[1][i - 1], score[1][i - 2]);
				score[1][i] = sticker[1][i] + Math.max(score[0][i - 1], score[0][i - 2]);
			}

			System.out.println(Math.max(score[0][N], score[1][N]));

		}

		br.close();
	}

}
