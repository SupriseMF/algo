package pac1;

public class climbStairs {

    /**
     * f(i) = f(i - 1) + f(i - 2)
     * 斐波那契数列
     * 使用中间变量做交换
     * 非递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<=2) {
            return n;
        }
        int i_1 = 1;
        int i_2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = i_1 + i_2;
            i_1 = i_2;
            i_2 = tmp;
        }
        return i_2;
    }
}
