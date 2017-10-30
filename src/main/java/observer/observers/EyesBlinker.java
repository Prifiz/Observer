package observer.observers;

import gui.PaintPane;
import observer.Observer;
import model.drawing.Eye;
import model.drawing.Smile;

public class EyesBlinker implements Observer {

    private PaintPane paintPane;

    public EyesBlinker(PaintPane paintPane) {
        this.paintPane = paintPane;
        paintPane.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, Smile smile) {
        if(isAnyEyeSpotted(x, y, smile)) {
            smile.changeEyesState();
            paintPane.repaint();
        }
    }

    private boolean isAnyEyeSpotted(int x, int y, Smile smile) {
        Eye leftEye = smile.getLeftEye();
        Eye rightEye = smile.getRightEye();
        boolean leftEyeSpotted =
                        x > leftEye.getX() &&
                        x < leftEye.getX() + leftEye.getSize() &&
                        y > leftEye.getY() &&
                        y < leftEye.getY() + leftEye.getSize();
        boolean rightEyeSpotted =
                        x > rightEye.getX() &&
                        x < rightEye.getX() + rightEye.getSize() &&
                        y > rightEye.getY() &&
                        y < rightEye.getY() + rightEye.getSize();
        return leftEyeSpotted || rightEyeSpotted;
    }
}
