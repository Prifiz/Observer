package model.drawing;

public class Eye {

    private int x;
    private int y;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width;
    private int height;
    private boolean open;

    public String getImagePath() {
        return imagePath;
    }

    private String imagePath;

    public Eye(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;
        this.open = true;
    }

    public Eye(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.open = true;
    }

    public Eye setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        if(width == height) {
            return width;
        } else {
            throw new UnsupportedOperationException("Width & height are not equal!!!");
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void blink() {
        this.open = !this.open;
    }
}
