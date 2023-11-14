package Implementation;

import java.io.*;
import java.util.*;

/*
왕실의 나이트
- 시간 제한: 1초
- 메모리 제한 : 128MB
<접근 방법>
- 8 X 8 좌표 평면에서 이동할 수 있는 루트는 8개이므로 시간 제한은 넉넉하다.
- 나이트가 이동할 수 있는 8개의 루트에서 체스판의 경계를 넘어가면 count 하지 않는다.
 */

public class Ex2_NightOfKingdom {
	public static void main(String[] args) throws Exception {
		int[] stepX = {-1, 1, 2, 2, 1, -1, -2, -2}; // 북서에서 시계방향
		int[] stepY = {-2, -2, -1, 1, 2, 2, 1, -1};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");

		int x = input[0].charAt(0) - 'a';
		int y = Integer.parseInt(input[1]) - 1;

		int count = 0;

		for (int i = 0; i < 8; i++) {
			int nextX = x + stepX[i];
			int nextY = y + stepY[i];

			if (!checkBoundary(nextX, nextY)) {
				continue;
			}

			count++;
		}
		System.out.println(count);
	}

	private static boolean checkBoundary(int nextX, int nextY) {
		if (nextX >= 8 || nextY >= 8 || nextX < 0 || nextY < 0) {
			return false;
		}
		return true;
	}
}
