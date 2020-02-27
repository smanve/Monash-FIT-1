package Drawing;

import java.awt.*;
import java.lang.reflect.Field;

public class Rectangle {

    //INSTANCE VARIABLES ========================
    private double centreX;
    private double centreY;
    private double height;
    private double width;
    private Color colour;
    private double borderWidth;

    //CONSTRUCTORS
    public Rectangle() {


        setBorderWidth(0.002);

    }

    public Rectangle(double initX, double initY, double initWidth, double initHeight, Color newColour, double newBorderWidth) {
        setWidth(initWidth);
        setHeight(initHeight);
        setCentreX(initX);
        setCentreY(initY);
        setColour(newColour);
        setBorderWidth(newBorderWidth);
    }

    //ACCESSORS =================================
    public double getCentreX() {
        return centreX;
    }

    public double getCentreY() {
        return centreY;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Color getColour() {
        return colour;
    }

    public double getBorderWidth() {
        return borderWidth;
    }


    //MUTATORS ==================================
    public void setCentreX(double newX){
        if ((newX <= 1.00) && (newX > 0)) {
            centreX = newX;
        }
    }

    public void setCentreY(double newY) {
        if ((newY <= 1.00) && (newY > 0)) {
            centreY = newY;
        }
    }

    public void setHeight(double newHeight) {
        if (newHeight > 0 && newHeight < 1.00)
            height = newHeight;
    }

    public void setWidth(double newWidth) {
        if (newWidth > 0 && newWidth < 1.00)
            width = newWidth;
    }

    public void setColour(int r, int  g, int b, int alpha){
        colour = new Color(r, g, b, alpha);
    }

    public void setColour(Color colourName){
        colour = colourName;
    }

    public void setBorderWidth(double newBorderWidth) {
        borderWidth = newBorderWidth;
    }

    //OTHER METHODS
    public String toString(){
        String retVal = "";

        retVal += "X Centre Point: " + centreX + "\n";
        retVal += "Y Centre Point: " + centreY + "\n";
        retVal += "Height: " + height + "\n";
        retVal += "Width: " + width + "\n";
        if (colour != null)
            retVal += colorAsString(colour) + "\n";
        return retVal;
    }

    public double calculateArea() {
        double area;

        area = height * width;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter;

        perimeter = 2 * (height + width);
        return perimeter;
    }

    private String colorAsString(Color c){
        final int INT_RANGE = 255; //float range is [0, 1] int range is [0, 255]
        String retVal ="";
        float[] components = c.getComponents(null);

        retVal += "Red: " + (int)(components[0] * INT_RANGE);
        retVal += " Green: " + (int)(components[1] * INT_RANGE);
        retVal += " Blue: " + (int)(components[2] * INT_RANGE);
        retVal += " Alpha: " + (int)(components[3] * INT_RANGE);

        return retVal;
    }

}

