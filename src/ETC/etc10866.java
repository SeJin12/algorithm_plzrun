package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class etc10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> deque = new ArrayList<>();
		int size = 0;

		int N = Integer.parseInt(br.readLine());
		String[] s;
		for (int n = 0; n < N; n++) {
			s = br.readLine().split(" ");
			if (s[0].equals("push_front")) {
				deque.add(0, Integer.parseInt(s[1]));
				size++;
			}
			if (s[0].equals("push_back")) {
				deque.add(size++, Integer.parseInt(s[1]));
			}
			if (s[0].equals("pop_front")) {
				if (deque.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(deque.remove(0));
					size--;
				}
			}
			if (s[0].equals("pop_back")) {
				if (deque.isEmpty())
					System.out.println(-1);
				else {
					System.out.println(deque.remove(size - 1));
					size--;
				}
			}
			if (s[0].equals("size")) {
				System.out.println(size);
			}
			if (s[0].equals("empty")) {
				if (deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			if (s[0].equals("front")) {
				if (deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.get(0));
			}
			if (s[0].equals("back")) {
				if (deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.get(size - 1));
			}
		}

		br.close();
	}
}
