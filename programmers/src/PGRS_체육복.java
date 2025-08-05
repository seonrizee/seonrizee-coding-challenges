import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PGRS_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {

        Set<Integer> lostNumberSet = new HashSet<>();
        Set<Integer> reserveNumberSet = new HashSet<>();
        Arrays.stream(lost).forEach(lostNumberSet::add);
        Arrays.stream(reserve).forEach(reserveNumberSet::add);

        for (int i : lost) {
            if (reserveNumberSet.contains(i)) {
                reserveNumberSet.remove(i);
                lostNumberSet.remove(i);
            }
        }

        int[] reserveArr = reserveNumberSet.stream()
                .mapToInt(x -> x)
                .toArray();
        Arrays.sort(reserveArr);

        for (int cur : reserveArr) {

            int prev = cur - 1;
            int next = cur + 1;

            if (lostNumberSet.contains(prev)) {
                lostNumberSet.remove(prev);
            } else if (lostNumberSet.contains(next)) {
                lostNumberSet.remove(next);
            }
        }

        return n - lostNumberSet.size();
    }
}
