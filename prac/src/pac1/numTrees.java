package pac1;

public class numTrees {

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     *
     * 示例 1：
     *
     *
     * 输入：n = 3
     * 输出：5
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：1
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        /**
         * 动态规划
         * 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
         * G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
         * F(i,n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1 ≤ i ≤ n) 。
         * G(n)=∑(i=1->n) F(i,n)
         *
         * 时间复杂度O(N*N)
         * 空间复杂度O(1)
         *
         */
        // 边界 G(0) = 1 (0节点)  G(1) = 1(1节点)
        int[] G = new int[n];
        G[0] = 1;
        G[1] = 1;
        // 从2个节点开始
        for (int i = 2; i <= n; i++) {
            // j为左子树的节点数： 从1，到i
            for (int j = 1; j <= i; j++) {
                G[i] += G[i] * G[i - j];
            }
        }
        return G[n];
    }

    public static int numTrees1(int n) {
        /**
         * 数学公式
         * C(0)=1
         * C(n+1)= [2(2n+1) / (n+2)] C(n)
         *
         * 时间复杂度O(N)
         * 空间复杂度O(1)
         *
         */
        // 边界 G(0) = 1 (0节点)  G(1) = 1(1节点)
        long C = 1;
        // 进行N次
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " : " + numTrees1(i));
        }


    }
}
