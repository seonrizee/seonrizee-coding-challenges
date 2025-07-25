import java.util.Arrays;

public class PGRS_소수_만들기 {

    public int solution(int[] nums) {

        final int N = nums.length;
        final int R = 3;
        int[] selectedNumbers = new int[R];

        return combination(0, 0, nums, selectedNumbers, N, R, 0);
    }

    private int combination(int selectedNumberCnt, int startIndex, int[] nums, int[] selectedNumbers, int N, int R,
                            int totalCnt) {
        if (selectedNumberCnt == R) {
            if (isPrime(selectedNumbers)) {
                return totalCnt + 1;
            }
            return totalCnt;
        }

        for (int i = startIndex; i < N; i++) {
            selectedNumbers[selectedNumberCnt] = nums[i];
            totalCnt = combination(selectedNumberCnt + 1, i + 1, nums, selectedNumbers, N, R, totalCnt);
        }
        return totalCnt;
    }

    private boolean isPrime(int[] selectedNumbers) {

        int sum = Arrays.stream(selectedNumbers).sum();
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
