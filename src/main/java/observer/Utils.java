package observer;

import java.awt.*;

public class Utils {
    public static Color pickupDifferentRandomColor(Color currentColor) {
        Color pickedColor = new Color((int)(Math.random() * 0x1000000));
        if(pickedColor.equals(currentColor)) {
            pickupDifferentRandomColor(currentColor);
        }
        return pickedColor;
    }
}
