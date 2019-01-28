package GREEDY;

import java.util.Scanner;

public class _10610 {
	// 숫자가 30으로 나누어 떨어지는 조건을 알아야한다. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		sc.close();

		int[] arr = new int[10]; // 자릿수가 10^5이기 때문에 0~9까지의 숫자의 빈도수를 메모해준다.
		int sum = 0; // 입력받은 문자들의 합을 저장
		for (int i = 0; i < str.length(); i++) {
			int tNum = Integer.parseInt(str.charAt(i) + "");
			arr[tNum] += 1;
			sum += tNum;
		}

		// 문자열에 0이 포함되있지않으면 30으로 나눌수 없고, 합은 3으로 나누어 떨어져야한다.
		if (!str.contains("0") || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}

		// sb.append(i) 대신 System.out.print()로 하나씩 출력하려 했지만 출력이 너무 많기 때문에
		// StringBuilder에 하나씩 저장하여 한번에 출력하기로 했다.
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
