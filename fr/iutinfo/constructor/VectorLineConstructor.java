package fr.iutinfo.constructor;

import java.awt.Graphics;
import java.awt.Point;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Vector;
import fr.iutinfo.model.VectorLine;
import fr.iutinfo.view.SceneView;

/**
 * Constructeur de ligne vectoriel
 * @see Constructor
 * @author pierre
 */
public class VectorLineConstructor implements Constructor {
	private double _topDistance, _leftDistance;
	private boolean _isFirst = true;
	private VectorLine _vector;
	
	@Override
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException {
		if(_isFirst) {
			_topDistance = topDistance;
			_leftDistance = leftDistance;
			_isFirst = false;
			return false;
		} else {
			try {
				
				_vector = new VectorLine(new Vector(_topDistance, _leftDistance, topDistance, leftDistance));
				_vector.setColor(PolygonConstructor.getColor());
				return true;
			} catch(Exception e) {
				throw new ConstructorException(e.getMessage());
			}
		}
	}

	@Override
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY) {
		if(!_isFirst) {
			int x, y;
			x = (int) ((_leftDistance*v.getWidth())/100);
			y = (int) ((_topDistance*v.getHeight())/100);
			g.drawLine(x, y, mousePosX, mousePosY);
			
		}
	}

	@Override
	public Figure getFigure() {
		return _vector;
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
