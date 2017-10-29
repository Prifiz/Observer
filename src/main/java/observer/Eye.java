package observer;

public class Eye {

    private int x;
    private int y;
    private int size;
    private boolean open;

    public Eye(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.open = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public boolean isOpen() {
        return open;
    }

    public void blink() {
        this.open = !this.open;
    }
}
