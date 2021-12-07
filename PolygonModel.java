import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import polygon.IPolygon;

/**
 * Created by Niklas on 2016-02-21.
 */
public class PolygonModel extends JComponent {
    private final ArrayList<IPolygon> polygons = new ArrayList<>();

    private boolean direction = true;
    private int ticker = 0;

    public void addPolygon(IPolygon p){
        this.polygons.add(p);
    }

    @Override
	public void paint(Graphics g) {
        for (IPolygon polygon : this.polygons) {
            polygon.paint(g);
        }
    }

    public void translate(int x, int y){
        for (IPolygon p: this.polygons){
            p.translate(x,y);
        }

    }
    public void update(){
        this.ticker++;
        int value = this.direction ? 10 : -10;
        translate(value, value);
        notifyListeners();
        if (this.ticker > 10) {
            this.direction = !this.direction;
            this.ticker = 0;
        }
    }

    private void notifyListeners(){
        for (AnimateListener l : this.listeners) {
			l.actOnUpdate();
		}
    }

    public void animate(){
        try {
            while (true) {
                Thread.sleep(500);
                update();
            }
        } catch (InterruptedException e) {}
    }

    private final List<AnimateListener> listeners = new ArrayList<>();
    public void addListener(AnimateListener l){
        this.listeners.add(l);
    }

}

