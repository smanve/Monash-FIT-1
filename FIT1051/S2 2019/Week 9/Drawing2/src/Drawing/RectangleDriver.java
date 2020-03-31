package Drawing;

import java.awt.*;

/**
 * Created by shuxford
 */
public class RectangleDriver {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(0.1, 0.2, 0.3, 0.4, Color.green, 0.01);
        System.out.println(r.toString());

        System.out.println("perimeter: " + r.calculatePerimeter());
        System.out.println("area: " + r.calculateArea());
        System.out.println("");

        r.setColour(Color.blue);
        System.out.println(r.toString());
    }
}
