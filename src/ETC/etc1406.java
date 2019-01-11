package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class etc1406 {
	// ���� ArrayList�� ����ϸ� �߰�P ����B �Ҷ����� ��� ���Ұ� �Ű����� �ϱ� ������
	// �ð����⵵�� O(N)�̰� ��ɾ�ݺ� N ������ �뷫 ��ü���⵵�� N^2 �� �ȴ�.
	// ���� 2���� ����Ͽ� �ð����⵵�� ���� ����̴�.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split("");
		int n = Integer.parseInt(br.readLine());

		Stack<String> leftStack = new Stack<>(), rightStack = new Stack<>();
		for (int i = 0; i < str.length; i++)
			leftStack.push(str[i]);

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");

			if (arr[0].equals("L")) {
				if (!leftStack.isEmpty()) {
					rightStack.push(leftStack.pop());
				}
			} else if (arr[0].equals("D")) {
				if (!rightStack.isEmpty())
					leftStack.push(rightStack.pop());
			} else if (arr[0].equals("B")) {
				if (!leftStack.isEmpty())
					leftStack.pop();
			} else if (arr[0].equals("P")) {
				leftStack.push(arr[1]);
			}
		}

		while (!leftStack.isEmpty())
			rightStack.push(leftStack.pop());

		while (!rightStack.isEmpty())
			System.out.print(rightStack.pop());

		br.close();
	}

}
