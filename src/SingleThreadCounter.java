public class SingleThreadCounter implements Runnable {
    private double result;
    private final int variant;
    private final double border;

    public SingleThreadCounter(int variant, double border) {
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
}
