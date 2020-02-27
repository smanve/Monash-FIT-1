package etchASketch;

import java.awt.*;

public class Turtle {

    private double x;
    private double y;
    private double theta; //radians;


    public Turtle(){
        setX(0); setY(0);
        setTheta(0);
    }


    public double getX() {
        return x;
    }

    public void setX(double newX) {
        x = newX;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {
        y = newY;
    }

    public double getTheta() {
        return Math.toDegrees(theta);
    }

    public void setTheta(double newTheta) {
        theta = Math.toRadians(newTheta);
    }


    public boolean tryMove(double distance, int xMin, int yMin, int xMax, int yMax){
        double newX, newY;
        boolean xClip, yClip;

        newX = distance * Math.cos(theta);  //this ordinarily means +ve increases in theta product counterclockwise rotation but out Y axis is flipped 19=80 degress
        newY = distance * Math.sin(theta);  //as a result +ve increases in theta produce clockwise rotation

        xClip = newX < xMin || newX > xMax;
        yClip = newY < yMin || newY > yMax;

        return !xClip && !yClip;
    }


    public void draw(double distance, Graphics2D g){
        double newX, newY;

        newX = x + distance * Math.cos(theta);
        newY = y + distance * Math.sin(theta);

        g.drawLine((int)Math.round(x), (int) Math.round(y), (int) Math.round(newX), (int) Math.round(newY));

        setX(newX);
        setY(newY);

    }
}
