public class PGRS_덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int coveredLocation = 0;

        for (int curLocation : section) {
            if (curLocation > coveredLocation) {
                answer++;
                coveredLocation = curLocation + m - 1;
            }
        }

        return answer;
    }
}
