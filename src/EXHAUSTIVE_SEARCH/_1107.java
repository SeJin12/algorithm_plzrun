package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1107 {
	//FIXME �ϴ� �ѱ�� , �߱� �˰��� ���Ƕ� Ǯ����� ������ ���̾ȳ��´�.
	static boolean[] btn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �����̰� ���� ���� �ִ� ä���� 100���̴�.
		int N = Integer.parseInt(br.readLine().trim()); // [0,500000]
		int M = Integer.parseInt(br.readLine().trim()); // ���峭 ��ư�� ����
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
