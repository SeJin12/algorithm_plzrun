package ETC;

import java.util.Scanner;

public class etc10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ab = sc.next() + sc.next();
		String cd = sc.next() + sc.next();
		long ret = Long.parseLong(ab) + Long.parseLong(cd);

		System.out.println(ret);
		sc.close();
	}
}
