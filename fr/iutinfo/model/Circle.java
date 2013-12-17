package fr.iutinfo.model;

/**
 * Classe repr�sentant un cercle
 * @author pierre
 * TODO A recoder compl�tement
 */
public class Circle extends Figure {
	private Vector _height;
	private Vector _width;
	
	/**
	 * Crée un cercle avec deux vecteurs or not
	 * @param height
	 * @param width
	 */
	public Circle(Vector height, Vector width) {
		_height = height;
		_width = width;
		notifyObs(this);
	}
	public Circle(Vector height) {
		_height = height;
		notifyObs(this);
	}

	public Vector getHeight() {
		return _height;
	}

	public void setHeight(Vector height) {
		this._height = height;
	}

	public Vector getWidth() {
		return _width;
	}

	public void setWidth(Vector _width) {
		this._width = _width;
	}

	@Override
	public void move(int direction, double speed) {
		Vector v = _height;
		switch(direction) {
		case GO_UP:
			v.setTopDistance(v.getTopDistance()-speed);
			v.setEndTopDistance(v.getEndTopDistance()-speed);
			break;
		case GO_DOWN:
			v.setTopDistance(v.getTopDistance()+speed);
			v.setEndTopDistance(v.getEndTopDistance()+speed);
			break;
		case GO_LEFT:
			v.setLeftDistance(v.getLeftDistance()-speed);
			v.setEndLeftDistance(v.getEndLeftDistance()-speed);
			break;
		case GO_RIGHT:
			v.setLeftDistance(v.getLeftDistance()+speed);
			v.setEndLeftDistance(v.getEndLeftDistance()+speed);
			break;
		}
		notifyObs(this);
		
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		double diffX, diffY;
		boolean beginResize = false, endResize = false;
		if(!beginResize) {
			diffX = Math.abs(_height.getLeftDistance() - originLeft);
			diffY = Math.abs(_height.getTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_height.setLeftDistance(endLeft);
				_height.setTopDistance(endTop);
			}
			beginResize = true;
		}

		if(!endResize) {
			diffX = Math.abs(_height.getEndLeftDistance() - originLeft);
			diffY = Math.abs(_height.getEndTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_height.setEndLeftDistance(endLeft);
				_height.setEndTopDistance(endTop);
			}
			endResize = true;
		}
		notifyObs(this);
		
	}
}
