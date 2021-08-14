package pac1;

public class hasPathSum {

    /**
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     * 输出：true
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 终止条件
        if (root == null) {
            return false;
        }
        // 终止条件
        // 当为子节点，且子节点的值正好是目标值
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        // 处理逻辑
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        // 返回是否存在
        return left || right;
    }
}
