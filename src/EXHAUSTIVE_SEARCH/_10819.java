package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// TODO 꼭 다시 봐야함 완전탐색 기법 (recursion)
// ref : https://sundries-in-myidea.tistory.com/5
public class _10819 {
	static int max = 0;
	static void perm(int[] a,int depth,int n) {
		if(depth==n) {
			sum(a,n);
			return;
		}
		for(int i=depth;i<n;i++) {
			swap(a,i,depth);
			perm(a, depth+1, n);
			swap(a,i,depth);
		}
	}
	
	private static void swap(int[] a, int depth, int n) {
		int temp = a[depth];
		a[depth] = a[n];
		a[n] = temp;
		
	}

	private static void sum(int[] a, int k) {
		int sum = 0;
		for(int i=0;i<k-1;i++) {
			sum += Math.abs(a[i]-a[i+1]);
		}
		if(max<sum)
			max = sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 3<= <=8
		int[] arr = new int[N];
		String[] st = br.readLine().split(" ");
		
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st[i]);
		
		perm(arr, 0, N);
		System.out.println(max);
		br.close();
	}
}
