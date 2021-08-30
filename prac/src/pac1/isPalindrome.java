package pac1;

public class isPalindrome {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 输入：x = 121
     * 输出：true
     *
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse1(x);
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n;
    }

    public static int reverse1(int x){
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String reverse = new StringBuilder(builder).reverse().toString();
        return reverse.equals(builder.toString());
    }


    public static void main(String[] args) {

        System.out.println(isPalindrome(1221)?"T":"F");

    }
}
