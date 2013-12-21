package fr.iutinfo.constructor;

import java.awt.Graphics;

import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Point;
import fr.iutinfo.model.Vector;
import fr.iutinfo.view.SceneView;

public class CircleConstructor implements Constructor {
	private double _topDistance, _leftDistance;
	private boolean _isFirst = true;
	private Circle _circle;

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
				double size = Math.abs(leftDistance - _leftDistance);
				_circle = new Circle(new Point(_topDistance, _leftDistance), size);
				return true;
			} catch (Exception e) {
				throw new ConstructorException(e.getMessage());
			}
		}
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		if (!_isFirst) {
			int x, y;
			x = (int) ((_leftDistance * v.getWidth()) / 100);
			y = (int) ((_topDistance * v.getHeight()) / 100);
			int size = Math.abs(mousePosX - x);
			g.setColor(v.getColor());
			g.fillOval(x-size, y-size, size*2, size*2);
		}
	}

	@Override
	public Figure getFigure() {
		// TODO Auto-generated method stub
		return _circle;
	}

	@Override
	public void reinit() {
		// TODO Auto-generated method stub
		_isFirst = true;
	}

	@Override
	public boolean isBegin() {
		// TODO Auto-generated method stub
		return !_isFirst;
	}

}
