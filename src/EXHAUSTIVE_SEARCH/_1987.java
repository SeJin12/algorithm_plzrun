package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1987 {

	static int R, C; // 가로 세로
	static int[] dy = { -1, 0, 0, 1 }, dx = { 0, -1, 1, 0 };
	static int ret = 1;

	static boolean findChar(String sentence, char ch) {
		for (int i = 0; i < sentence.length(); i++)
			if (sentence.charAt(i) == ch)
				return true;
		return false;
	}

	static void dfs(String[] map, int sy, int sx, String s, int cnt) {
		for (int i = 0; i < 4; i++) {
			int y = sy + dy[i], x = sx + dx[i];
			if (0 <= y && y < R && 0 <= x && x < C && !findChar(s, map[y].charAt(x))) {
				ret = Math.max(ret, cnt + 1);
				dfs(map, y, x, s + map[y].charAt(x), cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);

		String[] map = new String[R];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine();
		}

		dfs(map, 0, 0, "" + map[0].charAt(0), 1);
		System.out.println(ret);
		br.close();
	}
}

class Horse {
	int y, x;
	String setence;
	int cnt;

	Horse(int y, int x, String sentence, int cnt) {
		this.y = y;
		this.x = x;
		this.setence = sentence;
		this.cnt = cnt;
	}
}