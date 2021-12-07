package polygon;

import java.awt.Point;
import java.util.List;

/**
 * Created by Niklas on 2016-02-28.
 */
class TranslatedPolygon extends AbstractPolygon implements IPolygon {
	private final AbstractPolygon base;
	int xMove;
	int yMove;

	TranslatedPolygon(AbstractPolygon polygonToTranslate, int x, int y) {
		this.base = polygonToTranslate;
		this.xMove = x;
		this.yMove = y;
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
	public List<Point> getPoints() {
		// the points from base are already defensively copied
		return getPointsWithBase(this.base);
	}

	@Override
	protected void manipulatePoint(Point center, Point p) {
		p.x += this.xMove;
		p.y += this.yMove;
	}

	@Override
	public Point getCenterPoint() {
		// the centerpoint from base is already defensively copied
		Point baseCenter = this.base.getCenterPoint();
		baseCenter.x += this.xMove;
		baseCenter.y += this.yMove;
		return baseCenter;
	}
}
