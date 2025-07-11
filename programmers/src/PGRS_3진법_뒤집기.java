class Solution {
    public int solution(int n) {
        // 1. 10진수 n을 3진법 문자열로 변환
        String base3 = Integer.toString(n, 3);

        // 2. StringBuilder를 사용해 문자열을 뒤집음
        String reversedBase3 = new StringBuilder(base3).reverse().toString();

        // 3. 뒤집힌 3진법 문자열을 다시 10진수 정수로 변환
        return Integer.parseInt(reversedBase3, 3);
    }
}