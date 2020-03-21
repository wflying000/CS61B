public class NBody {

    public static String backgroundImg = "./images/starfield.jpg";

    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        Planet[] planets = new Planet[num];

        double radius = in.readDouble();

        int i = 0;
        while(i < num && !in.isEmpty()){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();

            planets[i] = new Planet(xP, yP, xV, yV, mass, img);
            i++;
        }

        return planets;
    }

    public static void main(String[] args){

        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0,0, backgroundImg);

        for(Planet p : planets){
            p.draw();
        }

        StdDraw.enableDoubleBuffering();

        double time = 0;

        while(time < T){
            double[] xForce = new double[planets.length];
            double[] yForce = new double[planets.length];

            for(int i = 0; i < planets.length; i++){
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForce[i], yForce[i]);
            }

            StdDraw.picture(0,0, backgroundImg);

            for(Planet p : planets){
                p.draw();
            }

            StdDraw.show();

            StdDraw.pause(10);

            time += dt;
        }

    }
}
