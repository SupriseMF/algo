package pac1;

public class singleNumber {

    /**
     * 可使用异或运算 ⊕。异或运算有以下三个性质。
     *
     * 任何数和0做异或运算，结果仍然是原来的数，即a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即a⊕a=0。
     * 异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;

    }
}
