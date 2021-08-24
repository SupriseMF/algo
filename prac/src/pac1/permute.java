package pac1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class permute {


    /**
     * 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        /**
         * 回溯法
         * 时间复杂度O(N*N!)， 结果个数：N!，同时遍历了N次
         * 空间复杂度O(N)， 其中需要一个N的递归栈（不计算结果的空间）
         *
         */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        for (int num : nums) {
            comb.add(num);
        }
        findAllComb(res, comb, 0);
        return res;
    }

    private static void findAllComb(List<List<Integer>> res, List<Integer> comb, int index) {
        // 回溯结束条件
        if (index == comb.size()) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = index; i < comb.size(); i++) {
            // 选择
            // 交换位置
            Collections.swap(comb, index, i);
            // 选择后，不重复选择
            findAllComb(res, comb, index + 1);
            // 撤销操作，
            Collections.swap(comb, i, index);
        }

    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(permute(nums));
    }
}
