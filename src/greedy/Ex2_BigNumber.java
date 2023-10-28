package greedy;

import java.io.*;
import java.util.*;

public class Ex2_BigNumber {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arrN = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arrN; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		list.sort(Comparator.reverseOrder());

		int result = calculateBigNumber(list, count, limit);

		System.out.println(result);
	}

	private static int calculateBigNumber(List<Integer> list, int count, int limit) {
		int result = 0;

		while (count > 0) {
			for (int i = 0; i < limit; i++) {
				if (count == 0) {
					break;
				}
				result += list.get(0);
				count--;
			}
			if(count == 0) break;
			result += list.get(1);
			count--;
		}
		return result;
	}
}
