import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int variant = 4;
        double border = 1_000_000_000d;
        double k = 4;
        int countOfThreads = 12;

        DefaultCounter task1 = new DefaultCounter();

        double defaultResult = 0;

        long startTime = System.nanoTime();
        defaultResult = task1.count(variant, border);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);
        double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;

        System.out.println("The result of default counting is: " + defaultResult +
                "\nDefault count time: " + elapsedTimeInSeconds + " seconds");

        Runnable task2 = new SingleThreadCounter(variant, border);
        Thread t2 = new Thread(task2);

        startTime = System.nanoTime();
        t2.start();
        endTime = System.nanoTime();
        System.out.println();
        elapsedTime = (endTime - startTime);
        elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;

        System.out.println("The result of single thread counting is: " /*+ task2.getResult()*/ +
                "\nSingle thread count time: " + elapsedTimeInSeconds + " seconds");


        MultiThreadCounter task3 = new MultiThreadCounter(variant, border);

        startTime = System.nanoTime();
        task3.runTask(countOfThreads);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000;

        System.out.println("Multi thread count time: " + elapsedTimeInSeconds + " seconds");
    }
}