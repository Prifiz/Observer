package observer.observers;

import gui.PaintPane;
import observer.Observer;
import model.drawing.Mouth;
import model.drawing.Smile;

public class MouthEmotionInverter implements Observer {

    private PaintPane paintPane;

    public MouthEmotionInverter(PaintPane paintPane) {
        this.paintPane = paintPane;
        paintPane.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, Smile smile) {
        if (isMouthSpotted(x, y, smile)) {
            smile.changeMouthEmotion();
            paintPane.repaint();
        }
    }

    private boolean isMouthSpotted(int x, int y, Smile smile) {
        Mouth mouth = smile.getMouth();
        return  x > mouth.getX() &&
                x < mouth.getX() + mouth.getWidth() &&
                y > mouth.getY() &&
                y < mouth.getY() + mouth.getHeight();
    }
}
