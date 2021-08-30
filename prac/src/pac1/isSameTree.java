package pac1;

public class isSameTree {


    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 输入：p = [1,2,3], q = [1,2,3]
     * 输出：true
     * 输入：p = [1,2], q = [1,null,2]
     * 输出：false
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);
        return l && r;

    }

    public boolean isSameTree1(TreeNode p, TreeNode q){
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (q.val != p.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
