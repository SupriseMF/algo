package pac1;

public class maxPathSum {

    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
     * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     * <p>
     * <p>
     * 输入：root = [1,2,3]
     * 输出：6
     * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [-10,9,20,null,null,15,7]
     * 输出：42
     * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
     */

    private int MAX_PATH = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        /**
         * 最大路径和 = 左子路径 + node.val+ 右子路径
         */
        findMaxPath(root);
        return MAX_PATH;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 计算左、右值
        int leftSum = Math.max(findMaxPath(node.left), 0);
        int rightSum = Math.max(findMaxPath(node.right), 0);

        // 计算当前节点和左右的最大
        int newSum = node.val + leftSum + rightSum;

        // 更新最大值：是取当前节点及左右的最大，还是当前记录的最大值
        MAX_PATH = Math.max(MAX_PATH, newSum);

        // 返回 当前节点val + 左、右最大val，给上层需要
        return node.val+ Math.max(leftSum, rightSum);
    }
}
