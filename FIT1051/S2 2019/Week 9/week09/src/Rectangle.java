/**
 * Created by shuxford
 */

import java.awt.*;
import java.lang.reflect.Field;

public class Rectangle {
    //INSTANCE VARIABLES ========================
    private int height;
    private int width;
    private Color colour;

    //CONSTRUCTORS
    public Rectangle(){
        setHeight(0);
        setWidth(0);
    }

    public Rectangle(int initHeight, int initWidth){
        setHeight(initHeight);
        setWidth(initWidth);
    }

    public Rectangle(int initDimension){
        setHeight(initDimension);
        setWidth(initDimension);
    }

    //ACCESSORS =================================
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColour(){
        return colour;
    }

    //MUTATORS ==================================
    public void setHeight(int newHeight) {
        if (newHeight > 0 && newHeight < 100)
            height = newHeight;
    }

    public void setWidth(int newWidth) {
        if (newWidth > 0 && newWidth < 100)
        width = newWidth;
    }

    public void setColour(int r, int  g, int b){
        colour = new Color(r, g, b);
    }

    public void setColour(int r, int  g, int b, int alpha){
        colour = new Color(r, g, b, alpha);
    }

    public void setColour(final String colourName){
        final Field f;

        try {
            f = Color.class.getField(colourName);
            colour = (Color) f.get(null);
        }
        catch (Exception e){
            colour = Color.black; //default
        }
    }

    //OTHER METHODS
    public int calculateArea(){
        int area;

        area = height * width;
        return area;
    }

    public int calculatePerimeter(){
        int perimeter;

        perimeter = 2 * (height + width);
        return perimeter;
    }

    public String toString(){
        String retVal = "";

        retVal += "Height: " + height;
        retVal += "\tWidth: " + width + "\n";
        if (colour != null)
            retVal += colorAsString(colour) + "\n";

        return retVal;
    }

    //the Color class's toString does not return the alpha component
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

