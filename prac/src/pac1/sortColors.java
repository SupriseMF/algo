package pac1;

public class sortColors {

    /**
     * 荷兰三色国旗
     * 
     * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int lt = 0;
        int gt = len - 1;
        // 因为只有三种值

        for (int i = 0; i <= gt; i++) {
            // 故当前值为最大值时，交换放在后侧
            while (i <= gt && nums[i] == 2) {
                swap(nums, i, gt);
                gt--;
            }
            // 当前值为最小值时，交换放在最左侧侧
            if (nums[i] == 0) {
                swap(nums, i, lt);
                lt++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
