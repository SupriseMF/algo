package pac1;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.ArrayList;
import java.util.List;

public class flatten {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * 
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }


    /**
     * 先序遍历
     * @param node
     * @param list
     */
    private void preOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
