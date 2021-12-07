package polygon;

import java.awt.Point;
import java.util.List;

/**
 * Created by Niklas on 2016-02-28.
 */
class ScaledPolygon extends AbstractPolygon implements IPolygon {
	private final AbstractPolygon base;
	double xFactor, yFactor;

	ScaledPolygon(AbstractPolygon base, double xFactor, double yFactor) {
		this.base = base;
		this.xFactor = xFactor;
		this.yFactor = yFactor;
	}

	@Override
	public IPolygon translate(int x, int y) {
		return null;
	}

	@Override
	public IPolygon rotate(double radians) {
		return null;
	}

	@Override
	public IPolygon scale(double x, double y) {
		return null;
	}

	@Override
	protected void manipulatePoint(Point center, Point point) {
		double newX = (point.x - center.x) * this.xFactor + center.x;
		double newY = (point.y - center.y) * this.yFactor + center.y;
		point.x = (int) newX;
		point.y = (int) newY;
	}

	@Override
	public List<Point> getPoints() {
		return getPointsWithBase(this.base);
	}

	@Override
	public Point getCenterPoint() {
		return this.base.getCenterPoint();
	}
}
