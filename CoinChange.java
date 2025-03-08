public class CoinChange {
    // wap to coin change
    static int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int res = coinChange(coins, amount - coins[i], dp);
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, res + 1);
                }
            }
        }
        dp[amount] = min;
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 5, 7 };
        int amount = 18;
        int[] dp = new int[amount + 1];
        System.out.println(coinChange(coins, amount, dp));
    }
}
