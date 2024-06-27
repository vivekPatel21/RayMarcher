import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class March implements Drawable {
    private Point2D start;
    private Point2D end;
    private double angle;


    public March(double x1, double y1, double x2, double y2) {
        this.start = new Point2D.Double(x1,y1);
        this.end = new Point2D.Double(x2,y2);
    }



    public Point2D getStart() {
        return start;
    }

    public Point2D getEnd() {
        return end;
    }
    public double getAngle(){
        return angle;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }

    public void drawObject(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
        int radius = (int)start.distance (end) ;
        int x = (int) (start.getX() - radius);
        int y = (int) (start.getY() - radius);
        g2d.setColor(Color.RED);
        g2d.drawOval(x, y, radius * 2, radius * 2);
//             while (radius > 0.1) {
//
//            if (end.getX() > 1280 || end.getY() > 640) {
//                break;
//            }
//
//            radius = start.distance(end);
//        }
    }
}
