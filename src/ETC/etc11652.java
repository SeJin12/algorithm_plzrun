package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class etc11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim()); // <= 100_0000

		BigInteger[] inputs = new BigInteger[n];

		for (int i = 0; i < n; i++)
			inputs[i] = new BigInteger(br.readLine());

		Arrays.sort(inputs); // Sort

		BigInteger preNumber = inputs[0]; // ������ ���� ���� ������ ����
		int numberCounts = 0; // �ݺ� Ƚ�� ����
		BigInteger mostNumber = BigInteger.ZERO; // ���� ���� ������ ������ ���� ����
		int mostNumberCounts = 0; // ���� ���� ������ ������ ���� Ƚ��

		for (int i = 0; i < n; i++) {
			if (!preNumber.equals(inputs[i])) { // ���� ������ ���� ���� �ʴٸ�
				if (numberCounts > mostNumberCounts) {
					mostNumberCounts = numberCounts;
					mostNumber = preNumber;
				}
				numberCounts = 1; // �������� �ݺ� Ƚ�� �ʱ�ȭ
				preNumber = inputs[i]; // ���� ���� ���� ������ ����
			} else {
				numberCounts++;
			}
			if (numberCounts > mostNumberCounts) {
				mostNumberCounts = numberCounts;
				mostNumber = preNumber;
			}
		}
		System.out.println(mostNumber);

		br.close();
	}

}