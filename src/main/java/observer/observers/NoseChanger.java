package observer.observers;

import model.AbstractSmile;
import observer.Observable;
import observer.Observer;
import model.drawing.Nose;

public class NoseChanger implements Observer {

    private Observable observable;

    public NoseChanger(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, AbstractSmile smile) {
        if (isNoseSpotted(x, y, smile)) {
            smile.changeNose();
        }
    }

    public boolean isNoseSpotted(int x, int y, AbstractSmile smile) {
        Nose nose = smile.getNose();
        return  x > nose.getX() &&
                x < nose.getX() + nose.getWidth() &&
                y > nose.getY() &&
                y < nose.getY() + nose.getHeight();
    }
}
