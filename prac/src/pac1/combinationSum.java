package pac1;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();

        findComb(res, comb, candidates, 0, target);
        return res;
    }

    /**
     * 使用回溯法
     *
     *
     * 时间复杂度 O(S)，其中S为所有可行解长度
     * 空间复杂度O(target) 其中target为目标和，递归取决于递归栈的长度，最差要递归O(target)层
     * @param res
     * @param comb
     * @param candidates
     * @param index
     * @param target
     */
    private static void findComb(List<List<Integer>> res, List<Integer> comb, int[] candidates, int index, int target) {
        // 终止条件
        // 相等时，说明已遍历一遍
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            // 使用new list包装
            res.add(new ArrayList<>(comb));
            return;
        }
        // 跳过
        findComb(res, comb, candidates, index + 1, target);
        // 不跳过 选择当前数字
        if (target - candidates[index] >= 0) {
            comb.add(candidates[index]);
            // 继续递归 可重复选择，故index保持
            findComb(res, comb, candidates, index, target - candidates[index]);
            // 回溯返回，删除末尾元素
            comb.remove(comb.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 9;
        List<List<Integer>> res = combinationSum(nums, target);
        System.out.println(res);

//        for (List<Integer> list : res) {
//
//        }
    }
}
