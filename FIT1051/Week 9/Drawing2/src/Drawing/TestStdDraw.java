package Drawing;

import java.awt.*;

public class TestStdDraw {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        DoingIt d = new DoingIt();
        StdDraw.getDoingItInstance(d); //so menu item clicks in StdDraw can callback methods in DoingIt
        char currC;

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                currC = StdDraw.nextKeyTyped();
                //System.out.println(StdDraw.nextKeyTyped());
                if (currC == 'd') {
                    //StdDraw.clear(Color.white);
                    //StdDraw.show();
                    d.drawIt();
                }
                else if (currC == 'c') {
                    StdDraw.clear(Color.white);
                    StdDraw.show();
                }
                else if (currC == 'x') {
                    System.exit(0);
                    break; //from infinite char detecting loop
                }
            }
        }
    }
}
