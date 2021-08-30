package pac1;

public class isValidBST {

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *     / \
     *    3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *     根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        /**
         * 递归处理
         * 验证每个节点均为BST
         */
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 取值区间
     * @param node
     * @param lower  最小值
     * @param upper  最大值
     * @return
     */
    private static boolean isBST(TreeNode node, long lower, long upper) {
        // 终止条件
        if (node == null) {
            return true;
        }
        // 只能小于、或大于
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // 处理&返回  子树的值定于区间
        return isBST(node.left, lower, node.val) && isBST(node.right, node.val, upper);
    }

    public static boolean isValidBST1(TreeNode root) {

        return checkTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean checkTree(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        // 相等看情况，一般不能相等
        if (node.val <= min ||node.val >= max) {
            return false;
        }
        return checkTree(node.left, min, node.val) && checkTree(node.right, node.val, max);
    }


}
