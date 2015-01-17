import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jutinko on 17/01/15.
 */
public class ExecutorDemo {
    static class MyThread implements Runnable {
        private long count;

        MyThread(long count) {
            this.count = count;
        }

        @Override
        public void run() {
            long sum = 0;
            for(long i = 0; i < count; ++i) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable worker;
        for(int i = 0; i < 500; ++i) {
            worker = new MyThread(10000000L+i);
            executor.submit(worker);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All threads finished");
    }
}
