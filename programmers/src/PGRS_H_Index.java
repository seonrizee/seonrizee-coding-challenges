import java.util.Arrays;

public class PGRS_H_Index {

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int h = n; h >= 1; h--) {
            if (citations[n - h] >= h) {
                return h;
            }
        }

        return 0;
    }
}