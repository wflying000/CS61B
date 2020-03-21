public class TestUpdate {

    public static void main(String[] args){
        checkUpdate();
    }

    public static void checkEquals(double expected, double actual, String label, double eps){
        if(Math.abs(expected - actual) <= eps * Math.max(expected, actual)){
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        }else{
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkUpdate() {
        System.out.println("Checking update...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");

        p1.update(2.0, 1.0, -0.5);

        checkEquals(3.4, p1.xxVel, "xxVel update()", 0.01);
        checkEquals(3.8, p1.yyVel, "yyVel update()", 0.01);
        checkEquals(7.8, p1.xxPos, "xxPos update()", 0.01);
        checkEquals(8.6, p1.yyPos, "yyPos update()", 0.01);
    }
}
