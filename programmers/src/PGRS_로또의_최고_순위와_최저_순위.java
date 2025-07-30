import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PGRS_로또의_최고_순위와_최저_순위 {

    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> winNumsSet = new HashSet<>();
        for (int winNum : win_nums) {
            winNumsSet.add(winNum);
        }

        int realMatchCnt = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            } else if (winNumsSet.contains(lotto)) {
                realMatchCnt++;
            }
        }

        Map<Integer, Integer> cntToRank = new HashMap<>();
        cntToRank.put(0, 6);
        for (int i = 1; i <= 6; i++) {
            cntToRank.put(i, 7 - i);
        }

        return new int[]{cntToRank.get(realMatchCnt + zeroCnt), cntToRank.get(realMatchCnt)};
    }
}
