public class PGRS_멀리_뛰기 {

    public long solution(int n) {
        final long DIVIDER = 1234567;

        if (n <= 2) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // dp[n] = dp[n-1] + dp[n-2];

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVIDER;
        }

        return dp[n];
    }
}
