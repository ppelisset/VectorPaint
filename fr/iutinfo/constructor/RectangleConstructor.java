package fr.iutinfo.constructor;

import java.awt.Graphics;
import java.awt.Polygon;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Rectangle;
import fr.iutinfo.model.Vector;
import fr.iutinfo.view.SceneView;

public class RectangleConstructor implements Constructor {

	private double _topDistance, _leftDistance;
	private double _topDistance1, _leftDistance1;
	private boolean _isFirst = true;
	private int _number = 0;
	private Rectangle _rectangle;

	@Override
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException {
		if (_isFirst) {
			_topDistance = topDistance;
			_leftDistance = leftDistance;
			_isFirst = false;
			_number++;
			return false;
		} else {
			if(_number == 1) {
				_topDistance1 = topDistance;
				_leftDistance1 = leftDistance;
				_number++;
				return false;
			} else {
				try {
					_rectangle = new Rectangle(new Vector(_topDistance, _leftDistance, _topDistance1, _leftDistance1), new Vector(_topDistance1, _leftDistance1, topDistance, leftDistance));
					return true;
				} catch (Exception e) {
					throw new ConstructorException(e.getMessage());
				}
			}
		}
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		g.setColor(v.getColor());
		if (!_isFirst) {
			if(_number == 2) {
				int x, y;
				Polygon p = new Polygon();
				x = (int) ((_leftDistance * v.getWidth()) / 100);
				y = (int) ((_topDistance * v.getHeight()) / 100);
				p.addPoint(x, y);
				x = (int) ((_leftDistance1 * v.getWidth()) / 100);
				y = (int) ((_topDistance1 * v.getHeight()) / 100);
				p.addPoint(x, y);
				p.addPoint(mousePosX, mousePosY);
				x = (int) ((_leftDistance * v.getWidth()) / 100);
				y = (int) ((_topDistance * v.getHeight()) / 100);
				p.addPoint(x, y);
				g.fillPolygon(p);
			} else {
				int x, y;
				x = (int) ((_leftDistance * v.getWidth()) / 100);
				y = (int) ((_topDistance * v.getHeight()) / 100);
				g.drawLine(x, y, mousePosX, mousePosY);
			}
		}
	}

	@Override
	public Figure getFigure() {
		// TODO Auto-generated method stub
		return _rectangle;
	}

	@Override
	public void reinit() {
		// TODO Auto-generated method stub
		_isFirst = true;
		_number = 0;
	}

	@Override
	public boolean isBegin() {
		// TODO Auto-generated method stub
		return !_isFirst;
	}

}
