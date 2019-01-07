package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class etc11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim()); // <= 100_0000

		BigInteger[] inputs = new BigInteger[n];

		for (int i = 0; i < n; i++)
			inputs[i] = new BigInteger(br.readLine());

		Arrays.sort(inputs); // Sort

		BigInteger preNumber = inputs[0]; // 최초의 이전 값을 저장할 변수
		int numberCounts = 0; // 반복 횟수 저장
		BigInteger mostNumber = BigInteger.ZERO; // 가장 많이 등장한 아이템 값을 저장
		int mostNumberCounts = 0; // 가장 많이 등장한 아이템 값의 횟수

		for (int i = 0; i < n; i++) {
			if (!preNumber.equals(inputs[i])) { // 이전 아이템 값과 같지 않다면
				if (numberCounts > mostNumberCounts) {
					mostNumberCounts = numberCounts;
					mostNumber = preNumber;
				}
				numberCounts = 1; // 아이템의 반복 횟수 초기화
				preNumber = inputs[i]; // 이전 값을 현재 값으로 설정
			} else {
				numberCounts++;
			}
			if (numberCounts > mostNumberCounts) {
				mostNumberCounts = numberCounts;
				mostNumber = preNumber;
			}
		}
		System.out.println(mostNumber);

		br.close();
	}

}