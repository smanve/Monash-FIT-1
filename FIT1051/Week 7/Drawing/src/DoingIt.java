import java.awt.*;

/**
 * Created by shuxford on 18/02/2016.
 */
public class DoingIt {

    public void drawIt(){
        //origin is bottom left hand corner, canvas is 1.0 X 1.0

        //yourDrawing(); //your drawing code in this method
        lotsOfCircles();
        //lotsOfLines(1); //0 random, 1 vertical, 2 horizontal
        //circlesInCircles1(4); //number of circles across and down
        //circlesInCircles2();
        //drunkardsWalk(10); //delay time in milliseconds
        //interaction();
    }
    private void yourDrawing(){
        //your drawing code here
        final int FRAME_TIME = 50; //milliseconds
        final int NUMBER_OF_CIRCLES = 20;
        double x, y, r;
        Color c;

        //StdDraw.filledCircle(trX(0.5), trY(0.5), 0.1); //test

        //StdDraw.show(0);
        for (int i = 1; i <= NUMBER_OF_CIRCLES; i++) {
            x = Math.random();
            y = Math.random();
            //System.out.println(x + ", " + y);
            r = 0.05 + 0.2 * Math.random(); //radii from 1/20 to 1/5 of canvas width

            if (x + r < 1.0 && x - r > 0.0 && y + r < 1.0 && y - r > 0.0){
                c = Spectrum.getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * NUMBER_OF_CIRCLES), NUMBER_OF_CIRCLES);
                c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 0.6F);
                StdDraw.setPenColor(c);

                //StdDraw.circle(x, y, r); //alternative
                StdDraw.filledCircle(x, y, r);
                StdDraw.show(FRAME_TIME);
            }
        }
    }

    private void lotsOfCircles(){
        final int FRAME_TIME = 50; //milliseconds
        final int NUMBER_OF_CIRCLES = 200;
        double x, y, r;
        Color c;

        //StdDraw.filledCircle(trX(0.5), trY(0.5), 0.1); //test

        //StdDraw.show(0);
        for (int i = 1; i <= NUMBER_OF_CIRCLES; i++) {
            x = Math.random();
            y = Math.random();
            //System.out.println(x + ", " + y);
            r = 0.05 + 0.2 * Math.random(); //radii from 1/20 to 1/5 of canvas width

            if (x + r < 1.0 && x - r > 0.0 && y + r < 1.0 && y - r > 0.0){
                c = Spectrum.getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * NUMBER_OF_CIRCLES), NUMBER_OF_CIRCLES);
                c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 0.6F);
                StdDraw.setPenColor(c);

                //StdDraw.circle(x, y, r); //alternative
                StdDraw.filledCircle(x, y, r);
                StdDraw.show(FRAME_TIME);
            }
        }
    }

    private void lotsOfLines(int direction){
        final int FRAME_TIME = 50; //milliseconds
        final int NUMBER_OF_LINES = 100;
        double x1, x2, y1, y2;
        double length;
        int lineCount = 0;
        Color c;

        StdDraw.show(0);
        while (lineCount < NUMBER_OF_LINES){
            x1 = Math.random();
            x2 = Math.random();
            y1 = Math.random();
            y2 = Math.random();

            if (direction == 1) //vertical
                x2 = x1;
            else if (direction == 2) //horizontal
                y2 = y1;

            length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (length > 0.1){
                c = Spectrum.getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * NUMBER_OF_LINES), NUMBER_OF_LINES);
                c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 0.9F);
                StdDraw.setPenColor(c);

                StdDraw.setPenRadius(0.002 + Math.random() * 0.01);

                StdDraw.line(x1, y1, x2, y2);
                lineCount++;
            }
            StdDraw.show(FRAME_TIME);
        }
    }

    private void circlesInCircles1(int numberOfCircles){
        //tute/lab question reverse the order of display from columns first to rows first
        final int FRAME_TIME = 100; //milliseconds
        final double MAX_X = 1.0; final double MAX_Y = 1.0;
        final int NUMBER_OF_CIRCLES = numberOfCircles;

        final Color TRANS_RED = new Color(1.0f, 0.0f, 0.0f, 0.4f);
        final Color TRANS_GREEN = new Color(0.0f, 1.0f, 0.0f, 0.4f);
        final Color TRANS_BLUE = new Color(0.0f, 0.0f, 1.0f, 0.4f);

        double currX, currY;
        float shade;
        //double cellDimension = MAX_X * 2.0 / NUMBER_OF_CIRCLES;
        double cellDimension = MAX_X / NUMBER_OF_CIRCLES;

        //currX = -MAX_X - cellDimension * 0.5;
        //currY = MAX_Y + cellDimension * 0.5;
        currX = -cellDimension * 0.5;
        currY = -cellDimension * 0.5;

        StdDraw.show(0);
        for (int i = 0; i <= NUMBER_OF_CIRCLES - 1; i++){
            currX += cellDimension;
            currY = - cellDimension * 0.5;
            for(int j = 0; j <= NUMBER_OF_CIRCLES - 1; j++) {
                currY += cellDimension;

                //System.out.println(currX);
                shade = 1.0f;
                for (int k = 1; k < 10; k++) {
                    StdDraw.setPenColor(new Color(0.0f, k * 0.1f, shade - k * 0.1f, 1.0f));
                    StdDraw.filledCircle(currX, currY, (cellDimension - (cellDimension * 0.1 * k)) / 2.0);
                }
            }
            StdDraw.show(FRAME_TIME);
        }
    }

    private void circlesInCircles2(){
        final int FRAME_TIME = 20; //milliseconds
        final int NUMBER_OF_CIRCLES = 100;
        double x, y, r;
        Color c;

        x = 0.5; y = 0.5; r = 0.5;
        StdDraw.show(0);
        for (int i = 1; i <= NUMBER_OF_CIRCLES; i++) {
            r -= 0.5 / (NUMBER_OF_CIRCLES - 1);

            c = Spectrum.getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * NUMBER_OF_CIRCLES), NUMBER_OF_CIRCLES);
            c = new Color((float) (c.getRed() / 255.0), (float) (c.getGreen() / 255.0), (float) (c.getBlue() / 255.0), 0.4F);
            StdDraw.setPenColor(c);

            //StdDraw.circle(x, y, r); //alternative
            StdDraw.filledCircle(x, y, r);
            StdDraw.show(FRAME_TIME);
        }
    }

    private void drunkardsWalk(int delay){
        final Color TRANS_RED = new Color(1.0f, 0.0f, 0.0f, 0.4f);
        final Color TRANS_GREEN = new Color(0.0f, 1.0f, 0.0f, 0.4f);
        final Color TRANS_BLUE = new Color(0.0f, 0.0f, 1.0f, 0.4f);

        StdDraw.clear(Color.black);

        drinkLotsThenWalk(TRANS_RED, 0.025, 1000, delay);
        drinkLotsThenWalk(TRANS_GREEN, 0.05, 500, delay);
        drinkLotsThenWalk(TRANS_BLUE, 0.1, 250, delay);
    }

    private void drinkLotsThenWalk(Color col, double stepLength, int numberOfSteps, int waiting){
        final int FRAME_TIME = waiting; //milliseconds
        double currX, currY;
        double newX, newY;

        StdDraw.setPenColor(col);
        StdDraw.setPenRadius(0.002);

        currX = 0.5; currY = 0.5;

        //StdDraw.show(0);
        for (int i = 1; i <= numberOfSteps; i++) {
            //System.out.println(i);
            int direction = (int) (1 + Math.floor(Math.random() * 4.0));

            if (direction == 1) { //north
                newY = currY + stepLength;
                if (newY < 1.0) {
                    StdDraw.line(currX, currY, currX, newY);
                    currY = newY;
                }
            }
            else if (direction == 2) { //east
                newX = currX + stepLength;
                if (newX < 1.0) {
                    StdDraw.line(currX, currY, newX, currY);
                    currX = newX;
                }
            }
            else if (direction == 3){ //south
                newY = currY - stepLength;
                if (newY > 0.0) {
                    StdDraw.line(currX, currY, currX, newY);
                    currY = newY;
                }
            }
            else if (direction == 4) { //west
                newX = currX - stepLength;
                if (newX > 0.0) {
                    StdDraw.line(currX, currY, newX, currY);
                    currX = newX;
                }
            }
            StdDraw.show(FRAME_TIME);
        }
    }

    private void interaction(){
        /******************************************************************************
         *  Compilation:  javac SimpleAttractors.java
         *  Execution:    java SimpleAttractors N
         *  Dependencies: StdDraw.java
         *
         *  N particles are attracted to the mouse; randomly rearrange when
         *  user clicks.
         *
         *  % java SimpleAttractors 20
         *
         *  Credits:  Jeff Traer-Bernstein
         *
         ******************************************************************************/
        int N = 10;
        double[] rx = new double[N];
        double[] ry = new double[N];
        double[] vx = new double[N];
        double[] vy = new double[N];
        double dt = 0.5;
        double mass = 1.0;
        double drag = 0.05;     // try changing this to 0.1 or 0.01 or even 0...
        double attractionStrength = 0.01;

        // initialize the drawing area
        StdDraw.setPenColor(StdDraw.BLUE);

        // do the animation
        while (true) {
            // if the mouse is pressed add some random velocity to all the particles
            if (StdDraw.mousePressed()) {
                for (int i = 0; i < N; i++) {
                    vx[i] = .2 * Math.random() - .1;
                    vy[i] = .2 * Math.random() - .1;
                }
            }

            // clear all the forces
            double[] fx = new double[N];
            double[] fy = new double[N];

            // add attraction forces for attraction to the mouse
            for (int i = 0; i < N; i++) {
                double dx = StdDraw.mouseX() - rx[i];
                double dy = StdDraw.mouseY() - ry[i];
                fx[i] += attractionStrength * dx;
                fy[i] += attractionStrength * dy;
            }

            // add drag forces to all particles
            // drag is proportional to velocity in the opposite direction
            for (int i = 0; i < N; i++) {
                fx[i] += -drag * vx[i];
                fy[i] += -drag * vy[i];
            }

            // update positions
            // euler step
            for (int i = 0; i < N; i++) {
                vx[i] += fx[i] * dt / mass;
                vy[i] += fy[i] * dt / mass;
                rx[i] += vx[i] * dt;
                ry[i] += vy[i] * dt;
            }


            StdDraw.clear();

            // draw a filled circle for each particle
            for (int i = 0; i < N; i++) {
                StdDraw.filledCircle(rx[i], ry[i], .01);
            }

            StdDraw.show(10);
        }
    }

}
