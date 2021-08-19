package pac1;


public class FirstMissingPositive {



    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0 && nums[i] <= len) {
                dp[nums[i]] = true;
            }
        }
        for (int i = 1; i <= len; i++) {
            if (!dp[i]) {
                return i;
            }
        }
        return len + 1;
    }
}
