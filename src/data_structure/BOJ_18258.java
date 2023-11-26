package data_structure;

import java.io.*;
import java.util.*;

/*
큐2
- 시간 제한: 1초
- 메모리 제한: 512MB
<접근 방법>
덱을 사용하면 금방 해결하지만 정수를 저장하는 덱을 구현해서 다시 풀어야 한다.
 */
public class BOJ_18258 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Deque dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					int x = Integer.parseInt(st.nextToken());
					dq.add(x);
					break;
				case "front":
					if (dq.isEmpty()) {
						sb.append(-1 + "\n");
						continue;
					}
					sb.append(dq.peekFirst() + "\n");
					break;
				case "back":
					if(dq.isEmpty()) {
						sb.append(-1 + "\n");
						continue;
					}
					sb.append(dq.peekLast() + "\n");
					break;
				case "size":
					sb.append(dq.size() + "\n");
					break;
				case "empty":
					if(dq.isEmpty()) {
						sb.append(1 + "\n");
					}else {
						sb.append(0 + "\n");
					}
					break;
				case "pop":
					if(dq.isEmpty()) {
						sb.append(-1 + "\n");
						continue;
					}
					sb.append(dq.poll() + "\n");
			}
		}
		System.out.println(sb);
	}
}
