package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class etc9012 {
	
	// ���� : https://hongku.tistory.com/251
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // <= 10000
		
		int i;
		while(N-->0) {
			boolean isVPS = true;
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			char temp;
			for(i=0;i<input.length();i++) {
				temp = input.charAt(i);
				if(temp == '(') { // ���� ��ȣ�� ���ÿ� push�Ͽ� ��´�.
					stack.push(temp);
				}else if(temp==')') { // �ݴ� ��ȣ�� ���� ��� ������ �� ���� ���� ���� ��ȣ���� Ȯ��
					if(!stack.isEmpty()) { // ������ ������� �ʰ� �� �� ���� ���� ��ȣ��� ������ �� ������ pop�Ѵ�.
						stack.pop();
					}else {
						isVPS = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) isVPS = false;
			
			if(isVPS)
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}// while ��
		
		br.close();
	}
	
}
