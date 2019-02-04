package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {
	// ��Ÿ�� ������ ���� ����. �迭�� �ε����� �ʰ��ؼ� while���� ����
	// �� �״�� ��������, �϶�� ��� �ϸ� �Ǵ� ������ ���� �����ΰ� ����.
	static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// S==G �� ���� ���
		if (S == G) {
			System.out.println(0);
		} else {
			int[] floor = new int[1_000_001];
			Arrays.fill(floor, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(S);
			floor[S] = 0;
			while (!q.isEmpty()) {
				int curloc = q.poll();
				// ���� ������ �ٷ� ���� if���� ���� �տ� �־ �迭�� �ε��� ������ ����� ���� �����־���.
				// A && B ������  A��  false �� �ڿ��� ������ �ʰ� �Ѿ�� ������ �̸� �̿��Ͽ� ������ �־���.
				if (curloc - D >= 1 && floor[curloc - D] == -1 && (curloc - D) != curloc) {
					// ���� �κп�  if(curloc - D >= 1) �� �־����µ� 
					q.add(curloc - D);
					floor[curloc - D] = floor[curloc] + 1;

				}
				if (curloc + U <= F && floor[curloc + U] == -1 && (curloc + U) != curloc) {
					q.add(curloc + U);
					floor[curloc + U] = floor[curloc] + 1;
				}
			}
			System.out.println(floor[G] == -1 ? "use the stairs" : floor[G]);
		}
		br.close();
	}

}
