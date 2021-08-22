package pac1;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组旋转
 */
public class rotate {


    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例c:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释: 
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        /**
         * 环状替换
         */
        int count = gcd(n, k);
        for (int start = 0; start < count; start++) {
            // 当前位置
            int current = start;
            int prev = nums[start];
            do {
                // 下次位置
                int next = (current + k) % n;
                // 交换值
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                // 更新当前位置
                current = next;
                // 当还没遍历一遍
            } while (start != current);
        }
    }

    /**
     * N和K的最大公约数
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    private static List<Integer> intset = new ArrayList<>();

    /**
     * 最小公倍数
     */
    public static int minCommonD(int x, int y) {
        int res = gcd(x, y);
        return x / res * y;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 15;

        System.out.println(gcd(a, b));

        System.out.println(minCommonD(a, b));
    }
}
