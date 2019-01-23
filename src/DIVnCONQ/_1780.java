package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1780 {
	// ¤±¤©
	static int[][] arr;
	static int[] count = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N = 3^k
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		divide(0, 0, N);
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
		
		br.close();
	}
	
	private static boolean check(int row,int col,int n) {
		int std = arr[row][col];
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++)
				if(std != arr[i][j])
					return false;
		}
		return true;
	}
	
	private static void divide(int row,int col,int n) {
		if(check(row,col,n)) {
			count[arr[row][col]+1]++;
		}else {
			int s = n/3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					divide(row+s*i, col+s*j, s);
				}
			}
		}
	}
	
}
