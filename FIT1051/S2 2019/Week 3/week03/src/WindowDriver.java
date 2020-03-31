import javax.swing.*;
import java.awt.*;

/**
 * Created by shuxford on 24/12/2015.
 */
public class WindowDriver {
    protected static Window w;

    public static void main(String[] args){

        Font f = new Font("Arial", Font.PLAIN, 24);
        UIManager.put("TextArea.font", f);
        UIManager.put("Button.font", f);

        w = new Window();
        w.setLocationRelativeTo(null); //centre JFrame/Window on screen
        w.setVisible(true);



    }
}
