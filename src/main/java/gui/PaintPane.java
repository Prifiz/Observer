package gui;

import observer.*;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PaintPane extends JPanel implements Observable {

    private int x;
    private int y;
    private java.util.List<Observer> observers;
    private Smile smile;

    public PaintPane(Smile smile) {
        this.observers = new ArrayList<>();
        this.smile = smile;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                notifyObservers(x, y);
            }
        });
    }

    public void drawSmile(Graphics graphics) {
        graphics.drawOval(Smile.getX(), Smile.getY(), Smile.getWIDTH(), Smile.getHEIGHT());

        Eye leftEye = smile.getLeftEye();
        graphics.drawOval(leftEye.getX(), leftEye.getY(), leftEye.getSize(), leftEye.getSize());
        Eye rightEye = smile.getRightEye();
        graphics.drawOval(rightEye.getX(), rightEye.getY(), rightEye.getSize(), rightEye.getSize());

        final int SPOT_RATIO = 4;
        if(leftEye.isOpen()) {
            int spotSize = leftEye.getSize() / SPOT_RATIO;
            int spotShift = (leftEye.getSize() - spotSize) / 2;
            graphics.fillOval(leftEye.getX() + spotShift, leftEye.getY() + spotShift, spotSize, spotSize);
        }
        if(leftEye.isOpen()) {
            int spotSize = rightEye.getSize() / SPOT_RATIO;
            int spotShift = (rightEye.getSize() - spotSize) / 2;
            graphics.fillOval(rightEye.getX() + spotShift, rightEye.getY() + spotShift, spotSize, spotSize);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
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
