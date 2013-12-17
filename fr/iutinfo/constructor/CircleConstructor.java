package fr.iutinfo.constructor;

import java.awt.Graphics;

import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Figure;
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

				_circle = new Circle(new Vector(_leftDistance, _topDistance,
						leftDistance, topDistance), new Vector(
						(int) ((double) _leftDistance + (double) leftDistance
								/ (double) 2),
						(int) ((double) _topDistance - (double) topDistance
								/ (double) 2), (int) ((double) _topDistance - (double) topDistance
										/ (double) 2), (int) ((double) _leftDistance + (double) leftDistance
										/ (double) 2)));
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
			g.drawLine(x, y, mousePosX, mousePosY);
			g.drawOval(x, y, mousePosX - x, mousePosX - x);
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
