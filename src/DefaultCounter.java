public class DefaultCounter {
    public double count(int variant, double border) {
        double result = 0;

        for (int i = 1; i <= border; i++) {
            result += i * variant;
        }

        return result;
    }
}
