package observer.observers;

import model.AbstractSmile;
import observer.Observable;
import observer.Observer;
import model.drawing.Eye;

public class EyesChanger implements Observer {

    private Observable observable;

    public EyesChanger(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, AbstractSmile smile) {
        if(isAnyEyeSpotted(x, y, smile)) {
            smile.changeEyes();
        }
    }

    private boolean isAnyEyeSpotted(int x, int y, AbstractSmile smile) {
        for(Eye eye : smile.getEyes()) {
            if(isEyeSpotted(eye, x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEyeSpotted(Eye eye, int x, int y) {
        return x > eye.getX() &&
                x < eye.getX() + eye.getSize() &&
                y > eye.getY() &&
                y < eye.getY() + eye.getSize();
    }
}
