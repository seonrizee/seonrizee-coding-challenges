import java.util.ArrayList;
import java.util.List;

public class PGRS_모의고사 {

    public int[] solution(int[] answers) {
        int[] answerCnt = new int[3];
        int maxCnt = 0;

        int[][] ansRoutine = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                answerCnt[j] += answers[i] == ansRoutine[j][i % ansRoutine[j].length] ? 1 : 0;
                maxCnt = Math.max(maxCnt, answerCnt[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (answerCnt[i] == maxCnt) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
