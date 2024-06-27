import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Camera implements Drawable, MouseMotionListener, MouseListener {
    private int x;
    private int y;
    private int radius = 10;
    private double angle;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // maybe will be necessary
    public void rotate(int deltaAngle) {
        angle += deltaAngle;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // this works
        // setX(e.getX() - radius / 2);
        // setY(e.getY() - radius / 2);

        // u need to consider the offset of the camera
        Point p = e.getPoint();
        p.translate(-Panel.WIDTH / 2, -Panel.HEIGHT / 2);
        x = p.x;
        y = p.y;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    // public double getAngle(/**double x2, double y2*/) {
    // // double dx = x2 - x;
    // // double dy = y2 - y;
    // // double angle = Math.atan2(dy, dx);
    // return angle;
    // }

    @Override

    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();
        if (button == MouseEvent.BUTTON1) {
            angle += 1;
        } else if (button == MouseEvent.BUTTON3) {
            angle -= 1;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
