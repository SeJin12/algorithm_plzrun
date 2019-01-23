package DIVnCONQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11728 {
	// 큰크기[1000001]의 배열을 선언하고 해봤지만, 런타임에러
	// 퀵정렬(resursion)을 사용해봤지만, 시간초과
	// 내코드아님. 우선순위 큐를 사용하여
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken());
			pq.offer(m);
		}
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken());
			pq.offer(m);
		}
		while (!pq.isEmpty()) {
			bw.write(pq.poll() + " ");
		}
		bw.flush();
	}
}