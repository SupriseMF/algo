package pac1;

public class minDepth {

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     *
     * 题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
     *
     * 题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
     *
     * 另外这道题的关键是搞清楚递归结束条件
     *
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        // 左子或右子为空，只取不为空的子的长度
        if (root.left == null || root.right == null) {
            return leftMin + rightMin + 1;
        } else {
            return Math.min(leftMin, rightMin) + 1;
        }
    }
}
