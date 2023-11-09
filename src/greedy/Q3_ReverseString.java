package greedy;

import java.io.*;
import java.util.*;

/*
문자열 뒤집기
- 시간 제한: 2초
- 1<=str<=1,000,000
<접근 방법>
0과 1로 토큰화해서 더 적은 토큰의 수를 구한다.
 */

public class Q3_ReverseString {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st0 = new StringTokenizer(str, "0");
		StringTokenizer st1 = new StringTokenizer(str, "1");

		System.out.println(Math.min(st0.countTokens(), st1.countTokens()));
	}
}
