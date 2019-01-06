package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc2751 {
	// sort performance : Arrays.sort > Collections.sort
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());// <= 1_000_000
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++)
			arr.add(Integer.parseInt(br.readLine()));

		arr.sort(null);
		
		for(int a:arr)
			System.out.println(a);
		
		
		br.close();
	}
}
