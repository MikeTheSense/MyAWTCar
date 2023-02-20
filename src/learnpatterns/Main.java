package learnpatterns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JComponent{

    public static void main(String[] args) {
        //var hui = new CrossRoadFacade();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CrossRoadFacade.createAndShowGui();
            }
        });
    }

}
