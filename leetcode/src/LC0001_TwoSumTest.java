import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class LC0001_TwoSumTest {

    @Test()
    void twoSum() {
        LC0001_TwoSum solution = new LC0001_TwoSum();

        // 기본 케이스 테스트
        assertArrayEquals(
                new int[]{0, 1},
                solution.twoSum(new int[]{2, 7, 11, 15}, 9)
        );

        // 음수가 포함된 케이스
        assertArrayEquals(
                new int[]{1, 2},
                solution.twoSum(new int[]{3, -3, 4, 1}, 1)
        );

        // 큰 숫자가 포함된 케이스
        assertArrayEquals(
                new int[]{0, 3},
                solution.twoSum(new int[]{1000, 2, 3, 2000}, 3000)
        );

        // 배열 끝부분의 숫자를 사용하는 케이스
        assertArrayEquals(
                new int[]{3, 4},
                solution.twoSum(new int[]{1, 2, 3, 4, 5}, 9)
        );
    }
}