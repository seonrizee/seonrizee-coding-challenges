import java.util.HashSet;
import java.util.Set;

public class PGRS_연속_부분_수열_합의_개수 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        for (int start = 0; start < n; start++) {
            int currentSum = 0;
            for (int length = 0; length < n; length++) {
                int currentIndex = (start + length) % n;
                currentSum += elements[currentIndex];
                set.add(currentSum);
            }
        }

        return set.size();
    }
}