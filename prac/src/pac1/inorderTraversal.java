package pac1;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
     *
     * 
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traver(root, res);

        return res;

    }

    private void traver(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        traver(node.left, res);
        res.add(node.val);
        traver(node.right, res);
    }
}
