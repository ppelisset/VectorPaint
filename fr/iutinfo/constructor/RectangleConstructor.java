package fr.iutinfo.constructor;

import java.awt.Graphics;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Rectangle;
import fr.iutinfo.model.Vector;
import fr.iutinfo.view.SceneView;

public class RectangleConstructor implements Constructor {

	private double _topDistance, _leftDistance;
	private boolean _isFirst = true;
	private Rectangle _rectangle;

	@Override
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException {
		if (_isFirst) {
			_topDistance = topDistance;
			_leftDistance = leftDistance;
			_isFirst = false;
			return false;
		} else {
			try {
				double bTopDistance, bLeftDistance, eTopDistance, eLeftDistance;
				if(topDistance > _topDistance) {
					bTopDistance = _topDistance;
					eTopDistance = topDistance;
				} else {
					bTopDistance = topDistance;
					eTopDistance = _topDistance;
				}
				if(leftDistance > _leftDistance) {
					bLeftDistance = _leftDistance;
					eLeftDistance = leftDistance;
				} else {
					bLeftDistance = leftDistance;
					eLeftDistance = _leftDistance;
				}
				
				_rectangle = new Rectangle(new Vector(bTopDistance, bLeftDistance, eTopDistance, eLeftDistance));
				return true;
			} catch (Exception e) {
				throw new ConstructorException(e.getMessage());
			}
		}
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		g.setColor(v.getColor());
		if (!_isFirst) {
			int x,y, ex, ey, bx, by;
			x = (int) ((_leftDistance * v.getWidth()) / 100);
			y = (int) ((_topDistance * v.getHeight()) / 100);
			if(mousePosX < x) {
				bx = mousePosX;
				ex = x;
			} else {
				bx = x;
				ex = mousePosX;
			}
			
			if(mousePosY > y) {
				ey = mousePosY;
				by = y;
			} else {
				ey = y;
				by = mousePosY;
			}
			g.fillRect(bx, by, ex-bx, ey-by);
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
	}

	@Override
	public boolean isBegin() {
		// TODO Auto-generated method stub
		return !_isFirst;
	}

}
