import java.awt.*;
import java.util.Random;

public class Triangle extends CollisionObject {
    private double sideLength;

    public Triangle(double centerX, double centerY, double sideLength) {
        super(centerX, centerY);
        this.sideLength = sideLength;
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        this.color = new Color(red, green, blue);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.translate(centerX, centerY);
        g2d.setColor(color);
        // draw object with the set color
        int[] xPoints = {0, (int) (sideLength / 2), (int) sideLength};
        int[] yPoints = {(int) sideLength, 0, (int) sideLength};
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.translate(-centerX, -centerY);
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double dx = centerX - cameraX;
        double dy = centerY - cameraY;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
