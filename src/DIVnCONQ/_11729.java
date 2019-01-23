package DIVnCONQ;

import java.util.Scanner;

public class _11729 {
	// ¤±¤©
	static StringBuilder sb = new StringBuilder();
	static int ret = 0;
	
	private static void hanoiTower(int num,int from,int by,int to) {
		++ret;
		if(num==1) {
			sb.append(from+" "+to+"\n");
		}else {
			hanoiTower(num-1, from, to, by);
			sb.append(from+" "+to+"\n");
			hanoiTower(num-1, by, from, to);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1<= N <= 20
		
		hanoiTower(N, 1, 2, 3);
		sb.insert(0, ret+"\n");
		System.out.println(sb);
		
		
		sc.close();
	}
	
}
