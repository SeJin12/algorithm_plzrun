package GREEDY;

import java.util.Scanner;

public class _1783 {

	final static int[] dy = { 2, -2, 1, -1 };
	final static int[] dx = { 1, 1, 2, 2 };
	// ���� �� : ���� �ؼ��� ���ؾ� �ϰ�, �ݷʸ� �� ã�� �� �˾ƾ� �Ѵ�.
	// �̵� Ƚ�� == �湮 ĭ�� �� ������ �򰥸���
	// ��� �̵� ����� 1�� �̻� ����ϴ� ��찡 �̵� Ƚ�� 4�̻����� 4�ʰ����� �򰥸���.. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		int ret = 0;
		if(N==1) { // ���ΰ� 1�� ��� �̵��� ���ϱ� ������ ó�� ��ġ 1���� �湮
			ret = 1;
		}else if(N==2){ // ���ΰ� 2�� ��� ���������� 2���� ���� ��� �ۿ� ����.
			ret = Math.min(4, (M+1)/2); 
		}else { // ���ΰ� 3�̻��� ��� ��� ����� ���� ����������.( ��, ������ ũ�⿡ ���� �޶��� )
			if(M<7) {
				ret = Math.min(4, M);
			}else {
				ret= M-2; // ������ 4���� �̵� ��츦 ������ϱ� ������ ���η� 2ĭ�� 2���� �̵��ϰ�, �������� 1ĭ�� �̵��ؾ��Ѵ�.
			}
		}

		System.out.println(ret);

	}

}
