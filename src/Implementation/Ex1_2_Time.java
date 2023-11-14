package Implementation;

import java.io.*;
import java.util.*;

/*
시각
- 시간 제한: 2초
- 메모리 제한: 128MB
<접근 방법>
- 0 <= n <= 23 이므로 O(N^3)으로 풀어도 할 수 있다!
- 삼중 포문으로 해결 <- 완전 탐색(가능한 경우를 모두 검사한다)
 */

public class Ex1_2_Time {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count = 0;

		for (int hour = 0; hour <= n; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				for (int seconds = 0; seconds < 60; seconds++) {
					if (isContainThree(hour, minute, seconds)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	private static boolean isContainThree(int hour, int minute, int seconds) {
		return (String.valueOf(hour) + String.valueOf(minute) + String.valueOf(seconds)).contains("3");
	}
}
