package gui;

import model.AbstractSmile;
import model.drawing.Eye;
import model.drawing.Mouth;
import model.drawing.Nose;
import observer.Observable;
import observer.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageMerger extends JPanel implements Observable {

    private List<Observer> observers;
    private AbstractSmile smile;
    private int x;
    private int y;

    public ImageMerger(AbstractSmile smile) {
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(smile.getWIDTH(), smile.getHEIGHT());
    }

    @Override
    public void paintComponent(Graphics g) {
        drawSmile(g);
    }

    private void drawSmile(Graphics g) {
        List<Eye> eyes = smile.getEyes();
        eyes.forEach(eye -> {
            String imagePath = "not defined";
            try {
                imagePath = eye.getImagePath();
                BufferedImage eyeImage = ImageIO.read(new File(imagePath));
                eyeImage = Utils.resize(eyeImage, eye.getWidth(), eye.getHeight());
                g.drawImage(eyeImage, smile.getX(), smile.getY(), this);
                Nose nose = smile.getNose();
                imagePath = nose.getImagePath();
                BufferedImage noseImage = Utils.resize(
                        ImageIO.read(new File(imagePath)), nose.getWidth(), nose.getHeight());
                g.drawImage(noseImage, smile.getX(), smile.getY() + smile.getHEIGHT() / 3, this);
                Mouth mouth = smile.getMouth();
                imagePath = mouth.getImagePath();
                BufferedImage mouthImage = Utils.resize(
                        ImageIO.read(new File(imagePath)), mouth.getWidth(), mouth.getHeight());
                g.drawImage(mouthImage, smile.getX(), smile.getY() + 2 * smile.getHEIGHT() / 3, this);
            } catch (IOException e) {
                System.out.println("Failed to read image: " + imagePath);
                System.out.println(e.getMessage());
            }
        });

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
