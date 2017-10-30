package model.constructor;

import gui.Utils;
import model.AbstractSmile;
import model.drawing.Eye;
import model.drawing.Mouth;
import model.drawing.Nose;

import java.util.ArrayList;

public class ConstructedSmile extends AbstractSmile {
    public ConstructedSmile(int width, int height) {
        super(width, height);
        eyes = new ArrayList<>(1);
        Eye eye = new Eye(getX(), getY(), getWIDTH(), getHEIGHT() / 3)
                .setImagePath(Utils.getRandomImagePath("eyes"));
        eyes.add(eye);
        nose = new Nose(getX(), getY() + getHEIGHT() / 3, getWIDTH(), getHEIGHT() / 3)
                .setImagePath(Utils.getRandomImagePath("noses"));
        mouth = new Mouth(getX(), getY() + 2 * getHEIGHT() / 3, getWIDTH(), getHEIGHT() / 3)
                .setImagePath(Utils.getRandomImagePath("mouths"));
    }

    @Override
    public void changeEyes() {
        eyes.forEach(eye -> eye.setImagePath(Utils.getRandomImagePath("eyes")));
    }

    @Override
    public void changeNose() {
        nose.setImagePath(Utils.getRandomImagePath("noses"));
    }

    @Override
    public void changeMouth() {
        mouth.setImagePath(Utils.getRandomImagePath("mouths"));
    }
}
