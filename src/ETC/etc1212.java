package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class etc1212 {
	 // 계속 컴파일 에러 난 이유는 ?  입력이 0이거나 첫째자리 예외를 해주지않아서? 인 것 같다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		switch (num.charAt(0)) {
		case '0':
			sb.append("0");
			break;
		case '1':
			sb.append("1");
			break;
		case '2':
			sb.append("10");
			break;
		case '3':
			sb.append("11");
			break;
		case '4':
			sb.append("100");
			break;
		case '5':
			sb.append("101");
			break;
		case '6':
			sb.append("110");
			break;
		case '7':
			sb.append("111");
			break;
		}
		
		for(int i=1;i<num.length();i++) {
			sb.append(invert(num.charAt(i)));
		}
			
		
		System.out.println(sb);

		br.close();
	}
	
	static String invert(char num) {
		String ret = "";
		if(num=='0') ret = "000";
		else if(num=='1') ret = "001";
		else if(num=='2') ret = "010";
		else if(num=='3') ret = "011";
		else if(num=='4') ret = "100";
		else if(num=='5') ret = "101";
		else if(num=='6') ret = "110";
		else if(num=='7') ret = "111";
		return ret;
	}

}