package greedy;

public class Ex1_change {
	public static void main(String[] args) {
		int n = 1260;

		int count = calculateMinCoinCount(n);
		System.out.println(count);
	}

	private static int calculateMinCoinCount(int n) {
		int[] coins = {500, 100, 50, 10};

		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			count += n / coins[i];
			n %= coins[i];
		}
		return count;
	}

}
