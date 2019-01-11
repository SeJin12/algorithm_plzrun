package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			s = br.readLine().split(" ");
			if(s[0].equals("push")) {
				list.add(Integer.parseInt(s[1]));
			}
			if(s[0].equals("pop")) {
				if(list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.remove(0));
			}
			if(s[0].equals("size")) {
				System.out.println(list.size());
			}
			if(s[0].equals("empty")) {
				if(list.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			if(s[0].equals("front")) {
				if(list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.get(0));
			}
			if(s[0].equals("back")) {
				if(list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.get(list.size()-1));
			}
			
		}

		br.close();
	}
	
}
