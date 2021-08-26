package pac1;

public class diameterOfBinaryTree {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。
     * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     * <p>
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
     *
     * @param root
     * @return
     */
    private int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return maxPath;
    }

    private int find(TreeNode node) {
        // 边界
        if (node == null) {
            return 0;
        }

        // 处理
        int leftMax = find(node.left);
        int rightMax = find(node.right);

        // 更新最长路径
        maxPath = Math.max(maxPath, leftMax + rightMax);
        // 返回节点深度
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void main(String[] args) {

    }
}
