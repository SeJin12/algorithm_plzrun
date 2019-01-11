package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class etc1406 {
	// 기존 ArrayList를 사용하면 추가P 삭제B 할때마다 모든 원소가 옮겨져야 하기 때문에
	// 시간복잡도가 O(N)이고 명령어반복 N 때문에 대략 전체복잡도가 N^2 이 된다.
	// 스택 2개를 사용하여 시간복잡도를 줄인 방법이다.
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
