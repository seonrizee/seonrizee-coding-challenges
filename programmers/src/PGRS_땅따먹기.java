import java.util.Arrays;

public class PGRS_땅따먹기 {

  int solution(int[][] land) {
    int answer = 0;

    int R = land.length;
    int C = 4;
    int[][] sum = new int[R][C];

    sum[0] = Arrays.copyOf(land[0], 4);

    for (int r = 1; r < R; r++) {
      sum[r][0] = land[r][0] + Math.max(sum[r - 1][1], Math.max(sum[r - 1][2], sum[r - 1][3]));
      sum[r][1] = land[r][1] + Math.max(sum[r - 1][0], Math.max(sum[r - 1][2], sum[r - 1][3]));
      sum[r][2] = land[r][2] + Math.max(sum[r - 1][0], Math.max(sum[r - 1][1], sum[r - 1][3]));
      sum[r][3] = land[r][3] + Math.max(sum[r - 1][0], Math.max(sum[r - 1][1], sum[r - 1][2]));
    }

    answer =
        Math.max(sum[R - 1][0], Math.max(sum[R - 1][1], Math.max(sum[R - 1][2], sum[R - 1][3])));

    return answer;
  }
}

// 그 이전
