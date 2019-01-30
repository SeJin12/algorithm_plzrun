package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2873 {
	//FIXME 많이 어려운 문제다. 강의를 듣고 다시 분석
	static int R, C; // [2,1000]

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		R = Integer.parseInt(st[0]); // R의 값이 odd,even에 따라 이동하는 법이 달라진다.
		C = Integer.parseInt(st[1]);

		StringBuilder sb = new StringBuilder();
		// 배열의 인덱스는 [0,R) [0,C)
		if (R % 2 == 1) { // 세로가 홀수일 경우
			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C - 1; x++) {
					if (y % 2 == 0) // C-2 만큼 오른쪽(R)
						sb.append("R");
					else // C-2 만큼 왼쪽(L)
						sb.append("L");
				}
				if (y != R - 1) // for문을 다 돌고 난 후 마지막 행이 아니면 계속 아래로 내려가고 마지막 행에서는 도착하였으므로 그만
					sb.append("D");
			}
		} else if (R % 2 == 0 && C % 2 == 1) {// 가로가 홀수일 경우 && 세로가 홀수
			for (int x = 0; x < C; x++) {
				for (int y = 0; y < R - 1; y++) {
					if (x % 2 == 0)
						sb.append("D");
					else
						sb.append("U");
				}
				if (x != C - 1)
					sb.append("R");
			}
		} else if (R % 2 == 0 && C % 2 == 0) { // 세로 가로가 짝수일 경우
			// 검은 칸이면서 지나지 말아야 할 지점
			Pair minHappy = new Pair(0, 0);
			int minScore = Integer.MAX_VALUE;
			int[][] loc = new int[R][C];
			for (int y = 0; y < R; y++) {
				st = br.readLine().split(" ");
				for (int x = 0; x < C; x++) {
					loc[y][x] = Integer.parseInt(st[x]);
					// 검은 칸이고 최소점수 ++
					if ((y + x) % 2 == 1 && minScore > loc[y][x]) {
						minScore = loc[y][x];
						minHappy.first = y;
						minHappy.second = x;
					}
				}
			}
			// 지나지 말아야 할 좌표의 최좌측으로 내려오고
			int newR = minHappy.first % 2 == 1 ? minHappy.first - 1 : minHappy.first;
			for (int y = 0; y < newR; y++) {
				for (int x = 0; x < C - 1; x++)
					if (y % 2 == 0)
						sb.append("R");
					else
						sb.append("L");
				sb.append("D");
			}
			// 지나지 말아야 할 좌표의 대각선 아래까지 이동하고 ( ↙ )
			int newC = minHappy.second;
			for (int x = 0; x < newC; x++)
				if (x % 2 == 0)
					sb.append("DR");
				else
					sb.append("UR");

			// 지나지 말아야 할 좌표의 최우측으로 이동
			for (int x = newC; x < C - 1; x++)
				if (x % 2 == 0)
					sb.append("RD");
				else
					sb.append("RU");

			// 목적지까지
			if (minHappy.first % 2 == 0)
				newR = R - (minHappy.first + 2);
			else
				newR = R - (minHappy.first + 1);

			for (int y = 0; y < newR; y++) {
				sb.append("D");
				for (int x = 0; x < C - 1; x++)
					if (y % 2 == 0)
						sb.append("L");
					else
						sb.append("R");
			}

		}

		System.out.println(sb);

		br.close();
	}

	private static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
