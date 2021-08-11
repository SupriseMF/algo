package pac1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {			//二叉树为空，直接返回空结果
            return res;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(root);
        levelOrder(res, deque, 1);
        return res;
    }

    /*
     * 参数列表说明：
     * res 结果集
     * deque 双向队列存储当前层次遍历的结点
     * flag 记录当前遍历的层数，用来控制层序遍历的方向
     */
    void levelOrder(List<List<Integer>> res, ArrayDeque<TreeNode> deque, int level) {

        int size = deque.size();
        if (size == 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (level == 1) {
            // 从右子节点，向左子节点倒着
            //当下次取出子时，从右往左
            while (size-- != 0) {
                TreeNode root = deque.pollFirst();
                arrayList.add(root.val);
                if (root.left != null) {
                    deque.offer(root.left);
                }
                if (root.right != null) {
                    deque.offer(root.right);
                }
            }
            //加入结果集，递归下一层
            res.add(arrayList);
            levelOrder(res, deque, 2);
        } else {
            // 从左子节点，向右子节正序
            //当下次取出子时，从左往右
            while (size-- != 0) {
                TreeNode root = deque.pollLast();
                arrayList.add(root.val);
                if (root.right != null) {
                    deque.offerFirst(root.right);
                }
                if (root.left != null) {
                    deque.offerFirst(root.left);
                }
            }
            //加入结果集，//递归下一层
            res.add(arrayList);
            levelOrder(res, deque, 1);
        }

    }

    /**
     * dfs 深度优先查询
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        // 不存在时new
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        // 奇数层 倒序插入，后面的数字后移
        if ((level & 1) == 1){
            res.get(level).add(0, root.val);
        } else {
            // 偶数层 正序插入列表
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random() * 100);
            System.out.println(r + ":" + (r & 1));
        }


    }




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
}
