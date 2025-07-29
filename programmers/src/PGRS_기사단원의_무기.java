public class PGRS_기사단원의_무기 {

    public int solution(int number, int limit, int power) {

        int answer = 0;

        for (int cur = 1; cur <= number; cur++) {
            int cnt = 0;
            for (int i = 1; i * i <= cur; i++) {
                if (cur % i == 0) {
                    if (i * i != cur) {
                        cnt += 2;
                    } else {
                        cnt++;
                    }
                }
            }

            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }

        return answer;
    }
}
