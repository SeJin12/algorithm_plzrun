package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1107 {
	//FIXME 일단 넘기고 , 중급 알고리감 강의때 풀어야함 도저히 답이안나온다.
	static boolean[] btn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수빈이가 지금 보고 있는 채널은 100번이다.
		int N = Integer.parseInt(br.readLine().trim()); // [0,500000]
		int M = Integer.parseInt(br.readLine().trim()); // 고장난 버튼의 개수
		btn = new boolean[10];
		Arrays.fill(btn, true);
		String[] st = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			btn[Integer.parseInt(st[i])] = false;
		}
		
		int nowChannel = 100;
		int leastCtn = clickPMBtn(nowChannel, N);
		int btnCtn;
		while(true) {
			break;
		}
		
		System.out.println(leastCtn);
		
		br.close();
	}
	static int clickPMBtn(int nowChannel,int target) {
		if(nowChannel<=target)
			return target-nowChannel;
		return nowChannel-target;
	}
}
