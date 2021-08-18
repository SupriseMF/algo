package pac1;

public class reverse {

    public static void main(String[] args) {
        int a = (int) (Math.random() * 1000);

        System.out.println(a+":"+reverse(a));

    }

    /**
     * 整数反转
     */
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n;
    }


}
