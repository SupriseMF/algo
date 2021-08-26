package pac1;

public class mergeTrees {


    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。
     * 合并的规则是:
     * 如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
     * 否则不为NULL 的节点将直接作为新二叉树的节点。
     *
     * 输入: 
     * 	Tree 1                     Tree 2                  
     *           1                         2                             
     *          / \                       / \                            
     *         3   2                     1   3                        
     *        /                           \   \                      
     *       5                             4   7                  
     * 输出: 
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \ 
     * 	 5   4   7
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);

    }

    private TreeNode merge(TreeNode node1, TreeNode node2) {
        // 边界
        if (node1 == null && node2 == null) {
            return null;
        }
        // 处理
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        // 均不为null，以node1为基础
        node1.val += node2.val;
        node1.left = merge(node1.left, node2.left);
        node1.right = merge(node1.right, node2.right);

        // 返回
        return node1;
    }
}
