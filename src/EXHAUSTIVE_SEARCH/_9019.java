package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// ref : https://virusworld.tistory.com/83
// ³Ê¹« ±ò²ûÇÑ Ç®ÀÌ´Ù ¤§¤§;
public class _9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] st = br.readLine().split(" ");
			int A = Integer.parseInt(st[0]);
			int B = Integer.parseInt(st[1]);
			boolean[] visited = new boolean[10005];
			Queue<Register> q = new LinkedList<>();
			q.offer(new Register(A, ""));
			visited[A] = true;
			
			while(!q.isEmpty()) {
				Register r = q.poll();
				if(r.num==B) {
					System.out.println(r.command);
					break;
				}
				
				if(!visited[D(r.num)]) {
					int num = D(r.num);
					visited[num] = true;
					q.offer(new Register(num, r.command+"D"));
				}
				if(!visited[S(r.num)]) {
					int num = S(r.num);
					visited[num] = true;
					q.offer(new Register(num, r.command+"S"));
				}
				if(!visited[L(r.num)]) {
					int num = L(r.num);
					visited[num] = true;
					q.offer(new Register(num, r.command+"L"));
				}
				if(!visited[R(r.num)]) {
					int num = R(r.num);
					visited[num] = true;
					q.offer(new Register(num, r.command+"R"));
				}
				
			}
		}

		br.close();
	}

	static int D(int n) {
		return (n*2) % 10000;
	}

	static int S(int n) {
		return (n==0) ? 9999 : n-1;
	}

	static int L(int n) {
		return (n%1000) * 10 + n / 1000;
	}

	static int R(int n) {
		return (n%10)*1000 + (n/10);
	}
	
	static class Register {
		int num;
		String command;
		Register(int num, String command) {
			this.num = num;
			this.command = command;
		}
		
	}

}
