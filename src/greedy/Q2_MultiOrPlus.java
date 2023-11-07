package greedy;

import java.io.*;
import java.util.*;

/*
기출문제 그리디2. 곱하기 혹은 더하기
- 시간 제한: 1초
- 1<=n<=20
<접근>
아무 로직으로 풀어도 시간 초과는 안 걸릴 것 같다.
숫자가 0이 아닐 경우 곱셈을 하는 것이 가장 큰 수를 만들 수 있다.
 */
public class Q2_MultiOrPlus {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numbers = br.readLine().split("");


		int result = 0;

		int index = 0;
		while (index < numbers.length) {
			int number = Integer.parseInt(numbers[index]);
			// 0인 경우 덧셈을 하든 아무것도 하지 않든 둘 중 하나를 한다.
			if (number == 0) {
				index++;
				continue;
			}
			// 처음 수가 0부터 시작하므로 이후 숫자는 덧셈을 해줘야 한다.
			if (result == 0) {
				result += number;
				index++;
				continue;
			}
			result *= number;
			index++;
		}

		System.out.println(result);
	}
}
