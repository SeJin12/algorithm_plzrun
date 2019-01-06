package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class etc10825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());

		Studentkem[] arr = new Studentkem[n];
		String[] tmp;

		for (int i = 0; i < n; ++i) {
			tmp = br.readLine().split(" ");
			arr[i] = new Studentkem(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]),
					Integer.parseInt(tmp[3]));
		}

		Arrays.sort(arr, new Comparator<Studentkem>() {

			@Override
			public int compare(Studentkem o1, Studentkem o2) {
//				´õ ±ò²ûÇÑ ÄÚµå
//				if(o1.kor==o2.kor) {
//					if(o1.eng==o2.eng) {
//						if(o1.math==o2.math)
//							return o1.name.compareTo(o2.name);
//						return Integer.compare(o2.math, o1.math);
//					}
//					return Integer.compare(o1.eng, o2.eng);
//				}
				if(o1.kor==o2.kor&&o1.eng==o2.eng&&o1.math==o2.math)
					return o1.name.compareTo(o2.name);
				if(o1.kor==o2.kor&&o1.eng==o2.eng)
					return Integer.compare(o2.math, o1.math);
				if(o1.kor==o2.kor)
					return Integer.compare(o1.eng, o2.eng);
				return Integer.compare(o2.kor, o1.kor);
			}
		});
		
		for(Studentkem s:arr)
			System.out.println(s.name);

		br.close();
	}

}

class Studentkem {
	String name;
	int kor, eng, math;

	public Studentkem(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

}
