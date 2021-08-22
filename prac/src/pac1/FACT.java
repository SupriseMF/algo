package pac1;

import java.util.Scanner;

public class FACT {
    public static void main(String[] args) {
        int m;
        int[] data = new int[10000];
        Scanner scanner = new Scanner(System.in);
        m= scanner.nextInt();

        m = BigFact(m, data);
        System.out.println(m);
        System.out.print(data[m--]);
        while (m > 0) {
            System.out.printf("%05d", data[m--]);
        }
//        for (int datum : data) {
//            if (datum != 0) {
//                System.out.println(datum);
//            }
//        }
        System.out.println();
        scanner.close();
    }

    /**
     * 输入m的 求m!
     * @param m
     * @param data
     * @return
     */
    static int BigFact(int m,int[] data) {
        //index为位数
        int i, j, k, index = 1;
        int N=100000;
        //1!=1
        data[1]=1;
        for (i=1; i<=m; i++) {
            //模拟乘法
            for (j = 1; j <= index; j++) {
                data[j] *= i;
            }
            //进位
            for (k = 1; k < index; k++) {
                if (data[k] >= N) {
                    data[k + 1] += data[k] / N;
                    data[k] %= N;
                }
            }
            //最高位进位
            while (data[index] >= N) {
                data[index + 1] = data[index] / N;
                data[index++] %= N;
            }
        }
        return index;
    }
}

