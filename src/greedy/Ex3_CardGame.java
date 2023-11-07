package greedy;

import java.io.*;
import java.util.*;

/*
그리디 예제3. 숫자 카드 게임
- 시간 제한 1초
- 1 <= x, y <= 100
<접근>
- 이중 for문을 이용하면 입력이 최대 10,000 이므로 1초 내로 실행 가능하다.
- Java의 Math.min(), Math.max() 함수는 O(1)의 시간 복잡도를 가지므로 영향이 미미하다.
 */
public class Ex3_CardGame {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] cards = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				cards[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < y; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < x; j++) {
				min = Math.min(min, cards[i][j]);
			}
			max = Math.max(max, min);
		}

		System.out.println(max);
	}
}
