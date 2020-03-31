package etchASketch;

import javax.swing.*;
import java.awt.*;

/**
 * Created by shuxford on 29/12/2015.
 */
public class TWindowDriver {

    public static void main(String[] args){
        TWindow w;

        Font f = new Font("Arial", Font.PLAIN, 24);
        UIManager.put("TextField.font", f);
        UIManager.put("Button.font", f);

        JMenuBar menuBar = new JMenuBar();
        //JButton doIt = new JButton("DoIt");

        w = new TWindow("It's Turtles All the Way Down", menuBar, 900, 900);
        //w.setSize(new Dimension(1000, 1000));

        //w.setLocationRelativeTo(null); //centre JFrame/Window on screen
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setResizable(false);

        w.setVisible(true);

    }
}
