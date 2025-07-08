public class PGRS_내적 {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        int n = a.length;

        for (int k = 0; k < n; k++) {
            answer += a[k] * b[k];
        }

        return answer;
    }
}
