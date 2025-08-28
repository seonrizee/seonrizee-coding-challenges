public class PGRS_N개의_최소공배수 {

    public int solution(int[] arr) {

        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = getLCM(answer, arr[i]);
        }
        return answer;
    }

    private int getGCD(int a, int b) {

        // a*b = g*l
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    private int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }
}
