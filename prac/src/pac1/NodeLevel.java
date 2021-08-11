package pac1;

import java.util.ArrayList;
import java.util.List;

public class NodeLevel {

    List<List<Integer>> nodeList=new ArrayList();

    public List<List<Integer>> levelOrder(TreeNode root) {
        row(root, 0);
        return nodeList;
    }

    public void row(TreeNode node, int idx) {
        if (node == null) {
            return;
        }
        if(nodeList.size()<=idx) {
            nodeList.add(new ArrayList());
        }
        nodeList.get(idx).add(node.val);
        row(node.left, idx + 1);
        row(node.right, idx + 1);
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }


    }
}
