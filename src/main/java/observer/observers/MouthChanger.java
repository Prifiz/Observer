package observer.observers;

import model.AbstractSmile;
import observer.Observable;
import observer.Observer;
import model.drawing.Mouth;

public class MouthChanger implements Observer {

    private Observable observable;

    public MouthChanger(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, AbstractSmile smile) {
        if (isMouthSpotted(x, y, smile)) {
            smile.changeMouth();
        }
    }

    private boolean isMouthSpotted(int x, int y, AbstractSmile smile) {
        Mouth mouth = smile.getMouth();
        return  x > mouth.getX() &&
                x < mouth.getX() + mouth.getWidth() &&
                y > mouth.getY() &&
                y < mouth.getY() + mouth.getHeight();
    }
}
