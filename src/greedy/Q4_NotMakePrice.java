package greedy;

import java.io.*;
import java.util.*;

/*
만들 수 없는 금액
- 시간 제한: 1초
- 메모리 제한 128MB
- 조합으로 접근하려다가 아닌 것 같아서 답안 참고함
<접근 방법>
point : 1부터 차례대로 특정한 금액(target - 1)을 만들 수 있는지 확인한다.

input: 1 1 2 3 9
0) [1]로 1을 만들 수 있으므로 target = 1(target) + 1(coin)을 한다.
1) [1]로 1(target-1)를 만들 수 있으므로 target = 2(target) + 1(coin)을 한다.
2) [2]로 2(target-1)을 만들 수 있으므로 target = 3(target) + 2(coin)을 한다.
3) [1, 2]로 3, [1, 1, 2]로 4(target-1)를 만들 수 있으므로 target = 5(target) + 3(coin)을 한다.
4) [1, 1, 3]로 5, [1, 2, 3]로 6, [1, 1, 2, 3]로 7(target-1)을 만들 수 있다.
5) 8(target) < 9(coin) 이면 target을 만들 수 없으므로 끝난다.
 */
public class Q4_NotMakePrice {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] coins = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			coins[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coins);

		int target = 1;
		for(int i=0; i<n; i++) {
			if(target < coins[i]) {
				break;
			}
			target += coins[i];
		}

		System.out.println(target);
	}
}
