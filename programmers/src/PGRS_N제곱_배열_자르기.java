public class PGRS_N제곱_배열_자르기 {

    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {

            long originalIdx = left + i;

            long row = originalIdx / n;
            long col = originalIdx % n;

            answer[i] = (int) (Math.max(row, col) + 1);
        }

        return answer;
    }
}
