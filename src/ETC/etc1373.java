package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		if (input.length() % 3 == 1)
			input = "00" + input;
		if (input.length() % 3 == 2)
			input = "0" + input;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i += 3) {
			int ret = 0;
			ret += Integer.parseInt((input.charAt(i) - '0') + "") * 4;
			ret += Integer.parseInt((input.charAt(i + 1) - '0') + "") * 2;
			ret += Integer.parseInt((input.charAt(i + 2) - '0') + "");
			sb.append(ret);
		}

		System.out.println(sb);

		br.close();
	}

}