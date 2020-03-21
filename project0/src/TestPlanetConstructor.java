public class TestPlanetConstructor {

    public static void main(String[] args){
        checkPlanetConstructor();
    }

    private static void checkEquals(double expected, double actual, String label){
        if(expected == actual){
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        }else{
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkStringEquals(String expected, String actual, String label){
        if(expected.equals(actual)){
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        }else{
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkPlanetConstructor(){
        System.out.print("Checking first Planet constructor...");

        double xxPos = 1.0,
               yyPos = 2.0,
               xxVel = 3.0,
               yyVel = 4.0,
               mass = 5.0;

        String imgFileName = "jupiter.gif";

        Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

        checkEquals(xxPos, p.xxPos, "xxPos");
        checkEquals(yyPos, p.yyPos, "yyPos");
        checkEquals(xxVel ,p.xxVel, "xxVel");
        checkEquals(yyVel, p.yyVel, "yyVel");
        checkEquals(mass, p.mass, "mass");
        checkStringEquals(imgFileName, p.imgFileName, "path to image");




        System.out.println("Checking second Planet constructor...");

        Planet pCopy = new Planet(p);
        checkEquals(p.xxPos, pCopy.xxPos, "xxPos");
        checkEquals(p.yyPos, pCopy.yyPos, "yyPos");
        checkEquals(p.xxVel, pCopy.xxVel, "xxVel");
        checkEquals(p.yyVel, pCopy.yyVel, "yyVel");
        checkEquals(p.mass, pCopy.mass, "mass");
        checkStringEquals(p.imgFileName, pCopy.imgFileName, "path to image");
    }

}
