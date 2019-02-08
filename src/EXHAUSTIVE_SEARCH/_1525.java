package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1525 {
	// FIXME 이건 못풀었다. 강의를 들어야 할것 같다.
	static int CNT = Integer.MAX_VALUE;
	static int[] dy = {-1,0,0,1}, dx = {0,-1,1,0};
	static void complete(int[][] map,int y,int x,int moveCnt) {
		if(CNT<=moveCnt)
			return;
		if(isComplete(map)) {
			CNT = Math.min(CNT, moveCnt);
			System.out.println(CNT);
			return;
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==y&&j==x)
					continue;
				for(int a=0;a<4;a++) {
					int goY = i+dy[a], goX = j+dx[a];
					if(0<=goY && goY<3 && 0<= goX && goX < 3 && map[goY][goX] == 0 ) {
						swap(map, i, j, goY, goX);
						complete(map, goY, goX, moveCnt+1);
						swap(map, i, j, goY, goX);
					}
				}
			}
		}
		
	}
	
	static void swap(int[][] map, int i,int j,int goY, int goX) {
		int tmp = map[i][j];
		map[i][j] = map[goY][goX];
		map[goY][goX] = tmp;
	}
	
	static boolean isComplete(int[][] map) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(map[i][j]!= (3*i+j+1) )
					return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[3][3];
//		check = new boolean[3][3];
		for(int i=0;i<3;i++) {
			String[] st = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
				
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				complete(map, i, j, 0);
			}
		}
		
		System.out.println(CNT);
		
		br.close();
	}
}
