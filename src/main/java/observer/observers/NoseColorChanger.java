package observer.observers;

import gui.PaintPane;
import observer.Observer;
import model.drawing.Nose;
import model.drawing.Smile;

public class NoseColorChanger implements Observer {

    private PaintPane paintPane;

    public NoseColorChanger(PaintPane paintPane) {
        this.paintPane = paintPane;
        paintPane.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, Smile smile) {
        if (isNoseSpotted(x, y, smile)) {
            smile.changeNoseColor();
            paintPane.repaint();// может прямо тут задать координаты носа?
        }
    }

    public boolean isNoseSpotted(int x, int y, Smile smile) {
        Nose nose = smile.getNose();
        return  x > nose.getX() &&
                x < nose.getX() + nose.getWidth() &&
                y > nose.getY() &&
                y < nose.getY() + nose.getHeight();
    }
}
