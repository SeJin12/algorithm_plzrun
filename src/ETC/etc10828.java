package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc10828 {
	// problem url : https://han.gl/IIHUx
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // <= 10000
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int cur = -1;
		
		String[] tmp;
		for(int i=1;i<=N;++i) {
			tmp = br.readLine().split(" ");
			
			if(tmp[0].equals("push")) {
				list.add(Integer.parseInt(tmp[1]));
				cur += 1;
			}else if(tmp[0].equals("pop")) {
				if(cur==-1)
					System.out.println(-1);
				else
					System.out.println(list.remove(cur--));
			}else if(tmp[0].equals("size")) {
				System.out.println(cur+1);
			}else if(tmp[0].equals("empty")) {
				if(cur==-1)
					System.out.println(1);
				else
					System.out.println(0);
			}else if(tmp[0].equals("top")) {
				if(cur==-1)
					System.out.println(-1);
				else
					System.out.println(list.get(cur));
			}
			
		}
		
		br.close();
	}
	
}
