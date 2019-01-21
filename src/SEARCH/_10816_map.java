package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _10816_map {
	// Map을 사용 . 문제는 이분 탐색으로 풀어야 하지만 Map을 이용하여 품
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(tmp[i]);
			if(map.containsKey(key)) {
				map.replace(key, map.get(key)+1);
				continue;
			}
			map.put(key, 1);
		}
			
		int M = Integer.parseInt(br.readLine());
		int[] check = new int[M];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			check[i] = Integer.parseInt(tmp[i]);

		for (int i = 0; i < M; i++) {
			int target = check[i];
			
			if(map.containsKey(target)) {
				System.out.print(map.get(target)+" ");
			}else {
				System.out.print(0+" ");
			}
			
		}

		br.close();
	}

}
