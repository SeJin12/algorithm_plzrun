package GREEDY;

import java.util.Arrays;
import java.util.Scanner;

public class _1744 {
	// �ٸ� Ǯ�� : https://mygumi.tistory.com/220
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		sc.close();

		int ret = 0;

		for (int i = 0; i < N; i++) {
			int checkVal = arr[i];
			if (checkVal < 0) { // ���� ������ ��
				if (i + 1 < N) { // ���� ���� ���� ���
					if (arr[i + 1] < 0) { // �������� ������� ����*������ ���Ͽ� �ִ밪 ����
						ret += checkVal * arr[i + 1];
						i++;
					} else if (arr[i + 1] == 0) { // �������� 0�̶�� checkVal*0=0 �̱⿡ ret�� �� �����൵��
						i++;
					} else if (arr[i + 1] > 0) { // ����*����� �� �ʿ䰡 ���⿡, �׳� ������ �����ش�.
						ret += checkVal;
					}
				} else { // ���� ���� ���� ���
					ret += checkVal;
				}
			} else if (checkVal == 0) { // 0�� ��� �ƹ��� �۾��� �ʿ���⿡ �Ѿ�ش�.
				continue;
			} else if (checkVal == 1) { // 1�� ���, ������ 1�� �����ִ°� �̵��̴�.
				ret += checkVal;
			} else if (checkVal > 1) { // ���� ����� ���
				for (int j = i; j < N; j++) { // �� �� �迭�� ��� 2�̻��� ����̱� ������ �ѹ��� ó�����ְ� break;
					if ((N - i) % 2 == 0) { // ���� 2�̻��� ��� �迭�� ���̰� ¦���� ��� ��� ������ �ֱ� ������ �����ش�.
						ret += arr[j] * arr[j + 1];
						j++;
					} else { // 2�̻� ��� �迭�� ���̰� Ȧ���� ���
						if (j == i) { // ���� ó���� ����� ȥ�� �����ش�.
							ret += arr[j];
						} else { // �������� ��� �����ش�.
							ret += arr[j] * arr[j + 1];
							j++;
						}
					}
				}
				break;
			}
		}

		System.out.println(ret);

	}
}
