package etchASketch;

import ch.aplu.turtle.Turtle;

import javax.swing.*;

/**
 * Created by shuxford on 16/01/2016.
 */
public class TDraw {
    //drawing canvas is 800 X 800, origin is central
    //x ranges from -400 -> + 400, -400 is left edge of the canvas
    //y ranges from -400 -> + 400, -400 is bottom edge of the canvas
    final int MAX_X = 400;
    final int MAX_Y = 400;

    Turtle t;   //can move a specified distance in a specified direction
                //can tell us its current position and direction
                //can draw its trail while moving (pen down) or not (pen up)
                //trail width and colour can be specified
    JTextField in, out;

    public void drawIt(Turtle turtle, JTextField inTxt, JTextField outTxt){
        t = turtle;
        in = inTxt;
        out = outTxt;

//        etchASketch();
        superEtchASketch();

    }

    private void etchASketch() {
        boolean okToProcess = true;
        String message = "";
        int colourInt;

        String input = in.getText();
        String direction = input.substring(0, 1);
        String distance = input.substring(1);

        double distanceAsDouble = 0;



        if (direction.equals("n"))
            t.heading(0);
        else if (direction.equals("e"))
            t.heading(90);
        else if (direction.equals("s"))
            t.heading(180);
        else if (direction.equals("w"))
            t.heading(270);
        else {
            okToProcess = false;
            message += "bad direction: " + direction + " ";
        }


        if (isNumeric(distance)) {
            distanceAsDouble = Double.parseDouble(distance);
        }
        else{
            okToProcess = false;
            message += "bad distance: " + distance;
        }

        if (okToProcess) {
            if (!EtchASketchClipped(t, distanceAsDouble)) {
                t.setLineWidth(3);

                //get a random colour from 10 colours evenly spread
                //through the visible spectrum
                colourInt = (int) (1 + Math.floor(Math.random() * 10));
                t.setPenColor(Spectrum.getSpectrumColourFromScaledValue(colourInt, 10));

                t.penDown();
                t.forward(distanceAsDouble); //in current direction
                t.penUp();
                message += "In bounds";
            } else
                message += "Out of bounds";
        }

        out.setText(message);

    }

    //modify the etch-a-sketch code in the following method
    //to make a super etch-a-sketch
    private void superEtchASketch(){
        boolean okToProcess = true;
        String message = "";
        int colourInt;
        String direction = null;
        String distance = null;

        String input = in.getText();
        if (isNumeric(input.substring(1))) {
            direction = input.substring(0, 1);
            distance = input.substring(1);
        } else if (isNumeric(input.substring(2))) {
            direction = input.substring(0, 2);
            distance = input.substring(2);
        }

        double distanceAsDouble = 0;



        if (direction.equals("n"))
            t.heading(0);
        else if (direction.equals("e"))
            t.heading(90);
        else if (direction.equals("s"))
            t.heading(180);
        else if (direction.equals("w"))
            t.heading(270);
        else if (direction.equals("nw"))
            t.heading(315);
        else if (direction.equals("ne"))
            t.heading(45);
        else if (direction.equals("se"))
            t.heading(135);
        else if (direction.equals("sw"))
            t.heading(225);
        else {
            okToProcess = false;
            message += "bad direction: " + direction + " ";
        }


        if (isNumeric(distance)) {
            distanceAsDouble = Double.parseDouble(distance);
        }
        else{
            okToProcess = false;
            message += "bad distance: " + distance;
        }

        if (okToProcess) {
            if (!EtchASketchClipped(t, distanceAsDouble)) {
                t.setLineWidth(3);

                //get a random colour from 10 colours evenly spread
                //through the visible spectrum
                colourInt = (int) (1 + Math.floor(Math.random() * 10));
                t.setPenColor(Spectrum.getSpectrumColourFromScaledValue(colourInt, 10));

                t.penDown();
                t.forward(distanceAsDouble); //in current direction
                t.penUp();
                message += "In bounds";
            } else
                message += "Out of bounds";
        }

        out.setText(message);
    }

    private boolean EtchASketchClipped(Turtle t, double distance){
        boolean clipped = false;
        boolean xBad = false, yBad = false;
        double saveX, saveY, saveHeading;

        //do the move
        t.penUp();
        t.forward(distance);

        if (t.getX() < -MAX_X || t.getX() > MAX_X)
            xBad = true;
        if (t.getY() < -MAX_Y || t.getY() > MAX_Y)
            yBad = true;

        if (xBad || yBad)
            clipped = true;

        //clip or no clip undo the move - inefficient
        t.back(distance);
        t.penDown();

        return clipped;
    }


    //UTILITIES ========================================================================================================
    private boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");  //returns true for any decimal number including with a leading minus
    }

}












