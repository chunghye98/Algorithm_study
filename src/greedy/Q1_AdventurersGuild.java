package greedy;

import java.io.*;
import java.util.*;

/*
기출문제 그리디1. 모험가 길드
- 시간 제한: 1초
- 1<=n<=100,000
<접근>
O(n)으로 풀어야 한다.
`가장 적은 멤버 수로 그룹을 만들기`가 키포인트 <- 그룹이 최대가 된다.
모험가를 오름차순으로 정렬해서 누적 멤버수가 공포도보다 커질 때 count++ 한다.
 */
public class Q1_AdventurersGuild {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Integer> adventurers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adventurers.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(adventurers);

		int member = 0;
		int result = 0;

		for (int i = 0; i < n; i++) {
			member++;
			if(member >= adventurers.get(i)) {
				member = 0;
				result++;
			}
		}
		System.out.println(result);
	}
}
