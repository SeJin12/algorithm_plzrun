package DIVnCONQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11728 {
	// ūũ��[1000001]�� �迭�� �����ϰ� �غ�����, ��Ÿ�ӿ���
	// ������(resursion)�� ����غ�����, �ð��ʰ�
	// ���ڵ�ƴ�. �켱���� ť�� ����Ͽ�
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