package model.drawing;

import gui.Utils;
import model.AbstractSmile;

import java.util.ArrayList;

public class Smile extends AbstractSmile {

    public Smile(int width, int height) {
        super(width, height);
        eyes = new ArrayList<>(2);
        eyes.add(new Eye(110, 110, 80));
        eyes.add(new Eye(370, 110, 80));
        nose = new Nose(200, 230, 160, 80);
        mouth = new Mouth(150, 340, 180, 80);
    }

    public void changeEyes() {
        eyes.forEach(Eye::blink);
    }

    public void changeNose() {
        nose.setColor(Utils.pickupDifferentRandomColor(nose.getColor()));
    }

    public void changeMouth() {
        mouth.changeHappiness();
    }
}
