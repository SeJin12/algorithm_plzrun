package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class _2261 {
	//FIXME: 기초플러스 중급듣고 꼭 하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			arr.add(new Point(Integer.parseInt(st[0]), Integer.parseInt(st[1])));
		}

		arr.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return Integer.compare(o1.y, o2.y);
				return Integer.compare(o1.x, o2.x);
			}
		});

		// ret
	}

	private static int calDistance(Point A, Point B) {
		int x = A.x - B.x;
		int y = A.y - B.y;
		double ret = Math.pow(x, 2) + Math.pow(y, 2);
		return (int) ret;
	}

	private static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
