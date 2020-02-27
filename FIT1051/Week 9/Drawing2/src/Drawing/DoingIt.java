package Drawing;

import java.awt.*;

public class DoingIt {
    private final int NUMBER_OF_RECTANGLES = 9; //square root must be an integer for uniformRectangles to execute

    Rectangle[] rectangles = new Rectangle[NUMBER_OF_RECTANGLES];

    //constructor ensures there is something to draw immediately after instantiation
    public DoingIt() {
        makeRandomRectangles();
    drawIt();
    }

    //draw all rectangle instances currently in the array rectangles
    public void drawIt() {
        //origin is bottom left hand corner, canvas is 1.0 X 1.0
        final int FRAME_TIME = 50; //milliseconds
        Rectangle r;

        if (rectangles[0] != null) {
            for (int i = 0; i < rectangles.length; i++) {
                r = rectangles[i];

                //extract all drawing data from a rectangle instance and draw it
                StdDraw.setPenRadius(r.getBorderWidth());
                StdDraw.setPenColor(r.getColour());
                StdDraw.rectangle(r.getCentreX(), r.getCentreY(), r.getWidth() * 0.5, r.getHeight() * 0.5);
                //StdDraw.filledRectangle(r.getCentreX(), r.getCentreY(), r.getWidth() * 0.5, r.getHeight() * 0.5); //alternative
                StdDraw.show(FRAME_TIME);
            }
        }
    }

    //populate the array rectangles with rectangles with a randomly generated state
    public void makeRandomRectangles() {
        double x, y, width, height;
        double leftEdge, rightEdge, topEdge, bottomEdge;
        double penRadius;
        Color c;
        int numberOfRectangles;

        numberOfRectangles = 0;
        while (numberOfRectangles < NUMBER_OF_RECTANGLES) {
            x = Math.random();
            y = Math.random();

            width = 0.05 + 0.4 * Math.random(); //from 1/20 to 4/5 of canvas width
            height = 0.05 + 0.4 * Math.random(); //ditto for height

            leftEdge = x - 0.5 * width;
            rightEdge = x + 0.5 * width;
            topEdge = y + 0.5 * height;
            bottomEdge = y - 0.5 * height;

            //ensure rectangle is completely within the drawing canvas
            if (leftEdge > 0.0 && rightEdge < 1.0 && topEdge < 1.0 && bottomEdge > 0.0) {
                //System.out.println(String.format("%f + \t\t + %f + \t\t + %f + \t\t + %f", leftEdge, rightEdge, topEdge, bottomEdge));
                c = Spectrum.getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * NUMBER_OF_RECTANGLES), NUMBER_OF_RECTANGLES);
                c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 0.6F);

                penRadius = 0.002 * (1 + (int) (Math.random() * 10)); //0.002 is the default pen radius

                rectangles[numberOfRectangles] = new Rectangle(x, y, width, height, c, penRadius);
                numberOfRectangles++;

            }
        }
    }

    public void makeUniformRectangles(){
        final int N = NUMBER_OF_RECTANGLES; //need short name
        double x, y;
        int rNum;
        Rectangle r;
        Color c;
        double width, height;
        double sqrtN, cell;
        int sqrtNInt;
        double penRadius = 0.01;

        sqrtN = Math.sqrt(N);
        sqrtNInt = (int) sqrtN;
        if (sqrtN != sqrtNInt){
            return;
        }

        cell = 1.0 / sqrtN; //floating point division
        x = -cell * 0.5; y = 1 + cell * 0.5;

        width = height = cell * 0.95;
        rNum = 1;
        for (int yI = sqrtNInt; yI >= 1; yI--){
            y -= cell;
            x = -cell * 0.5;
            for (int xI = 1; xI <= sqrtNInt; xI++){
                c = Spectrum.getSpectrumColourFromScaledValue(rNum, NUMBER_OF_RECTANGLES);
                c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 1.0F);
                x += cell;

                rectangles[rNum - 1] = new Rectangle(x, y, width, height, c, penRadius);

                rNum++;
            }
        }
    }

    //example processing of the array rectangles
    public void fadeAway() {
        final int FADE_STEP = 20;
        Rectangle r;
        int red, green, blue, alpha;
        Color currentColour, newColour;

        StdDraw.clear();

        for (int i = 0; i < rectangles.length; i++) {
            r = rectangles[i];
            currentColour = rectangles[i].getColour();

            red = currentColour.getRed();
            green = currentColour.getGreen();
            blue = currentColour.getBlue();
            alpha = currentColour.getAlpha();

            if (alpha - FADE_STEP >= 0)
                alpha = alpha - FADE_STEP;
            else
                alpha = 0;

            r.setColour(red, green, blue, alpha);
        }
    }

    //example processing of the array rectangles
    public void concentric() {
        final double SHRINK_FACTOR = 0.8;
        final double BORDER_SHRINK_FACTOR = 0.8;
        final double DEFAULT_PEN_RADIUS = 0.002;

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i].setWidth(rectangles[i].getWidth() * SHRINK_FACTOR);
            rectangles[i].setHeight(rectangles[i].getHeight() * SHRINK_FACTOR);
            if (rectangles[i].getBorderWidth() > DEFAULT_PEN_RADIUS)
                rectangles[i].setBorderWidth(rectangles[i].getBorderWidth() * BORDER_SHRINK_FACTOR);
        }
    }

    public void yourOperation() {
        //code for your rectangle operation here
    }
}
