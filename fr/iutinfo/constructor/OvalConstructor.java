package fr.iutinfo.constructor;

import java.awt.Graphics;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Oval;
import fr.iutinfo.model.Point;
import fr.iutinfo.view.SceneView;

public class OvalConstructor implements Constructor {
	private double _topDistance, _leftDistance;
	private boolean _isFirst = true;
	private Oval _oval;
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
				_oval = new Oval(new Point(_topDistance, _leftDistance), sizeX, sizeY);
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
			g.setColor(v.getColor());
			int sizeX = Math.abs(mousePosX - x);
			int sizeY = Math.abs(mousePosY - y);
			g.fillOval(x-sizeX, y-sizeY,sizeX*2, sizeY*2);
		}
	}
	
	@Override
	public Figure getFigure() {
		// TODO Auto-generated method stub
		return _oval;
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
