public class PGRS_푸드_파이트_대회 {

    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        StringBuilder leftStr = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int N = food[i] / 2;
            for (int n = 0; n < N; n++) {
                leftStr.append(i);
            }
        }
        answer.append(leftStr).append(0);
        leftStr.reverse();
        answer.append(leftStr);

        return answer.toString();
    }
}
