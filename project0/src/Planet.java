public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img ){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = Math.abs(xxPos - p.xxPos);
        double dy = Math.abs(yyPos - p.yyPos);
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return G * mass * p.mass / Math.pow(r, 2);
    }

    public double calcForceExertedByX(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dx = p.xxPos - xxPos;
        return F * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double F = calcForceExertedBy(p);
        double r = calcDistance(p);
        double dy = p.yyPos - yyPos;
        return F * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] pArr){
        if(pArr == null || pArr.length == 0){
            return 0.0;
        }
        double netForceX = 0.0;
        for(int i = 0; i < pArr.length; i++){
            if(!this.equals(pArr[i])){
                netForceX += calcForceExertedByX(pArr[i]);
            }
        }

        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] pArr){
        if(pArr == null || pArr.length == 0){
            return 0.0;
        }
        double netForceY = 0.0;
        for(int i = 0; i < pArr.length; i++){
            if(!this.equals(pArr[i])){
                netForceY += calcForceExertedByY(pArr[i]);
            }
        }

        return netForceY;
    }

    public void update(double duration, double forceX, double forceY){
        double aNetX = forceX / mass;
        double aNetY = forceY / mass;

        xxVel = xxVel + aNetX * duration;
        yyVel = yyVel + aNetY * duration;

        xxPos = xxPos + xxVel * duration;
        yyPos = yyPos + yyVel * duration;
    }

    public void draw(){
        String imgPath = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, imgPath);
    }

}
