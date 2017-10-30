package gui;

import java.awt.*;

public class Utils {
    public static Color pickupDifferentRandomColor(Color currentColor) {
        Color pickedColor = pickupRandomColor();
        while (pickedColor == currentColor) {
            pickedColor = pickupRandomColor();
        }
        return pickedColor;
    }

    private static Color pickupRandomColor() {
        return new Color((int)(Math.random() * 0x1000000));
    }
}
