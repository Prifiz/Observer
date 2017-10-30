package observer;

public class Smile {

    private static final int X = 30;
    private static final int Y = 30;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private Eye leftEye;
    private Eye rightEye;
    private Nose nose;
    private Mouth mouth;

    public Smile() {
        leftEye = new Eye(110, 110, 80);
        rightEye = new Eye(370, 110, 80);
        nose = new Nose(200, 230, 160, 80);
        mouth = new Mouth(150, 340, 180, 80);
    }

    public void changeEyesState() {
        leftEye.blink();
        rightEye.blink();
    }

    public void changeNoseColor() {
        nose.setColor(Utils.pickupDifferentRandomColor(nose.getColor()));
    }

    public void changeMouthEmotion() {
        mouth.changeHappiness();
    }

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public Eye getLeftEye() {
        return leftEye;
    }

    public Eye getRightEye() {
        return rightEye;
    }

    public Nose getNose() {
        return nose;
    }

    public Mouth getMouth() {
        return mouth;
    }
}
