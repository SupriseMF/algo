package pac1;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Rand10 {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < 100000; i++) {
            int val = rand10();

            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        System.out.println(map);

    }
    private static Random RANDOM = new Random();


    /**
     * 平均情况下需要调用 Rand7() 的次数。我们称连续调用两次 Rand7() 为一轮，
     * 在第一轮中，有 40/49 的概率不被拒绝，而有 9/49 的概率被拒绝，
     * 进入第二轮。在第二轮中也是如此，
     * 因此调用 Rand7() 的期望次数为：
     * E = 2+ 2*9/49 + 2*9/49*9/49 + 2*9/49*9/49*9/49 + ...
     * E = 2*(1-(9/49)^n/(1-9/49))
     *
     *
     * @return
     */
    public static int rand10() {
        int row = 0;
        int col = 0;
        int index = 0;

        do {
            row = rand7();
            col = rand7();
            // col和row的出现的概率一样，不可直接col*row，因为col或row的并非一直为7
            // 1~7+0~42 = 1~49
            index = col + (row - 1) * 7;

            // 当index大于40时，跳出循环
        } while (index > 40);


        // 根据index取余，加一，即可1~10
        return 1 + (index - 1) % 10;

    }

    public static int rand7() {
        return RANDOM.nextInt(7) + 1;
    }
}
