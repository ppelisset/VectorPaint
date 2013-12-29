package fr.iutinfo.model;

public class Rectangle extends Figure {

	private Vector _vector;

	public Rectangle(Vector v) {
		this._vector = v;
		notifyObs(this);
	}

	public Vector getVector() {
		return _vector;
	}

	public void setVector(Vector v) {
		this._vector = v;
	}

	@Override
	public void move(int direction, double speed) {
		switch(direction) {
			case GO_UP:
				_vector.setTopDistance(_vector.getTopDistance()-speed);
				_vector.setEndTopDistance(_vector.getEndTopDistance()-speed);
				break;
			case GO_DOWN:
				_vector.setTopDistance(_vector.getTopDistance()+speed);
				_vector.setEndTopDistance(_vector.getEndTopDistance()+speed);
				break;
			case GO_LEFT:
				_vector.setLeftDistance(_vector.getLeftDistance()-speed);
				_vector.setEndLeftDistance(_vector.getEndLeftDistance()-speed);
				break;
			case GO_RIGHT:
				_vector.setLeftDistance(_vector.getLeftDistance()+speed);
				_vector.setEndLeftDistance(_vector.getEndLeftDistance()+speed);
				break;
		}
		notifyObs(this);
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		if(Math.abs(originTop-_vector.getTopDistance()) < Math.abs(originTop-_vector.getEndTopDistance()) && Math.abs(originTop-_vector.getTopDistance()) < Rectangle.ERROR_MARGE) {
			_vector.setTopDistance(endTop);
		} else if(Math.abs(originTop-_vector.getEndTopDistance())  < Rectangle.ERROR_MARGE) {
			_vector.setEndTopDistance(endTop);
		}
		if(Math.abs(originLeft-_vector.getLeftDistance()) < Math.abs(originLeft-_vector.getEndLeftDistance()) && Math.abs(originLeft-_vector.getLeftDistance()) < Rectangle.ERROR_MARGE) {
			_vector.setLeftDistance(endLeft);
		} else if(Math.abs(originLeft-_vector.getEndLeftDistance()) < Rectangle.ERROR_MARGE) {
			_vector.setEndLeftDistance(endLeft);
		}
		if(_vector.getEndLeftDistance()-_vector.getLeftDistance() < 1 || _vector.getEndTopDistance()-_vector.getTopDistance() < 1) {
			double tmp;
			if(this._vector.getTopDistance() > this._vector.getEndTopDistance()) {
				tmp = _vector.getTopDistance();
				_vector.setTopDistance(_vector.getEndTopDistance());
				_vector.setEndTopDistance(tmp);
			}
			if(this._vector.getLeftDistance() > this._vector.getEndLeftDistance()) {
				tmp = _vector.getLeftDistance();
				_vector.setLeftDistance(_vector.getEndLeftDistance());
				_vector.setEndLeftDistance(tmp);
			}
		}
		notifyObs(this); 
	}
	
	public String toString() {
		return "Vector : " + this._vector;
	}
	
	@Override
	public Rectangle clone() {
		Rectangle copy;
		copy = (Rectangle) super.clone();
		if(copy == null) return copy;
		copy._vector = this._vector.clone();
		return copy;
	}

}
