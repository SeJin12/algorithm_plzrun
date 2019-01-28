package GREEDY;

import java.util.Scanner;

public class _1783 {

	final static int[] dy = { 2, -2, 1, -1 };
	final static int[] dx = { 1, 1, 2, 2 };
	// 느낀 점 : 문제 해석을 잘해야 하고, 반례를 잘 찾을 줄 알아야 한다.
	// 이동 횟수 == 방문 칸의 수 인지도 헷갈리고
	// 모든 이동 방법을 1번 이상 사용하는 경우가 이동 횟수 4이상인지 4초과인지 헷갈린다.. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		int ret = 0;
		if(N==1) { // 세로가 1일 경우 이동을 못하기 때문에 처음 위치 1개만 방문
			ret = 1;
		}else if(N==2){ // 세로가 2일 경우 오른쪽으로 2번씩 가는 경우 밖에 없다.
			ret = Math.min(4, (M+1)/2); 
		}else { // 세로가 3이상일 경우 모든 경우의 수가 가능해진다.( 단, 가로의 크기에 따라 달라짐 )
			if(M<7) {
				ret = Math.min(4, M);
			}else {
				ret= M-2; // 무조건 4번의 이동 경우를 해줘야하기 때문에 가로로 2칸은 2번만 이동하고, 나머지는 1칸씩 이동해야한다.
			}
		}

		System.out.println(ret);

	}

}
