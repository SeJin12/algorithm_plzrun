package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc2089 {
	// N = (-2) * �� + ������   ���°� �ȴ�.
	// �������� �����ϴٰ� ���� 1�� �� while�� ����������
	// �� 1�� ������Ų��.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		if (N == 0) {
			System.out.println(N);
			return;
		}

		while (N != 1) {
			sb.append(Math.abs(N % (-2)));
			N = (int) Math.ceil((double) N / (-2));
		}
		sb.append(N);

		System.out.println(sb.reverse());

		br.close();
	}

}