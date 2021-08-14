package pac1;

public class sortedArrayToBST {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     *
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * 
     *
     * 示例 1：
     *
     *
     *
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums, 0, nums.length-1);
    }

    private TreeNode getTree(int[] nums, int l, int r) {
        // 结束条件
        if (l>r) {
            return null;
        }
        // 递归内容：1、构造局部root  2、找到左子、右子（递归）
        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = getTree(nums, l, m - 1);
        root.right = getTree(nums, m + 1, r);
        // 返回内容：root
        return root;
    }
}
