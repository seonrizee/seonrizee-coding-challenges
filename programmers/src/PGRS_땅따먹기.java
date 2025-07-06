import java.util.Arrays;

public class PGRS_땅따먹기 {

  int solution(int[][] land) {
    int answer = 0;

    int R = land.length;
    int C = 4;
    int[][] dp = new int[R][C];

    dp[0] = Arrays.copyOf(land[0], 4);

    for (int r = 1; r < R; r++) {
      for (int c = 0; c < C; c++) {
        int max = 0;
        for (int k = 0; k < C; k++) {
          if (k != c) {
            max = Math.max(max, dp[r - 1][k]);
          }
          dp[r][c] = land[r][c] + max;
        }
      }
    }

    return Arrays.stream(dp[R - 1]).max().getAsInt();
  }
}

// 그 이전
