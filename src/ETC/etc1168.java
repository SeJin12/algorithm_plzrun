package ETC;

import java.util.ArrayList;
import java.util.Scanner;

public class etc1168 {
	// TODO 분석이 필요함. _1158(조세푸스1)보다 시간복잡도를 줄인 방법이다
	// 조세푸스1 입력범위: 5000   조세푸스2 입력범위 10_0000 
	// 나는 리스트에서 삭제가 될때마다 뒤의 인덱스를 한칸씩 땡겨야 하기 때문에
	// 시간을 많이 소비한다고 생각했지만, 1168 답안도 리스트를 제거하는 방식을 썼다
	// 메모리 부분이나 다른 시간적인 부분을 단축한게 보이지만. 시간복잡도 상으로 크게 다를바 없어보인다.
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