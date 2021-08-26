package pac1;


import java.util.Deque;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.Map;

public class buildTree {

    private Map<Integer, Integer> indexMap;

    /**
     * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
     * preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
     * inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
     *
     * @return
     */
    public TreeNode buildTreeWithIndex(int[] preorder, int[] inorder,
                                       int preorderLeft, int preorderRight,
                                       int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 递归实现

        // 前序遍历中的第一个节点就是根节点
        int preorderRoot = preorderLeft;

        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorderRoot - inorderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTreeWithIndex(preorder, inorder,
                preorderLeft + 1, preorderLeft + size_left_subtree,
                inorderLeft, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeWithIndex(preorder, inorder,
                preorderLeft + size_left_subtree + 1, preorderRight,
                inorderRoot + 1, inorderRight);
        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeWithIndex(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 非递归实现，即迭代进行
     *
     * 我们用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（前序遍历的第一个节点），指针指向中序遍历的第一个节点；
     *
     * 我们依次枚举前序遍历中除了第一个节点以外的每个节点。如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向右移动 index，
     * 并将当前节点作为最后一个弹出的节点的右儿子；如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的左儿子；
     *
     * 无论是哪一种情况，我们最后都将当前的节点入栈。
     * preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
     * inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeIteration(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}
