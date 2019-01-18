package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _4963 {
	
	final static int[] dy = {-1,-1,-1,0,0,1,1,1};
	final static int[] dx = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp;
		
		while(true) {
			tmp = br.readLine().split(" ");
			
			int w = Integer.parseInt(tmp[1]);
			int h = Integer.parseInt(tmp[0]);
			
			if(h==0 && w==0)
				break;
				
			int[][] land = new int[w+1][h+1];
			
			for (int i = 1; i <= w; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 1; j <= h; j++) {
					land[i][j] = Integer.parseInt(tmp[j - 1]);
				}
			}

			
			int landCnt = 0;
			boolean[][] check = new boolean[w+1][h+1];
			for (int i = 1; i <= w; i++) {
				for (int j = 1; j <= h; j++) {
					if (land[i][j] == 1 && !check[i][j]) {
						Queue<__Point> q = new LinkedList<>();
						q.add(new __Point(i, j));
						check[i][j] = true;
						while (!q.isEmpty()) {
							__Point p = q.poll();
							for (int a = 0; a < 8; a++) {
								int py = p.y + dy[a];  
								int px = p.x + dx[a];
								if (0 < px && px <= h && 0 < py && py <= w && land[py][px] == 1 && !check[py][px]) {
									q.add(new __Point(py, px));
									check[py][px] = true;
								}
							}
						} // while End
						landCnt++;
					}
				}
			}
			System.out.println(landCnt);
			
		} // while end : Test case

		br.close();
	}

}

class __Point {
	int y,x;

	__Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
