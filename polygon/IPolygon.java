package polygon;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Created by Niklas on 2016-02-28.
 */
public interface IPolygon {
    IPolygon translate(int x, int y);
    IPolygon rotate(double radians);
    IPolygon scale(double x, double y);

    Point getCenterPoint();

    void paint(Graphics g);
}
