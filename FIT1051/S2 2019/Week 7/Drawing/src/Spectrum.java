import ch.aplu.turtle.X11Color;

import java.awt.*;

/**
 * Created by shuxford on 4/11/2015.
 */
public class Spectrum {

    //returns a colour in the visible spectrum
    //the colour is value/range along the spectrum from its red end
    //value/range wraps so 1/10 =  11/10 = 21/10 etc
    //see below for some typical calls
    public static Color getSpectrumColourFromScaledValue(double value, double range){
        final int START_VISIBLE = 410, END_VISIBLE = 720, VISIBLE_RANGE = END_VISIBLE - START_VISIBLE;

        Color retVal;
        int wavelength;
        double normalisedValue;

        if (value == 0)
            normalisedValue = 0;
        else if (value % range == 0)
            normalisedValue = 1;
        else
            normalisedValue = (value % range) / range;

        wavelength = (int)(END_VISIBLE - normalisedValue * VISIBLE_RANGE);

        retVal = X11Color.wavelengthToColor(wavelength);

        return retVal;
    }
}

//TYPICAL CALLS
//getSpectrumColourFromScaledValue(i, 10) //in a for loop where i: 1 .. 10
//will return 10 colours evenly distributed throughout the visible spectrum

//getSpectrumColourFromScaledValue(i, 10) //in a for loop where i: 1 .. 100
//will return 10 colours evenly distributed throughout the visible spectrum, the same colours will be returned 10 times

//getSpectrumColourFromScaledValue(1 + Math.floor(Math.random() * 10), 10) //in a for loop where i: 1 .. 10
//will return 1 randomly selected colour from a palette of 10 colours evenly distributed throughout the visible spectrum

