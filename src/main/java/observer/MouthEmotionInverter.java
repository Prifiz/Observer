package observer;

import gui.PaintPane;

public class MouthEmotionInverter implements Observer {

    private PaintPane paintPane;

    public MouthEmotionInverter(PaintPane paintPane) {
        this.paintPane = paintPane;
        paintPane.addObserver(this);
    }

    @Override
    public void handleEvent(int x, int y, Smile smile) {

    }
}
