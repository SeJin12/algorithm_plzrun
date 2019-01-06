package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class etc11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		Point[] arr = new Point[n];
		
		String[] s;
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			arr[i] = new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		
		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x==o2.x)
					return Integer.compare(o1.y, o2.y);
				return Integer.compare(o1.x, o2.x);
			}
		});
		
		for(Point p:arr)
			System.out.println(p.x+" "+p.y);
		
		br.close();
	}
}

