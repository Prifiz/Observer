import gui.PaintPane;
import observer.*;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> EventQueue.invokeLater(() -> {

                Smile smile = new Smile();

                JFrame frame = new JFrame("Observer Lab");
                PaintPane paintPane = new PaintPane(smile);
                new EyesBlinker(paintPane);
                new NoseColorChanger(paintPane);
                new MouthEmotionInverter(paintPane);
                frame.getContentPane().add(paintPane);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);

            }));
        } catch (InvocationTargetException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
