package pac1;

import java.util.Random;

public class RandomWithin100 {
    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 随机生成0~100
            System.out.println(RANDOM.nextInt(101));
        }
    }
}
