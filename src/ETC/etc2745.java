package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc2745 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		String N = tmp[0];
		int B = Integer.parseInt(tmp[1]); 

		cal(N, B);

		br.close();
	}

	static void cal(String N, int B) {
		int ret = 0;
		int mul = 1;
		// 틀렸던 이유 : mul = 1로 할거면 문자열의 맨뒤 부터 해야하는데 앞에서부터 했다.
		// 예시입력이 ZZZZZ 라서 바뀐지 모르고 있었음.
		for (int i = N.length()-1; i >= 0; i--) { 
			char c = N.charAt(i);
			if ('0' <= c && c <= '9') {
				ret += Integer.valueOf(c - '0') * mul;
			} else {
				ret += (Integer.valueOf(c - 'A') + 10) * mul;
			}
			mul *= B;
		}

		System.out.println(ret);
	}

}