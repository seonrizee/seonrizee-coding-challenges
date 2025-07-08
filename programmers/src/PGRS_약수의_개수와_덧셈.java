public class PGRS_약수의_개수와_덧셈 {

    public int solution(int left, int right) {
        int answer = 0;

        for (int cur = left; cur <= right; cur++) {
            int cnt = getCntOfDivisor(cur);
            answer += cnt % 2 == 0 ? cur : -cur;
        }
        return answer;
    }

    public int getCntOfDivisor(int target) {
        int cnt = 0;

        for (int k = 1; k <= target; k++) {
            if (target % k == 0) {
                cnt++;
            }
        }

        return cnt;
    }
}
