package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://mygumi.tistory.com/228
public class _2251 {
	static final int RANGE = 201; // ������ 200 ������ �ڿ���
	static int a, b, c;
	static boolean[][] visit = new boolean[RANGE][RANGE];
	static boolean[] ans = new boolean[RANGE];

	static void dfs(int ca, int cb, int cc) {
		if (visit[ca][cb]) // �湮�� ���̶�� ���� (����ȭ)
			return;
		if (ca == 0) // ca�� 0�̶�� cc�� ans �迭�� ����
			ans[cc] = true;
		visit[ca][cb] = true; // �湮�ߴٸ� true�� üũ

		// a -> b
		if (ca + cb > b) // ���� B�� �ѿ뷮�� a,b�� ����ִ� �纸�� �۴ٸ�?
			dfs((ca + cb) - b, b, cc); // a->b == b�� �� ä��� �۾�
		else // a,b�� ���� ���� B�� �ѿ뷮���� �۴ٸ�?
			dfs(0, ca + cb, cc);

		// b -> a
		if (cb + ca > a)
			dfs(a, (cb + ca) - a, cc);
		else
			dfs(cb + ca, 0, cc);

		// c -> a
		if (cc + ca > a)
			dfs(a, cb, (cc + ca) - a);
		else
			dfs(cc + ca, cb, 0);

		// c -> b
		if (cc + cb > b)
			dfs(ca, b, (cc + cb) - b);
		else
			dfs(ca, cc + cb, 0);

		// b -> c, a -> c
		// a + b = c �̱� ������, c�� ��ĥ ���� ����?
		// �ᱹ ���� �ʱⰪ���� C�� �ѿ뷮�̹Ƿ� ��� ���� ���Ѵ��ѵ� c�� ��ĥ���� ����.
		dfs(ca, 0, cb + cc); // b -> c
		dfs(0, cb, ca + cc); // a -> a
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		a = Integer.parseInt(st[0]);
		b = Integer.parseInt(st[1]);
		c = Integer.parseInt(st[2]);

		dfs(0, 0, c);

		// �Է°��� �ڿ����� ������� 0�� �����ؼ��� �ȵȴٴ� ������ �ߴ�.
		// ���� �ű�� C�� 0�� �ɼ��� �����Ƿ� for������ i=0���� �����ؾ��Ѵ�.
		for (int i = 0; i <= 200; i++)
			if (ans[i])
				System.out.print(i + " ");
		System.out.println();

		br.close();
	}

}
