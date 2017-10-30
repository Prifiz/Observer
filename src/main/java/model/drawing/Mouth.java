package model.drawing;

public class Mouth {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean happy;

    public String getImagePath() {
        return imagePath;
    }

    private String imagePath;

    public Mouth(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.happy = true;
    }

    public void changeHappiness() {
        this.happy = !this.happy;
    }

    public Mouth setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHappy() {
        return happy;
    }
}
