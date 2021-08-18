package pac1;

public class majorityElement {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 
     *
     * 示例1：
     *
     * 输入：[3,2,3]
     * 输出：3
     * 示例2：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * 设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 投票算法证明：
        //
        //如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
        //如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选

        // 当前候选人获选票数
        int count = 0;
        // 当前候选人
        Integer candidate = null;
        for (int num : nums) {
            // 当前选票为0，即候选人不存在，包括：还没开始选和上位候选人已下台，选择当前人为候选人
            if (count == 0) {
                candidate = num;
            }
            // 当前人就是候选人，选票+1
            if (num == candidate) {
                count++;
            } else {
                // 当前人不是候选人，选票-1
                count--;
            }
        }
        return candidate;
    }
}
