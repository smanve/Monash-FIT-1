/**
 * Created by shuxford
 */
public class Driver2Rectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();

        r1.setColour(0, 0, 255);
        //System.out.println(colorAsString(r1.getColour()));
        System.out.println(r1.toString()); //Color's toString does not return alpha !!! NOW IT DOES !!!

        r1.setColour(0, 0, 255, 128);
        //System.out.println(colorAsString(r1.getColour()));
        System.out.println(r1.toString());

        r1.setColour("cyan");
        //System.out.println(colorAsString(r1.getColour()));
        System.out.println(r1.toString());

        r1.setColour("a bit yellow");
        //System.out.println(colorAsString(r1.getColour()));
        System.out.println(r1.toString());

    }

    //this method now migrated to the Rectangle class to "help" its toString
//    private static String colorAsString(Color c){
//        final int INT_RANGE = 255; //float range is [0, 1] int range is [0, 255]
//        String retVal ="";
//        float[] components = c.getComponents(null);
//
//        retVal += "Red: " + (int)(components[0] * INT_RANGE);
//        retVal += " Green: " + (int)(components[1] * INT_RANGE);
//        retVal += " Blue: " + (int)(components[2] * INT_RANGE);
//        retVal += " Alpha: " + (int)(components[3] * INT_RANGE);
//
//        return retVal;
//    }
}

