package pac1;

import java.util.*;


public class LevelOrder {
    
    
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * [3,9,20,null,null,15,7]
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);

        return res;
    }

    public void traversal(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(node.val);

        traversal(node.left, res, level + 1);
        traversal(node.right, res, level + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelTravel(res, 0, root);
        return res;
    }

    public void levelTravel(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        levelTravel(res, level + 1, node.left);
        levelTravel(res, level + 1, node.right);
    }
}
