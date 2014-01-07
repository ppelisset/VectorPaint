package fr.iutinfo.constructor;

import java.awt.Graphics;

import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Point;
import fr.iutinfo.view.SceneView;

/**
 * Classe de gestion de la construction d'un cercle
 */
public class CircleConstructor implements Constructor {
	private double _topDistance, _leftDistance;
	private boolean _isFirst = true;
	private Circle _circle;
	private SceneView _v;
	
	@Override
	public boolean addPoint(double topDistance, double leftDistance)
			throws ConstructorException {
		if (_isFirst) {
			_topDistance = topDistance;
			_leftDistance = leftDistance;
			_isFirst = false;
			return false;
		} else {
			try {
				double sizeX = Math.abs(leftDistance - _leftDistance);
				double sizeY = Math.abs(topDistance - _topDistance);
				_circle = new Circle(new Point(_topDistance, _leftDistance), sizeX, sizeY);
				return true;
			} catch (Exception e) {
				throw new ConstructorException(e.getMessage());
			}
		}
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		_v = v;
		if (!_isFirst) {
			int x, y;
			x = (int) ((_leftDistance * v.getWidth()) / 100);
			y = (int) ((_topDistance * v.getHeight()) / 100);
			int hypo = pythagore(x-mousePosX,y-mousePosY);
			g.setColor(v.getColor());
			g.fillOval(x-hypo, y-hypo, hypo*2, hypo*2);
		}
	}
	
	public int pythagore(int a, int b) {
		return (int) (double) Math.sqrt(a*a+b*b);
	}
	
	@Override
	public Figure getFigure() {
		return _circle;
	}

	@Override
	public void reinit() {
		_isFirst = true;
	}

	@Override
	public boolean isBegin() {
		return !_isFirst;
	}
}
