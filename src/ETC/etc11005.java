package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc11005 {
	/* 진법 변환 메서드
	 * 10진법 숫자 N > 11진수 이상부터는 알파벳으로 표현되지만, 소문자로 표현된다.
	 	String bin = Integer.toBinaryString(N); //2진수 
		String oct = Integer.toOctalString(N); //8진수
		String hex = Integer.toHexString(N); //16진수
		System.out.println("2진수 -> 10진수 : " + Integer.valueOf(bin, 2)); 
		System.out.println("8진수 -> 10진수 : " + Integer.valueOf(oct, 8)); 
		System.out.println("16진수-> 10진수 : " + Integer.valueOf(hex, 16)); // 다시 십진법으로 바꿈	
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int B = Integer.parseInt(tmp[1]); // 2<= B <= 36
		// 36인 이유는 0~9까지 10개, 알파벳 26개여서 총 36개

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