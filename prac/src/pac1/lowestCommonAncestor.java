package pac1;

public class lowestCommonAncestor {


    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 时间复杂度 O(N) 最差遍历整个树
         * 空间复杂度 O(N) 最差遍历整个树
         */
        treeTravel(root, p, q);
        return ans;
    }

    private boolean treeTravel(TreeNode node, TreeNode p, TreeNode q) {
        // 终止条件
        if (node == null) {
            return false;
        }
        // 处理
        boolean leftFound = treeTravel(node.left, p, q);
        boolean rightFound = treeTravel(node.right, p, q);
        // 更新结果
        // 情况1：左右子有q、p
        // 情况2：左或右有一个，自身是另一个
        if ((leftFound && rightFound ) || ((node.val == p.val || node.val == q.val) && (leftFound || rightFound))) {
            ans = node;
        }

        // 返回
        return leftFound || rightFound || (node.val == p.val || node.val == q.val);
    }


}
