package observer;


import model.AbstractSmile;

public interface Observer {
    void handleEvent(int x, int y, AbstractSmile smile);
}
