public class PGRS_3진법_뒤집기 {

    // 직접 구현 버전
    public int solution(int n) {
        String cur;
        cur = toThreeAndReverse(n);
        n = toTen(cur);

        return n;
    }

    private String toThreeAndReverse(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int a = n / 3;
            int b = n % 3;

            sb.append(b);
            n = a;
        }

        return sb.toString();
    }

    private int toTen(String n) {
        int number = 0;
        int power = 1;
        int length = n.length();
        for (int i = length - 1; i >= 0; i--) {
            number += ((n.charAt(i) - '0') * power);
            power *= 3;
        }
        return number;
    }
}