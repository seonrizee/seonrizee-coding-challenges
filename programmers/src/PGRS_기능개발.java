import java.util.ArrayList;
import java.util.List;

public class PGRS_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        int len = progresses.length;
        while (idx < len) {

            for (int i = 0; i < len; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[idx] >= 100) {
                int count = 0;
                for (int i = idx; i < len; i++) {
                    if (progresses[i] >= 100) {
                        count++;
                        idx++;
                    } else {
                        break;
                    }
                }
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
