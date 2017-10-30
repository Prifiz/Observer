package gui;

import model.AbstractSmile;
import observer.Observable;
import observer.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ImageMerger implements Observable {

    private List<Observer> observers;
    private AbstractSmile smile;

    public ImageMerger(AbstractSmile smile) {
        this.observers = new ArrayList<>();
        this.smile = smile;
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(700, 700);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        drawSmile(g);
//    }

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
