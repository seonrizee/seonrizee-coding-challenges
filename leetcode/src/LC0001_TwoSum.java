public class LC0001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return answer;
    }
}

