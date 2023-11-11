package Implementation;

import java.io.*;
import java.util.*;

public class Ex1_UpDownLeftRight {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		Person p = new Person(1, 1);

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			String direction = st.nextToken();

			switch (direction) {
				case "U" :
					p.x--;
					if (isOutMap(n, p)) {
						p.x++;
					}
					break;
				case "D" :
					p.x++;
					if (isOutMap(n, p)) {
						p.x--;
					}
					break;
				case "L" :
					p.y--;
					if (isOutMap(n, p)) {
						p.y++;
					}
					break;
				case "R" :
					p.y++;
					if (isOutMap(n, p)) {
						p.y--;
					}
					break;
			}
		}
		System.out.println(p.x + " " + p.y);
	}

	private static boolean isOutMap(int n, Person p) {
		return p.x < 1 || p.x > n || p.y < 1 || p.y > n ;
	}
}

class Person {
	int x;
	int y;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
