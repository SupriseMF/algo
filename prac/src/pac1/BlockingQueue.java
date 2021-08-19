package pac1;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {

    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int totalCount;
    private LinkedList<Integer> queue;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }


    public void put(Integer value) throws InterruptedException {
        lock.lock();
        try {
            // 队列已满，阻塞等待，直至队列有位置
            while (totalCount == capacity) {
                notFull.await();
            }
            queue.add(value);
            totalCount++;
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public Integer take() throws InterruptedException {
        lock.lock();
        try {
            // 当前队列为空，阻塞等待，直至非空
            while (totalCount == 0) {
                notEmpty.await();
            }
            Integer res = queue.pop();
            totalCount--;
            notEmpty.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(20);
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(i);
            }

            for (int i = 0; i < 10; i++) {
                System.out.println(queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
