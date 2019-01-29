package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class _1931 {

	static int N;
	static ArrayList<Meeting> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; ++i) {
			String[] tmp = br.readLine().split(" ");
			list.add(new Meeting(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
		}

		list.sort(new Comparator<Meeting>() {
			@Override
			public int compare(Meeting a, Meeting b) {
				if (a.et == b.et)
					return Integer.compare(a.st, b.st);
				return Integer.compare(a.et, b.et);
			}
		});

		int cntMeeting = 1;
		int myTime = list.get(0).et;

		for (int i = 1; i < N; i++) {
			Meeting m = list.get(i);
			if (m.st >= myTime) {
				myTime = m.et;
				cntMeeting += 1;
			}
		}

		System.out.println(cntMeeting);

		br.close();
	}

	static class Meeting {
		int st, et; // startTime, endTime

		Meeting(int st, int et) {
			this.st = st;
			this.et = et;
		}
	}

}
