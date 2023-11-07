package greedy;

import java.io.*;
import java.util.*;

/*
그리디 예제4. 1이 될 때까지
- 시간 제한: 1초
- 2<=N<=100,000 / 2<=K<=100,000
<접근>
O(n)으로 풀어야 한다.
`최대한 많이 나누는 것`이 키포인트이다.
 */
public class Ex4_FinalToOne {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int count = 0;
		while (n > 1) {
			if (n % k == 0) {
				n /= k;
			} else {
				n--;
			}
			count++;
		}
		System.out.println(count);
	}
}
