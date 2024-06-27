import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class CircleObject extends CollisionObject {
    private double radius;
    private Color color;

    public CircleObject(double centerX, double centerY, double radius) {
        super(centerX, centerY);
        this.radius = radius;
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        this.color = new Color(red, green, blue);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double computeDistance(double cameraX, double cameraY) {
        double distance = Math.sqrt(Math.pow(cameraX - centerX, 2) + Math.pow(cameraY - centerY, 2));
        return distance - radius;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        int x = (int) Math.round(this.centerX - this.radius);
        int y = (int) Math.round(this.centerY - this.radius);
        int diameter = (int) Math.round(this.radius * 2);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.draw(ellipse);
        g2d.setColor(this.color);
        g2d.fill(ellipse);
    }
}
