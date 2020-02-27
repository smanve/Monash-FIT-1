package CardGames;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createCompoundBorder;

/**
 * Created by shuxford
 */
public class Window extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    //components
    private JTextArea inTextArea, outTextArea;
    private JScrollPane outScrollPane;
    private JButton inClearButton, outClearButton, outFontButton, doItButton;
    private JPanel topPanel, inPanel, outPanel,outButtonPanel, buttonPanel;
    private Border buttonBorder;
    private CompoundBorder textAreaBorder;

    public Window(){
        super("Text I/O Playground");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textAreaBorder = createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.black, 5));
        buttonBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        topPanel = new JPanel();
        setContentPane(topPanel);

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        inPanel = new JPanel();
        inPanel.setBorder(textAreaBorder);
        outPanel = new JPanel();
        outButtonPanel = new JPanel();
        outPanel.setBorder(textAreaBorder);
        buttonPanel = new JPanel();

        inPanel.setLayout(new BoxLayout(inPanel, BoxLayout.X_AXIS));
        outPanel.setLayout(new BoxLayout(outPanel, BoxLayout.X_AXIS));
        outButtonPanel.setLayout(new BoxLayout(outButtonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        //inPanel contents
        inTextArea = new JTextArea("In Area", 30, 10);
        inTextArea.setMargin(new Insets(5, 5, 5, 5));
        inTextArea.setTabSize(4);

        inClearButton = new JButton("Clear");
        inClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inTextArea.setText("");
            }
        });

        //outPanel contents
        outTextArea = new JTextArea("Out Area", 30, 10);
        outTextArea.setMargin(new Insets(5, 5, 5, 5));
        outTextArea.setEditable(false);
        outTextArea.setTabSize(4);
        outScrollPane = new JScrollPane(outTextArea);

        outClearButton = new JButton("Clear");
        outClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outTextArea.setText("");
            }
        });

        //buttonPanel contents
        outFontButton = new JButton("Font ");
        outFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font f;
                //clearOut();
                if (outTextArea.getFont().getName().equals("Arial"))
                    f = new Font("Courier New", Font.PLAIN, 24);
                else
                    f = new Font("Arial", Font.PLAIN, 24);

                outTextArea.setFont(f);
            }
        });
        //outFontButton.setBorder(buttonBorder);
        doItButton = new JButton("Do It!");
        doItButton.setBorder(buttonBorder);

        Window thisWindow = this; //inside the auto instantiated ActionListener object "this" will refer to the ActionListener object
        DoingIt doer = new DoingIt(); //efficient
        doItButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DoingIt doer = new DoingIt(); //inefficient
                doer.doIt(thisWindow);
            }
        });


        //assemble the components
        inPanel.add(inTextArea);
        inPanel.add(Box.createRigidArea(new Dimension(20,0)));
        inPanel.add(inClearButton);
        inPanel.add(Box.createRigidArea(new Dimension(20,0)));

        outPanel.add(outScrollPane);
        outPanel.add(Box.createRigidArea(new Dimension(20,0)));
        outButtonPanel.add(outClearButton);
        outButtonPanel.add(Box.createRigidArea(new Dimension(0,20)));
        outButtonPanel.add(outFontButton);
        outPanel.add(outButtonPanel);
        outPanel.add(Box.createRigidArea(new Dimension(20,0)));

        buttonPanel.add(doItButton);

        topPanel.add(inPanel);
        topPanel.add(outPanel);
        topPanel.add(buttonPanel);
        topPanel.add(Box.createRigidArea(new Dimension(0,20)));
    }


    //UTILITY METHODS IN
    private int currInTextIndex = 0;

    public void clearIn(){
        inTextArea.setText("");
        currInTextIndex = 0;
    }

    public String readIn(){
        return inTextArea.getText();
    }

    public String[] readInTokenised(){
        String[] retVal;
        String inText = inTextArea.getText();

        retVal = inText.split("\\s+"); //splits on contiguous white space characters

        return retVal;
    }

    public String readNextToken(){
        final String REGEX = "[ \\t\\n\\x0B\\f\\r]";

        String nextToken = "";
        int i;

        String inText = inTextArea.getText().trim(); //trailing spaces cause a crash in second while condition
        int inTextLength = inText.length();

        i = currInTextIndex;
        if (currInTextIndex == inTextLength)
            return null;
        while (inText.substring(i, i + 1).equals(" ") && i < inTextLength) {
            i++;
            if (i == inTextLength) //substring(i, i + 1) will cause a crash
                break;
        }


        while (!inText.substring(i, i + 1).equals(" ") && i < inTextLength){
            nextToken += inText.substring(i, i + 1);
            i++;
            if (i == inTextLength) //substring(i, i + 1) will cause a crash
                break;
        }

        currInTextIndex = i;

        return nextToken;
    }



    //UTILITY METHODS OUT
    public void clearOut(){
        outTextArea.setText("");
    }

    public void writeOut(Object s){
        outTextArea.append(s + ""); //quick and dirty String conversion by + ""
    }

    public void writeOutLine(Object s){
        outTextArea.append(s + "\n"); //quick and dirty String conversion by + "\n"
    }

    public void writeIn(String s){
        inTextArea.setText("");
        inTextArea.setText(s);
    }

}
