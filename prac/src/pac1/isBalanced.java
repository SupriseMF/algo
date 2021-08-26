package pac1;

public class isBalanced {



    class ReturnNode {
        private int dept;
        private boolean isB;
        ReturnNode(int dept, boolean isB) {
            this.dept = dept;
            this.isB = isB;
        }


        ReturnNode() {

        }
    }

    public boolean isBalanced(TreeNode root) {
        return isBST(root).isB;
    }

    public ReturnNode isBST(TreeNode root) {
        if (root == null) {
            return new ReturnNode(0, true);
        }
        ReturnNode left = isBST(root.left);
        ReturnNode right = isBST(root.right);
        if (!left.isB || !right.isB) {
            return new ReturnNode(0, false);
        }
        if (Math.abs(left.dept - right.dept) > 1) {
            return new ReturnNode(0, false);
        }
        return new ReturnNode(Math.max(left.dept, right.dept) + 1, true);
    }
}
