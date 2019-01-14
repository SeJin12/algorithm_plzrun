package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc11005 {
	/* ���� ��ȯ �޼���
	 * 10���� ���� N > 11���� �̻���ʹ� ���ĺ����� ǥ��������, �ҹ��ڷ� ǥ���ȴ�.
	 	String bin = Integer.toBinaryString(N); //2���� 
		String oct = Integer.toOctalString(N); //8����
		String hex = Integer.toHexString(N); //16����
		System.out.println("2���� -> 10���� : " + Integer.valueOf(bin, 2)); 
		System.out.println("8���� -> 10���� : " + Integer.valueOf(oct, 8)); 
		System.out.println("16����-> 10���� : " + Integer.valueOf(hex, 16)); // �ٽ� ���������� �ٲ�	
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int B = Integer.parseInt(tmp[1]); // 2<= B <= 36
		// 36�� ������ 0~9���� 10��, ���ĺ� 26������ �� 36��

		cal(N, B);

		br.close();
	}

	static void cal(int num, int div) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			if (num == 0)
				break;
			int x = num % div;
			num /= div;
			if (0 <= x && x <= 9)
				sb.append(x);
			else {
				x -= 10;
				sb.append((char) ('A' + x));
			}
		}
		System.out.println(sb.reverse());
	}

}