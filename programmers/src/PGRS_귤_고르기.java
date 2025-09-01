import java.util.HashMap;
import java.util.Map;

public class PGRS_귤_고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int maxCnt = 0;

        Map<Integer, Integer> sizeToCntMap = new HashMap<>();

        for (int size : tangerine) {
            sizeToCntMap.put(size, sizeToCntMap.getOrDefault(size, 0) + 1);
            maxCnt = Math.max(sizeToCntMap.get(size), maxCnt);
        }
        int[] sumOfCnt = new int[maxCnt + 1];

        for (Integer i : sizeToCntMap.keySet()) {
            sumOfCnt[sizeToCntMap.get(i)]++;
        }

        while (k > 0) {
            if (sumOfCnt[maxCnt] == 0) {
                maxCnt--;
                continue;
            }
            k -= maxCnt;
            sumOfCnt[maxCnt]--;
            answer++;
        }

        return answer;
    }
}
