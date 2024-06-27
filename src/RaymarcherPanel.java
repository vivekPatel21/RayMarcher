import java.awt.*;
// import java.awt.event.MouseEvent;
// import java.awt.event.MouseListener;
// import java.awt.geom.Ellipse2D;
// import java.awt.geom.Point2D;
import java.util.*;

import javax.swing.JPanel;

// import static java.awt.event.MouseEvent.*;

/**
 * Displays and updates the logic for the top-down raymarcher.
 */
public class RaymarcherPanel extends JPanel {

    /**
     * We need to keep a reference to the parent swing app for sizing and
     * other bookkeeping.
     */
    private final RaymarcherRunner raymarcherRunner;

    // something is wrong with the camera
    Camera camera = new Camera(100, 100);

    private static ArrayList<CollisionObject> objects = new ArrayList<>();

    public ArrayList<March> marches() {
        double x = camera.getX();
        double y = camera.getY();
        double angle = camera.getAngle();
        ArrayList<March> marches = new ArrayList<March>();
        while (x >= 0 && x <= this.getPreferredSize().width && y >= 0 && y <= this.getPreferredSize().height) {
            double closeDist = Double.MAX_VALUE;
            for (CollisionObject obj : objects) {
                double dist = obj.computeDistance(x, y);
                if (dist < closeDist) {
                    closeDist = dist;
                }
            }

            if (closeDist < 0.1) {
                break;
            }

            double newX = x + closeDist * Math.cos(angle);
            double newY = y + closeDist * Math.sin(angle);
            March march = new March(x, y, newX, newY);
            marches.add(march);
            x = newX;
            y = newY;
        }

        return marches;
    }

    public RaymarcherPanel(RaymarcherRunner raymarcherRunner) {

        this.raymarcherRunner = raymarcherRunner;
        this.setPreferredSize(new Dimension(this.raymarcherRunner.getFrame().getWidth(),
                this.raymarcherRunner.getFrame().getHeight()));

        // Initialize the Camera object
        // camera = new Camera(0, 0, 10);

        // Add mouse motion listener to the panel and pass the Camera object
        addMouseMotionListener(camera);
        addMouseListener(camera);

        Random rand = new Random();

        CircleObject circle1 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        CircleObject circle2 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        CircleObject circle3 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        CircleObject circle4 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        CircleObject circle5 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        CircleObject circle6 = new CircleObject(rand.nextDouble(1280), rand.nextDouble(640), rand.nextDouble(200));
        RectangleObject rectangle1 = new RectangleObject(rand.nextDouble(1280), rand.nextDouble(640),
                rand.nextDouble(200), rand.nextDouble(200));
        RectangleObject rectangle2 = new RectangleObject(rand.nextDouble(1280), rand.nextDouble(640),
                rand.nextDouble(201), rand.nextDouble(200));
        RectangleObject rectangle3 = new RectangleObject(rand.nextDouble(1280), rand.nextDouble(640),
                rand.nextDouble(204), rand.nextDouble(200));
        RectangleObject rectangle4 = new RectangleObject(rand.nextDouble(1280), rand.nextDouble(640),
                rand.nextDouble(205), rand.nextDouble(200));
        RectangleObject rectangle5 = new RectangleObject(rand.nextDouble(1280), rand.nextDouble(640),
                rand.nextDouble(207), rand.nextDouble(200));
        Triangle triangle = new Triangle(rand.nextDouble(1280),rand.nextDouble(640),rand.nextDouble(200));

        objects.add(circle1);
        objects.add(circle2);
        objects.add(circle3);
        objects.add(circle4);
        objects.add(circle5);
        objects.add(circle6);
        objects.add(rectangle1);
        objects.add(rectangle2);
        objects.add(rectangle3);
        objects.add(rectangle4);
        objects.add(rectangle5);
        objects.add(triangle);
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

        double minDist = Double.MAX_VALUE;

        for (CollisionObject obj : objects) {
            double dist = obj.computeDistance(camera.getX(), camera.getY());
            if (dist < minDist) {
                minDist = dist;
            }
        }

        camera.drawObject(g2d);

        // Compute the list of marches
        // ArrayList<March> marches = marches();

        // Draw each march
        ArrayList<March> marches = marches();
        for (March march : marches) {
            march.drawObject(g2d);
        }

        // Draw the objects and camera
        for (CollisionObject obj : objects) {
            obj.drawObject(g2d);
        }
        camera.drawObject(g2d);
        double x2 = camera.getX() + camera.getRadius() * Math.cos(camera.getAngle());
        double y2 = camera.getY() + camera.getRadius() * Math.sin(camera.getAngle());

        g2d.setColor(Color.red);
    }

}