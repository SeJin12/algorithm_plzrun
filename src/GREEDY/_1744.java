package GREEDY;

import java.util.Arrays;
import java.util.Scanner;

public class _1744 {
	// 다른 풀이 : https://mygumi.tistory.com/220
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		sc.close();

		int ret = 0;

		for (int i = 0; i < N; i++) {
			int checkVal = arr[i];
			if (checkVal < 0) { // 값이 음수일 때
				if (i + 1 < N) { // 다음 값이 있을 경우
					if (arr[i + 1] < 0) { // 다음값이 음수라면 음수*음수를 더하여 최대값 가능
						ret += checkVal * arr[i + 1];
						i++;
					} else if (arr[i + 1] == 0) { // 다음값이 0이라면 checkVal*0=0 이기에 ret에 안 더해줘도됨
						i++;
					} else if (arr[i + 1] > 0) { // 음수*양수를 할 필요가 없기에, 그냥 음수만 더해준다.
						ret += checkVal;
					}
				} else { // 다음 값이 없을 경우
					ret += checkVal;
				}
			} else if (checkVal == 0) { // 0일 경우 아무런 작업이 필요없기에 넘어가준다.
				continue;
			} else if (checkVal == 1) { // 1일 경우, 무조건 1만 더해주는게 이득이다.
				ret += checkVal;
			} else if (checkVal > 1) { // 값이 양수일 경우
				for (int j = i; j < N; j++) { // 그 뒤 배열은 모두 2이상의 양수이기 때문에 한번에 처리해주고 break;
					if ((N - i) % 2 == 0) { // 남은 2이상의 양수 배열의 길이가 짝수일 경우 모두 묶을수 있기 때문에 묶어준다.
						ret += arr[j] * arr[j + 1];
						j++;
					} else { // 2이상 양수 배열의 길이가 홀수일 경우
						if (j == i) { // 가장 처음의 양수는 혼자 더해준다.
							ret += arr[j];
						} else { // 나머지는 묶어서 더해준다.
							ret += arr[j] * arr[j + 1];
							j++;
						}
					}
				}
				break;
			}
		}

		System.out.println(ret);

	}
}
