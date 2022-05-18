public class Counter1 {

    public Double count(double a) {
        for (double i = 0; i < 1_000_000; i++) {
            a = a + Math.tan(a);
        }

        return a;
    }
}
