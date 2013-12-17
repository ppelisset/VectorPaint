package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import fr.iutinfo.model.Rectangle;
import fr.iutinfo.model.Vector;

public class RectangleView implements Printable {
	private Rectangle _rectangle;
	private Polygon _view;
	
	public RectangleView(Rectangle rect) {
		_rectangle = rect;
	}
	
	@Override
	public void paint(SceneView v, Graphics g) {
		calcPolygone(v);
		g.setColor(_rectangle.getColor());
		if(_rectangle.isFill()) {
			g.fillPolygon(_view);
		} else {
			g.drawPolygon(_view);
		}
	}
	
	private void calcPolygone(SceneView v) {
		Vector v1 = _rectangle.getVector1(), v2 = _rectangle.getVector2();
		_view = new java.awt.Polygon();
		int x1, y1, x2, y2, x3, y3, x4, y4;
		x1 = (int) ((v1.getLeftDistance()*v.getWidth())/100);
		y1 = (int) ((v1.getTopDistance()*v.getHeight())/100);
		
		_view.addPoint(x1, y1);
		
		x2 = (int) ((v1.getEndLeftDistance()*v.getWidth())/100);
		y2 = (int) ((v1.getEndTopDistance()*v.getHeight())/100);
		_view.addPoint(x2, y2);
		
		x3 = (int) ((v2.getEndLeftDistance()*v.getWidth())/100);
		y3 = (int) ((v2.getEndTopDistance()*v.getHeight())/100);
		_view.addPoint(x3, y3);
		
		x4 = x1 + (x3 - x2);
		y4 = y1 + (y3 - y2);
		_view.addPoint(x4, y4);
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		calcPolygone(v);
		return _view.contains(x, y);
	}

	@Override
	public int getNbPoint() {
		// TODO Auto-generated method stub
		return _view.npoints;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		return _view.xpoints;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		return _view.ypoints;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int diffX, diffY, min = scene.ERROR_MARGE*2+1, nbMin = -1;
		for(int i = 0; i < _view.npoints; i++) {
			diffX = Math.abs(_view.xpoints[i]-x);
			diffY = Math.abs(_view.ypoints[i]-y);
			System.out.println("diffX : " + diffX + " diffY : " + diffY);
			if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE && diffX+diffY < min) {
				min = diffX+diffY;
				nbMin = i;
			}
		}
		if(nbMin == -1) return null;
		else return new Point(_view.xpoints[nbMin], _view.ypoints[nbMin]);
	}

}
