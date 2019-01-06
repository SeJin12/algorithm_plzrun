package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class etc10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		Member[] arr = new Member[n];

		String[] s;
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			arr[i] = new Member(i, Integer.parseInt(s[0]), s[1]);
		}

		Arrays.sort(arr, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age == o2.age)
					return Integer.compare(o1.regi, o2.regi);
				return Integer.compare(o1.age, o2.age);
			}
		});

		for (Member m : arr)
			System.out.println(m.age + " " + m.name);

		br.close();
	}
}

class Member {
	int regi;
	int age;
	String name;

	public Member(int regi, int age, String name) {
		this.regi = regi;
		this.age = age;
		this.name = name;
	}
}