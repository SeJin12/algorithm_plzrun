package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class etc10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().trim().toCharArray();
		int result = 0;
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < input.length; i++) {
			// 여는 괄호면 스택에 넣는다.
			if (input[i] == '(')
				st.push(input[i]);
			else { // 닫는 괄호면 이 괄호가 레이저인가, 파이프 끝인지 알아본다.
				st.pop();
				if (input[i - 1] == '(') // 레이저라면
					result += st.size(); // 잘린 개수 추가
				else // 파이프의 끝이면
					result++; // 닫혀서 잘려진 개수 추가
			}

		}
		System.out.println(result);

		br.close();
	}

}
