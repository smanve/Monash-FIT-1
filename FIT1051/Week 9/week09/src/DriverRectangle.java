/**
 * Created by shuxford
 */
public class DriverRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2;

        r2 = new Rectangle();

        r1.setHeight(2); r1.setWidth(4);
        r2.setHeight(5); r2.setWidth(5);

        //System.out.println("r1 dimensions are " + r1.getHeight() + " X " + r1.getWidth());
        System.out.println("r1 dimensions are " + r1.toString());
        System.out.println("r1 has area " + r1.calculateArea() + " and perimeter " + r1.calculatePerimeter());

        System.out.println("\n\n");

        //System.out.println("r2 dimensions are " + r2.getHeight() + " X " + r2.getWidth());
        System.out.println("r2 dimensions are " + r2.toString());
        System.out.println("r2 has area " + r2.calculateArea() + " and perimeter " + r2.calculatePerimeter());
    }
}

