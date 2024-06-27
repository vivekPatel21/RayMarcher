import java.awt.*;

public abstract class CollisionObject implements Drawable {
    protected double centerX;
    protected double centerY;
    protected Color color;

    public CollisionObject(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void drawObject(Graphics2D g2d){
        g2d.translate(centerX, centerY);
        g2d.setColor(color);
        // draw object with the set color
        g2d.fillRect(0, 0, 50, 50);
        g2d.translate(-centerX, -centerY);
    }

    public abstract double computeDistance(double cameraX, double cameraY);
}
