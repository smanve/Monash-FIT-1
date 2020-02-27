import java.awt.*;

public class TestStdDraw {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        char currC;

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                currC = StdDraw.nextKeyTyped();
                //System.out.println(StdDraw.nextKeyTyped());
                if (currC == 'd') {
                    //doDrawing();
                    DoingIt d = new DoingIt();
                    d.drawIt();
                }
                else if (currC == 'c') {
                    //System.exit(0);
                    StdDraw.clear(Color.white);
                    StdDraw.show();
                }
                else if (currC == 'x') {
                    //System.out.printf("Bye!");
                    System.exit(0);
                    break;
                }
            }

//            if (StdDraw.mousePressed())
//                System.out.printf("Click");
        }
    }
}
