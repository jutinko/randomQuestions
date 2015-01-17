import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jutinko on 17/01/15.
 */
public class ExecutorDemoCallable {
    static class MyCallable implements Callable<Long> {
        long max;
        MyCallable(long n) {
            this.max = n;
        }

        @Override
        public Long call() throws Exception {
            return max;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Long>> results = new LinkedList<Future<Long>>();
        Callable worker;
        for(long i = 0; i < 200; ++i) {
            worker = new MyCallable(i);
            results.add(executor.submit(worker));
        }

        long max = Long.MIN_VALUE;
        for(Future<Long> f : results) {
            long curr;
            try {
                curr = f.get();
                if(max < curr) {
                    max = curr;
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            } catch(ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The maximum is: " + max);
    }
}
