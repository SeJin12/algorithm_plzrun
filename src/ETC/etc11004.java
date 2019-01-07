package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class etc11004 {
	
	//TODO N의 최대값은 5_000_000 이고, Arrays.sort의 최악의 시간 복잡도는 N^2  그렇다면 시간초과가 되지않고 문제가 정답이 되는 이유는 뭔가? 
	// 퀵소트로 해보기
	// https://han.gl/gpSXS 분석
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // <= 100_0000
		int k = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		
		Arrays.sort(arr);
		
		System.out.println(arr[k-1]);
		
		
		br.close();
	}
}
