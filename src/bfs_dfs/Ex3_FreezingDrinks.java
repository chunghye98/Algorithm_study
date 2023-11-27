package bfs_dfs;

import java.io.*;
import java.util.*;

/*
음료수 얼려먹기
- 시간 제한: 1초
- 메모리 제한: 128MB
< 접근 방법 >
얼음을 얼릴 수 있는 공간이 상, 하, 좌, 우로 연결되어 있다고 표현할 수 있으므로 그래프 형태로 나타낼 수 있다.
DFS를 사용하여 더 이상 탐색할 수 없을 때까지 탐색하고, 빠져 나오는 경우를 하나의 아이스크림이 만들어진다고 생각하면 편하다.
이를 얼음 틀의 모든 인덱스를 탐색하여 적용하면 만들어지는 아이스크림의 개수를 알 수 있다.
 */
public class Ex3_FreezingDrinks {

	private static int n; // 세로 길이
	private static int m; // 가로 길이
	private static int[][] frame; // 얼음 틀

	public static void main(String[] args) throws Exception {
		// 1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		frame = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");

			for (int j = 0; j < m; j++) {
				frame[i][j] = Integer.parseInt(temp[j]);
			}
		}

		// 2. 얼음 틀 탐색
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 3. DFS로 탐색
				if(dfs(i, j)) {
					// 상하좌우 탐색한 뒤 더 이상 0인 값이 없다면 빠져나온다. 뭉텅이 하나를 센다.
					result++;
				}
			}
		}

		// 4. 만들어진 아이스크림 개수 출력
		System.out.println(result);
	}

	private static boolean dfs(int y, int x) {
		// 범위를 벗어나는 경우 종료
		if (isInBoundary(y, x)) {
			return false;
		}

		// 현재 노드를 아직 방문하지 않았다면
		if (frame[y][x] == 0) {
			//해당 노드 방문 처리
			frame[y][x] = 1;

			// 상하좌우 방문
			dfs(y - 1, x);
			dfs(y + 1, x);
			dfs(y, x - 1);
			dfs(y, x + 1);
			return true;
		}
		return false;
	}

	private static boolean isInBoundary(int y, int x) {
		return y < 0 || y >= n || x < 0 || x >= m;
	}
}
