package ETC;

import java.util.ArrayList;
import java.util.Scanner;

public class etc1168 {
	// TODO �м��� �ʿ���. _1158(����Ǫ��1)���� �ð����⵵�� ���� ����̴�
	// ����Ǫ��1 �Է¹���: 5000   ����Ǫ��2 �Է¹��� 10_0000 
	// ���� ����Ʈ���� ������ �ɶ����� ���� �ε����� ��ĭ�� ���ܾ� �ϱ� ������
	// �ð��� ���� �Һ��Ѵٰ� ����������, 1168 ��ȵ� ����Ʈ�� �����ϴ� ����� ���
	// �޸� �κ��̳� �ٸ� �ð����� �κ��� �����Ѱ� ��������. �ð����⵵ ������ ũ�� �ٸ��� ����δ�.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		
		ArrayList<Integer> circle = new ArrayList<>();
		for(int i=1;i<=N;i++)
			circle.add(i);
		
		int kill = 0;
		System.out.print("<");
		while(true) {
			kill = (kill+M-1)%circle.size();
			System.out.print(circle.remove(kill));
			if(circle.isEmpty()) {
				System.out.println(">");
				break;
			}else {
				System.out.print(", ");
			}
		}

		sc.close();
	}

}