package gui;

import model.AbstractSmile;
import observer.*;
import model.drawing.Mouth;
import model.drawing.Nose;
import model.drawing.Smile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintPane extends JPanel implements Observable {

    private int x;
    private int y;
    private java.util.List<Observer> observers;
    private AbstractSmile smile;

    public PaintPane(AbstractSmile smile) {
        this.observers = new ArrayList<>();
        this.smile = smile;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                notifyObservers(x, y);
                repaint();
            }
        });
    }

    public void drawSmile(Graphics graphics) {

        final Color DEFAULT_COLOR = Color.BLACK;

        graphics.clearRect(smile.getX(), smile.getY(), smile.getWIDTH(), smile.getHEIGHT());

        graphics.drawOval(smile.getX(), smile.getY(), smile.getWIDTH(), smile.getHEIGHT());


        Nose nose = smile.getNose();
        graphics.setColor(nose.getColor());
        graphics.fillOval(nose.getX(), nose.getY(), nose.getWidth(), nose.getHeight());
        graphics.setColor(DEFAULT_COLOR);

        Mouth mouth = smile.getMouth();
        if(mouth.isHappy()) {
            graphics.drawArc(mouth.getX(), mouth.getY(), mouth.getWidth(), mouth.getHeight(), 180, 180);
        } else {
            graphics.drawArc(mouth.getX(), mouth.getY(), mouth.getWidth(), mouth.getHeight(), 0, 180);
        }

        final int SPOT_RATIO = 4;
        smile.getEyes().forEach(eye -> {
            graphics.drawOval(eye.getX(), eye.getY(), eye.getSize(), eye.getSize());
            if(eye.isOpen()) {
                int spotSize = eye.getSize() / SPOT_RATIO;
                int spotShift = (eye.getSize() - spotSize) / 2;
                graphics.fillOval(eye.getX() + spotShift, eye.getY() + spotShift, spotSize, spotSize);
            } else {
                int spotSize = eye.getSize() / SPOT_RATIO;
                int spotShift = (eye.getSize() - spotSize) / 2;
                graphics.clearRect(eye.getX() + spotShift, eye.getY() + spotShift, spotSize, spotSize);
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(smile.getWIDTH(), smile.getHEIGHT());
    }

    @Override
    public void paintComponent(Graphics g) {
        drawSmile(g);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int x, int y) {
        observers.forEach(observer -> observer.handleEvent(x, y, smile));
    }
}
