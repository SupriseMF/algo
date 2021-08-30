package pac1;

import java.util.concurrent.atomic.AtomicInteger;

public class AlternatePrinting {

    //让两个线程使用同一把锁。交替执行 。
    //判断是不是奇数 如果是奇数进入奇数线程执行打印并加一。然后线程释放锁资源。然后让该线程等待
    //判断是不是偶数，如果是偶数进入偶数线程执行打印并加一。然后线程释放锁资源。然后让该线程等待
    public static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        
        Thread a = new Thread(new AThread());
        Thread b = new Thread(new BThread());
        a.start();
        b.start();
    }

    //奇数线程
    public static class AThread implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (atomicInteger) {
                    if (atomicInteger.intValue() % 2 != 0) {
                        System.out.println("奇数线程:" + atomicInteger.intValue());
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e1) {
//                            e1.printStackTrace();
//                        }
                        // 以原子方式将当前值加 1。
                        atomicInteger.getAndIncrement();
                        // 奇数线程释放锁资源
                        // 执行完操作后释放锁并进入等待
                        atomicInteger.notify();
                        try {
                            atomicInteger.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 奇数线程等待
                        try {
                            atomicInteger.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

 
    //偶数线程
    public static class BThread implements Runnable{
         @Override
         public void run() {

             while (true) {
                 synchronized (atomicInteger) {
                     if (atomicInteger.intValue() % 2 == 0) {
                         System.out.println("偶数线程:" + atomicInteger.intValue());
//                         try {
//                             Thread.sleep(500);
//                         } catch (InterruptedException e1) {
//                             e1.printStackTrace();
//                         }
                         // 以原子方式将当前值加 1。
                         atomicInteger.getAndIncrement();
                         // 偶数线程释放锁资源
                         //执行完操作后释放锁并进入等待
                         atomicInteger.notify();
                         try {
                             atomicInteger.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     } else {
                         try {
                            // 偶数线程等待
                             atomicInteger.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 }
             }
         }
    }
}


