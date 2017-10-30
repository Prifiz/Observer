import observer.Observable;
import observer.observers.EyesChanger;
import observer.observers.MouthChanger;
import observer.observers.NoseChanger;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> EventQueue.invokeLater(() -> {
                JFrame frame = new JFrame("Observer Lab");
                final boolean ENABLE_CONSTRUCTOR = false;
                final int SIZE = 500;
                Observable pane = ObservableFactory.getObservable(ENABLE_CONSTRUCTOR, SIZE, SIZE);
                new EyesChanger(pane);
                new NoseChanger(pane);
                new MouthChanger(pane);
                frame.getContentPane().add((Component) pane);
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
