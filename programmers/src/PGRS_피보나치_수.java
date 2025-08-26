public class PGRS_피보나치_수 {

    public int solution(int n) {
        final int DIVIDER = 1234567;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % DIVIDER;
        }

        return dp[n];
    }
}
