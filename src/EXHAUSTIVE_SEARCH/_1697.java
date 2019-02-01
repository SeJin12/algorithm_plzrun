package EXHAUSTIVE_SEARCH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
	// Ǯ�̹� : ó���� DFS�� �����ߴµ�, StackOverflow�� ��� �ɷȴµ�
	// BFS�� Ǯ�� Ȯ���� Ƚ���� ���� �� �־���.
	// ref : https://zoonvivor.tistory.com/90
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ����s
		int K = sc.nextInt(); // ����s
		int[] Min = new int[100005];
		Arrays.fill(Min, -1);
		
		int nextN = N;
		int[] status = new int[3];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(nextN);
		Min[nextN] = 0;
		
		while(!q.isEmpty() && nextN != K) {
			nextN = q.poll();
			// ������ �̵��� ��ǥ��
			status[0] = nextN - 1;
			status[1] = nextN + 1;
			status[2] = nextN * 2;
			
			for(int i=0;i<3;i++) {
				if(0<=status[i]&&status[i]<=100000) { // �迭 ���� ������� Ȯ��
					if(Min[status[i]] == -1) { // ������ �湮�ߴ���
						q.add(status[i]);
						Min[status[i]] = Min[nextN] + 1;
					}
				}
			}
		}
		
		System.out.println(Min[K]);
		sc.close();
	}
}
