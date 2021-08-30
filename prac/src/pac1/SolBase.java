package pac1;

import jdk.nashorn.internal.ir.ReturnNode;

public class SolBase {

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(rand10());
        }

    }

    public static int rand10() {
        int res = 0;
        while (true) {
            //构造1~49的均匀分布
            res = (rand7() - 1) * 7 + rand7();
            //剔除大于40的值，1-40等概率出现。
            if (res <= 40) {

                break;
            }
            //构造1-10的均匀分布
//            return res % 10 + 1;
        }
        return res % 10 + 1;
    }

    public static int rand7() {
        return (int) (Math.random() * 7) + 1;
    }
}
