package gui;

import org.apache.commons.io.FileUtils;

import java.awt.image.BufferedImage;
import java.util.List;

import java.awt.*;
import java.io.File;
import java.util.Random;

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

    public static String getRandomImagePath(String dirName) {
        List<File> images = (List<File>) FileUtils.listFiles(
                new File("images", dirName), new String[]{"png"}, false);
        if(images.isEmpty()) {
            return "";
        } else {
            Random random = new Random();
            int idx = random.nextInt(images.size());
            return images.get(idx).getAbsolutePath();
        }
    }

    public static BufferedImage resize(BufferedImage image, int newWidth, int newHeight) {
        if(image == null) {
            return null;
        }
        int currentWidth = image.getWidth();
        int currentHeight = image.getHeight();
        BufferedImage result = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D graphics = result.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(
                image, 0, 0, newWidth, newHeight, 0, 0, currentWidth, currentHeight, null);
        graphics.dispose();
        return result;
    }
}
