/**
 * Created by shuxford
 */
public class Driver3Rectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2, r3, r4;

        r2 = new Rectangle(5, 20);
        r3 = new Rectangle(10);

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());

        r4 = r2; //now r2 reference the same object as r4
        System.out.println(r4.toString());

    }

}

