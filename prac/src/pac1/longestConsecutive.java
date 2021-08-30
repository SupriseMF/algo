package pac1;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {


    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * @param nums
     * @return
     */
//    public int longestConsecutive(int[] nums) {
//
//        /**
//         * 用一个哈希表存储数组中的数，这样查看一个数是否存在即能优化至 O(1) 的时间复杂度。
//         *
//         * 由于我们要枚举的数 x 一定是在数组中不存在前驱数 x−1 的，
//         * 不然按照上面的分析我们会从 x−1 开始尝试匹配，
//         * 因此我们每次在哈希表中检查是否存在 x−1 即能判断是否需要跳过了。
//         * 在外层循环的时候碰到这种情况跳过即可。
//         */
//        Set<Integer> num_set = new HashSet<Integer>();
//        for (int num : nums) {
//            num_set.add(num);
//        }
//
//        int longestStreak = 0;
//
//        /**
//         * 外层循环需要 O(n) 的时间复杂度，
//         * 只有当一个数是连续序列的第一个数的情况下才会进入内层循环，
//         * 然后在内层循环中匹配连续序列中的数，
//         * 因此数组中的每个数只会进入内层循环一次。总时间复杂度为 O(n)
//         */
//        for (int num : num_set) {
//            if (!num_set.contains(num - 1)) {
//                int currentNum = num;
//                int currentStreak = 1;
//
//                while (num_set.contains(currentNum + 1)) {
//                    currentNum += 1;
//                    currentStreak += 1;
//                }
//
//                longestStreak = Math.max(longestStreak, currentStreak);
//            }
//        }
//        return longestStreak;
//    }


    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (Integer num : set) {
            // 找到最小的
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLength = 1;
                // 从最小的值开始遍历
                while (set.contains(cur + 1)) {
                    cur++;
                    curLength++;
                }
                maxLength = Math.max(curLength, maxLength);
            }
        }
        return maxLength;
    }

}
