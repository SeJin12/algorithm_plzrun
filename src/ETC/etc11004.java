package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class etc11004 {
	
	//TODO N�� �ִ밪�� 5_000_000 �̰�, Arrays.sort�� �־��� �ð� ���⵵�� N^2  �׷��ٸ� �ð��ʰ��� �����ʰ� ������ ������ �Ǵ� ������ ����? 
	// ����Ʈ�� �غ���
	// https://han.gl/gpSXS �м�
	
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
