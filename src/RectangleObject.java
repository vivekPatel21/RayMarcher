import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class RectangleObject extends CollisionObject{
    private double height;
    private double width;
    private Color color;

    public RectangleObject(double centerX, double centerY, double height, double width){
        super(centerX, centerY);
        this.height = height;
        this.width = width;
        Random rand = new Random();
        int red = rand.nextInt(256);
        int blue = rand.nextInt(256);
        int green = rand.nextInt(256);
        this.color = new Color(red, green, blue);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        Rectangle rect = new Rectangle((int) (centerX - width/2), (int) (centerY - height/2), (int) width, (int) height);
        g2d.draw(rect);
        g2d.setColor(color);
        int width = (int) Math.round(this.getWidth());
        int height = (int) Math.round(this.getHeight());
        int x = (int) Math.round(this.centerX);
        int y = (int) Math.round(this.centerY);
        g2d.fillRect((int) (x - width/2), (int) (y - height/2), width, height);
    }

    public double computeDistance(double cameraX, double cameraY) {
        double centerX = this.centerX;
        double centerY = this.centerY;
        double halfWidth = this.width/2;
        double halfHeight = this.height/2;
        Line2D[] lines = {
                new Line2D.Double(centerX - halfWidth, centerY - halfHeight, centerX + halfWidth, centerY - halfHeight),
                new Line2D.Double(centerX + halfWidth, centerY - halfHeight, centerX + halfWidth, centerY + halfHeight),
                new Line2D.Double(centerX + halfWidth, centerY + halfHeight, centerX - halfWidth, centerY + halfHeight),
                new Line2D.Double(centerX - halfWidth, centerY + halfHeight, centerX - halfWidth, centerY - halfHeight)
        };

        double minDistance = Double.POSITIVE_INFINITY;

        for (Line2D line : lines) {
            double distance = line.ptSegDist(cameraX, cameraY);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        return minDistance;
    }
}
