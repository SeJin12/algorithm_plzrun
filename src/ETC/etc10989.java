package ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class etc10989 {
	// sort�� �־��� ���⵵�� O(N^2)�� �ð��� �ɸ� �� �ֱ�? ������ �ð��ʰ�
	// �޸������̼��� Ȱ���Ͽ� �ð��� ���δ�.
	// System.out.println�� ���� �ð��ʰ��� �ɸ��� ������ BufferedWriter�� ����.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int[] cache = new int[10001];

		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp = Integer.parseInt(br.readLine().trim());
			cache[temp] += 1;
		}

		for (int i = 1; i <= 10000; ++i) {
			if (cache[i] > 0)
				for (int j = 0; j < cache[i]; j++)
					bw.write(i + "\n");
		}
		bw.close();
		br.close();
	}

}