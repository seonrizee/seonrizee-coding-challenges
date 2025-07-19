import java.util.ArrayList;
import java.util.List;

public class PGRS_명예의_전당_1 {

    public int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];
        List<Integer> honorList = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            honorList.add(score[i]);
            honorList.sort((o1, o2) -> o2 - o1);
            if (honorList.size() > k) {
                honorList.remove(k);
            }
            answer[i] = honorList.get(honorList.size() - 1);
        }
        return answer;
    }
}
