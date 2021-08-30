package pac1;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerAndConsumerByQueue {
    private final BlockingDeque<Toy> blockingDeque = new LinkedBlockingDeque<Toy>(10);

    public static void main(String[] args) {
        ProducerAndConsumerByQueue producerAndConsumer = new ProducerAndConsumerByQueue();

        new Thread(producerAndConsumer.new Producer()).start();
        new Thread(producerAndConsumer.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i ++ ) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toy toy = new Toy(i + "");
                try {
                    blockingDeque.put(toy);
                    System.out.println( "生产者" + Thread.currentThread().getName() + " 生产玩具" + toy.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i ++ ) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Toy toy = blockingDeque.take();
                    System.out.println("消费者" + Thread.currentThread().getName() + " 消费玩具" + toy.getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Toy {
        private String name;

        public Toy(String name) {
            this.name = name;
        }
        public String getName() {
            return "toy " + name;
        }
    }
}
