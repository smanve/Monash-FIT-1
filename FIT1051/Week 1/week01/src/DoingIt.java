/**
 * Created by shuxford on 25/12/2015.
 */
public class DoingIt {
    Window myWindow;

    public void doIt(Window win){
        myWindow = win;

        String name = "", outString = "";

        name = myWindow.readIn();
        outString = "Hello " + name + ", \nthe FIT1051 teaching team look forward to introducing you to " +
                "\nthe most popular programming language in the world. JAVA!!!";

        myWindow.clearOut();
        myWindow.writeOut(outString);
        myWindow.clearIn();

    }



    // =========================================================================
    // UTILITIES ===============================================================
    // =========================================================================
    private static boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

}
