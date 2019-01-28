package GREEDY;

import java.util.Scanner;

public class _10610 {
	// ���ڰ� 30���� ������ �������� ������ �˾ƾ��Ѵ�. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		sc.close();

		int[] arr = new int[10]; // �ڸ����� 10^5�̱� ������ 0~9������ ������ �󵵼��� �޸����ش�.
		int sum = 0; // �Է¹��� ���ڵ��� ���� ����
		for (int i = 0; i < str.length(); i++) {
			int tNum = Integer.parseInt(str.charAt(i) + "");
			arr[tNum] += 1;
			sum += tNum;
		}

		// ���ڿ��� 0�� ���Ե����������� 30���� ������ ����, ���� 3���� ������ ���������Ѵ�.
		if (!str.contains("0") || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}

		// sb.append(i) ��� System.out.print()�� �ϳ��� ����Ϸ� ������ ����� �ʹ� ���� ������
		// StringBuilder�� �ϳ��� �����Ͽ� �ѹ��� ����ϱ�� �ߴ�.
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			if (arr[i] > 0) {
				for (int j = 0; j < arr[i]; j++)
					sb.append(i);
			}
		}
		System.out.println(sb);
	}

}
