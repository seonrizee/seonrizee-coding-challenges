import java.util.Arrays;

public class PGRS_과일_장수 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        int sumMinScore = Integer.MAX_VALUE;
        int boxCount = 0;

        for (int i = score.length - 1; i >= 0; i--) {

            sumMinScore = Math.min(sumMinScore, score[i]);
            boxCount++;

            if (boxCount == m) {
                answer += sumMinScore * m;
                boxCount = 0;
                sumMinScore = Integer.MAX_VALUE;
            }
        }

        return answer;
    }
}
