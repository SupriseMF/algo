package pac1;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrint {
    public static void main(String[] args) {
        AtomicIntegerPutGet test = new AtomicIntegerPutGet();

        //充当线程A的角色
        new Thread() {
            @Override
            public void run() {
                test.put();
            }
        }.start();

        //充当线程B的角色
        new Thread() {
            @Override
            public void run() {
                test.get();
            }
        }.start();
    }

    static class AtomicIntegerPutGet {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        AtomicInteger flag = new AtomicInteger(0);//0表示线程0可以执行, 1表示线程1可以执行

        void put() {
            for (int k = 0; k < 100; k++) {
                //自旋
                for (; ; ) {
                    if ((flag.intValue() & 1) == 0) {
                        break;
                    }
                }
                map.put(i, i);
                System.out.println(Thread.currentThread().getName() + "  " + i);
                i++;
                flag.compareAndSet(flag.intValue(), 1);
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }

        void get() {
            for (int k = 0; k < 100; k++) {
                //自旋
                for (; ; ) {
                    if ((flag.intValue() & 1) == 1) {
                        break;
                    }
                }
                int cur = map.get(i - 1);
                System.out.println(Thread.currentThread().getName() + "  " + cur);
                flag.compareAndSet(flag.intValue(), 0);
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        }
    }
}
