package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2143 {
	// ½ÇÆÐ..
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		
		String st[] = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			A[i] = Integer.parseInt(st[i]);
		
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = br.readLine().split(" ");
		for(int i=0;i<m;i++)
			B[i] = Integer.parseInt(st[i]);
		
		ArrayList<Integer> AA = new ArrayList<>();
		ArrayList<Integer> BB = new ArrayList<>();
		for(int i=0;i<n;i++) {
			search(A, AA, n, i, 0);
		}
		for(int i=0;i<m;i++) {
			search(B, BB, m, i, 0);
		}
		Collections.sort(AA);
		Collections.sort(BB);
		long count = 0;
		int left = 0, right = m-1;
		while(left<n && right>=0) {
			int tmpA = AA.get(left);
			int tmpB = BB.get(right);
			if(tmpA+tmpB == T) {
				int cA = 0;
				for(int i=left;i<n;i++) {
					if(tmpA==AA.get(i)) {
						left++;
						cA++;
					}						
					else
						break;
				}
				int cB = 0;
				for(int i=right;i>=0;i--) {
					if(tmpB==BB.get(i)) {
						right--;
						cB++;
					}					
					else
						break;
				}
				count += cA * cB;
				left++;
			}else if(tmpA+tmpB < T) {
				left++;
			}else if(tmpA+tmpB > T) {
				right--;
			}
		}
		System.out.println(count);
		
		br.close();
	}
	
	static void search(int[] arr,ArrayList<Integer> list,int size,int idx,int sum) {
		if(idx==size)
			return;
		list.add(sum+arr[idx]);
		for(int i=idx+1;i<size;i++) {
			search(arr, list, size, idx+1, sum+arr[idx]);
		}
	}
	
}
