public class TestReadRadius {

    public static void main(String[] args) {
        checkReadRadius();
    }

    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkReadRadius() {
        System.out.println("Checking readRadius...");
        String planetsTxtPath = "./data/planets.txt";
        /* If the following line fails to compile, you probably need to make
         * a certain method static! */
        double actualOutput = NBody.readRadius(planetsTxtPath);
        checkEquals(actualOutput, 2.50E11, "readRadius()", 0.01);
    }


}
