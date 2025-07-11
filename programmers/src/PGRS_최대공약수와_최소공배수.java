public class PGRS_최대공약수와_최소공배수 {

    public int[] solution(int n, int m) {
        int GCD = gcd(Math.max(n, m), Math.min(n, m));
        int LCM = (n * m) / GCD;

        return new int[]{GCD, LCM};
    }

    private int gcd(int first, int second) {

        if (second == 0) {
            return first;
        }

        return gcd(second, first % second);
    }
}
