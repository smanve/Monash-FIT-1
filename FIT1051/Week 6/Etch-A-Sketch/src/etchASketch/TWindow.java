package etchASketch;

/**
 * Created by shuxford
 */

import ch.aplu.turtle.Turtle;
import ch.aplu.turtle.TurtleFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.BorderFactory.createCompoundBorder;


public class TWindow extends TurtleFrame {

    //constructor
    public TWindow(String title, JMenuBar menuBar, int pgWidth, int pgHeight) {
        super(title, menuBar, pgWidth, pgHeight);

        TurtleFrame saveThis = this;

        Border buttonPanelBorder;
        CompoundBorder textFieldBorder;

        textFieldBorder = createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.black, 2));
        buttonPanelBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);

        Turtle t;
        t = new Turtle(this); //TurtleFrame implement TurtleContainer
        t.hideTurtle();

        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));

        JTextField inTxt = new JTextField("in");
        inTxt.setMargin(new Insets(5, 5, 5, 5));
        JTextField outTxt = new JTextField("out");
        outTxt.setMargin(new Insets(5, 5, 5, 5));

        JButton doItBtn = new JButton("Do It!");
        JButton clearBtn = new JButton("Clear");

        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        menuBar.add(doItBtn);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        menuBar.add(clearBtn);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));

        menuBar.add(inTxt);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        menuBar.add(outTxt);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));


        TDraw d = new TDraw();
        doItBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TDraw d = new TDraw();
                d.drawIt(t, inTxt, outTxt);
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.getPlayground().clean();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //t.penUp();
                t.moveTo(t.toTurtleX(e.getX()), t.toTurtleY(e.getY()));

                inTxt.setText(t.getX() + " / " + t.getY());
                //inTxt.setText(e.getX() + " / " + e.getY());

            }
        });

    }

}

