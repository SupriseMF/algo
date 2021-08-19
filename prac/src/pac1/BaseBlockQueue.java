package pac1;

public class BaseBlockQueue<T> {


    Object[] queue;
    private volatile int head, tail, size;
    private final int cap;
    // 通过wait/notify实现一个对象锁
    private final Object lock = new Object();

    public BaseBlockQueue(int cap) {
        this.cap = cap;
        queue = new Object[cap];
    }

    public void offer(T t) throws InterruptedException{
        synchronized (lock) {
            if(size == cap) {
                lock.wait();
            }

            queue[tail++] = t;
            tail %= cap;
            size++;

            lock.notify();
        }
    }

    public T poll() throws InterruptedException {
        T res;
        synchronized (lock) {
            if(size == 0) {
                lock.wait();
            }

            res = (T) queue[head++];
            head %= cap;
            size--;

            lock.notify();
        }
        return res;
    }


}
