package Implementation;

import java.io.*;
import java.util.*;

/*
게임 개발
- 시간 제한: 1초
- 메모리 제한 128MB
- 1시간 내에 못 풀어서 답안을 본 후 다시 구현했다.
< 접근 방법 >
방향을 배열로 만들어서 사용한다.
direction을 왼쪽으로 회전 시킬 때 메서드를 따로 뺀다면 전역 변수를 사용한다.
방문 체크를 위한 배열을 만들어서 사용한다.
 */

public class Ex3_GameDevelop {

	static int direction;
	public static void main(String[] args) throws Exception {

		int[] dx = {0, 1, 0, -1}; // 북동남서
		int[] dy = {-1, 0, 1, 0};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 지도의 세로
		int m = Integer.parseInt(st.nextToken()); // 지도의 가로

		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken()); // 캐릭터의 y좌표
		int x = Integer.parseInt(st.nextToken()); // 캐릭터의 x좌표
		direction = Integer.parseInt(st.nextToken()); // 캐릭터의 방향

		String[][] map = new String[n][m]; // 지도
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().split(" ");
		}

		String[][] visit = new String[n][m]; // 방문 체크
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], "0");
		}

		visit[y][x] = "1";

		int turnCount = 0;
		int count = 1;

		while (true) {
			// 1. 왼쪽으로 회전
			turnLeft();
			int ny = y + dy[direction];
			int nx = x + dx[direction];

			// 2. 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
			if (map[ny][nx].equals("0") && visit[ny][nx].equals("0")) {
				visit[ny][nx] = "1";
				y = ny;
				x = nx;
				count++;
				turnCount = 0;
				continue;
			} else {
				turnCount++;
			}

			// 3. 네 방향 모두 갈 수 없는 경우
			if (turnCount == 4) {
				ny = y - dy[direction];
				nx = x - dx[direction];

				// 4. 뒤로 이동할 수 있는 경우 이동
				if (map[ny][nx].equals("0")) {
					y = ny;
					x = nx;
				}
				// 뒤로 이동할 수 없는 경우 종료
				else {
					break;
				}
				turnCount = 0;
			}
		}

		System.out.println(count);
	}

	private static void turnLeft() {
		if (direction == 0) {
			direction = 3;
		} else {
			direction--;
		}
	}
}
