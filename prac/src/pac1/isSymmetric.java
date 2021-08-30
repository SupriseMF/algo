package pac1;

public class isSymmetric {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 
     *
     * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {


        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 终止条件
        if (left == null && right == null) {
            return true;
        }
        // 终止条件
        if (left == null || right == null) {
            return false;
        }
        // 终止条件
        if (left.val != right.val) {
            return false;
        }
        // 左子.左 == 右子.右 ？
        // &&
        // 左子.右 == 右子.左 ？
        // 返回结果
        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }

    public boolean isSymmetric1(TreeNode root){
        // root null具体分析
        if (root == null) {
            return false;
        }
        return treeMatch(root.left, root.right);
    }

    private boolean treeMatch(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return treeMatch(left.left, right.right) && treeMatch(left.right, right.left);
    }
}
