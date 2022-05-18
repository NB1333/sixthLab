import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadCounter implements Runnable {
    private final int variant;
    private final double border;
    private double result;

    public MultiThreadCounter(int variant, double border) {
        this.variant = variant;
        this.border = border;
    }

    @Override
    public void run() {
        for (int i = 1; i <= border; i++) {
            result += i * variant;
        }
    }

    public double getResult() {
        return result;
    }

    private double counter() {
        for (int i = 1; i <= border; i++) {
            result += i * variant;
        }

        return result;
    }

    public void runTask(int countOfThreads) {
        ExecutorService threadPool = Executors.newFixedThreadPool(countOfThreads);

        CompletableFuture.supplyAsync(this::counter, threadPool);

        threadPool.shutdown();
    }
}
