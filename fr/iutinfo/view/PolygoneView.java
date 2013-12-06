package fr.iutinfo.view;

import java.awt.Graphics;
import java.util.ArrayList;

import fr.iutinfo.model.Polygon;
import fr.iutinfo.model.Vector;

/**
 * Classe d'affichage d'un polygone
 * @author pierre
 *
 */
public class PolygoneView implements Printable {
	private Polygon _polygon;

	public PolygoneView(Polygon p) {
		_polygon = p;
	}

	@Override
	public void paint(SceneView v, Graphics g) {
		System.out.println("Affichage du polygone");
		ArrayList<Vector> list = _polygon.getVectors();
		java.awt.Polygon p = new java.awt.Polygon();
		int x, y;
		Vector vec = list.get(0);
		x = (int) ((vec.getLeftDistance()*v.getWidth())/100);
		y = (int) ((vec.getTopDistance()*v.getHeight())/100);
		
		p.addPoint(x, y);
		System.out.println("Point("+x+","+y+")");
		for(Vector vector : list) {
			x = (int) ((vector.getEndLeftDistance()*v.getWidth())/100);
			y = (int) ((vector.getEndTopDistance()*v.getHeight())/100);
			p.addPoint(x, y);
			System.out.println("Point("+x+","+y+")");
		}
		g.setColor(_polygon.getColor());
		if(_polygon.isFill()) {
			g.fillPolygon(p);
		} else {
			g.drawPolygon(p);
		}
	}

}
