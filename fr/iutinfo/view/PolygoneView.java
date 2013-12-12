package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
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
	private java.awt.Polygon _view;

	public PolygoneView(Polygon p) {
		_polygon = p;
	}

	@Override
	public void paint(SceneView v, Graphics g) {
		calcPolygone(v);
		g.setColor(_polygon.getColor());
		if(_polygon.isFill()) {
			g.fillPolygon(_view);
		} else {
			g.drawPolygon(_view);
		}
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		calcPolygone(v);
		if(_view.contains(x, y)) {
			return true;
		} else {
			return false;
		}
	}

	private void calcPolygone(SceneView v) {
		ArrayList<Vector> list = _polygon.getVectors();
		_view = new java.awt.Polygon();
		int x, y;
		Vector vec = list.get(0);
		x = (int) ((vec.getLeftDistance()*v.getWidth())/100);
		y = (int) ((vec.getTopDistance()*v.getHeight())/100);
		
		_view.addPoint(x, y);
		for(Vector vector : list) {
			x = (int) ((vector.getEndLeftDistance()*v.getWidth())/100);
			y = (int) ((vector.getEndTopDistance()*v.getHeight())/100);
			_view.addPoint(x, y);
		}
	}

	@Override
	public int getNbPoint() {
		return _view.npoints;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		calcPolygone(v);
		return _view.xpoints;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		calcPolygone(v);
		return _view.ypoints;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int diffX, diffY, min = scene.ERROR_MARGE*2+1, nbMin = -1;
		for(int i = 0; i < _view.npoints; i++) {
			diffX = Math.abs(_view.xpoints[i]-x);
			diffY = Math.abs(_view.ypoints[i]-y);
			if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE && diffX+diffY < min) {
				min = diffX+diffY;
				nbMin = i;
			}
		}
		if(nbMin == -1) return null;
		else return new Point(_view.xpoints[nbMin], _view.ypoints[nbMin]);
	}
}
