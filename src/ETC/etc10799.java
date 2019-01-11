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
			// ���� ��ȣ�� ���ÿ� �ִ´�.
			if (input[i] == '(')
				st.push(input[i]);
			else { // �ݴ� ��ȣ�� �� ��ȣ�� �������ΰ�, ������ ������ �˾ƺ���.
				st.pop();
				if (input[i - 1] == '(') // ���������
					result += st.size(); // �߸� ���� �߰�
				else // �������� ���̸�
					result++; // ������ �߷��� ���� �߰�
			}

		}
		System.out.println(result);

		br.close();
	}

}
