package fr.iutinfo.constructor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Polygon;
import fr.iutinfo.model.Vector;
import fr.iutinfo.model.VectorLine;
import fr.iutinfo.view.SceneView;
import fr.iutinfo.view.VectorView;

/**
 * Constructeur de Polygone
 * @see Constructor
 * @author pierre
 */
public class PolygonConstructor implements Constructor {
	private boolean _isBegin = false;
	private static Color _currentColor= Color.BLACK;
	private Polygon _polygon = new Polygon();
	private double _topDistance, _leftDistance;
	private double _beginTopDistance, _beginLeftDistance;
	
	
	@Override
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException {
		if(!_isBegin) {
			_beginTopDistance = _topDistance = topDistance;
			_beginLeftDistance = _leftDistance = leftDistance;
			_isBegin = true;
			return false;
		} else {
			double diffX = Math.abs(_beginLeftDistance - leftDistance);
			double diffY = Math.abs(_beginTopDistance - topDistance);
			if(diffX <= 1 && diffY <= 1) {
				topDistance = _beginTopDistance;
				leftDistance = _beginLeftDistance;
			}
			try {
				_polygon.addVector(new Vector(_topDistance, _leftDistance, topDistance, leftDistance));
			} catch (Exception e) {
				System.err.println("Erreur du systeme de vecteur : " + e.getMessage());
			}
			_topDistance = topDistance;
			_leftDistance = leftDistance;
			if(_polygon.isFinish()) {
				_polygon.setColor(_currentColor);
				return true;
			}
			return false;
		}
		
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		if(_isBegin) {
			ArrayList<Vector> list = _polygon.getVectors();
			
			for(Vector vec : list) {
				VectorLine tmp = new VectorLine(vec);
				 tmp.setColor(v.getColor());
				(new VectorView(tmp)).paint(v, g);
			}
			
			int x, y;
			x = (int) ((_leftDistance*v.getWidth())/100);
			y = (int) ((_topDistance*v.getHeight())/100);
			g.setColor(v.getColor());
			g.drawLine(x, y, mousePosX, mousePosY);
		}
	}

	@Override
	public Figure getFigure() {
		return _polygon;
	}

	@Override
	public void reinit() {
		_polygon = new Polygon();
		_isBegin = false;
		_topDistance = 0;
		_leftDistance = 0;
	}

	@Override
	public boolean isBegin() {
		return _isBegin;
	}
}
