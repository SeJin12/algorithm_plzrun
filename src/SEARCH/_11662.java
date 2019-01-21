package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		Point A = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		Point B = new Point(Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
		Point C = new Point(Integer.parseInt(tmp[4]), Integer.parseInt(tmp[5]));
		Point D = new Point(Integer.parseInt(tmp[6]), Integer.parseInt(tmp[7]));
		
		double distanceAB = Math.sqrt(Math.pow(A.x-B.x, 2)+Math.pow(A.y-B.y, 2));
		double distanceCD = Math.sqrt(Math.pow(C.x-D.x, 2)+Math.pow(C.y-D.y, 2));
		
		System.out.println(distanceAB+" "+distanceCD);
		
		
		br.close();
	}
	
	private static class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
}


