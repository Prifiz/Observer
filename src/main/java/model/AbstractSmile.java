package model;

import model.drawing.Eye;
import model.drawing.Mouth;
import model.drawing.Nose;

import java.util.List;

public abstract class AbstractSmile {
    protected final int X = 0;
    protected final int Y = 0;
    protected final int WIDTH;
    protected final int HEIGHT;

    public AbstractSmile(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    protected List<Eye> eyes;
    protected Nose nose;
    protected Mouth mouth;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Nose getNose() {
        return nose;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public List<Eye> getEyes() {
        return eyes;
    }

    public abstract void changeEyes();
    public abstract void changeNose();
    public abstract void changeMouth();
}
