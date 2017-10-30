package observer;


import model.drawing.Smile;

public interface Observer {
    void handleEvent(int x, int y, Smile smile);
}
