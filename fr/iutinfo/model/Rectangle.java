package fr.iutinfo.model;

public class Rectangle extends Figure {

	private Vector _vector1, _vector2;

	public Rectangle(Vector v1, Vector v2) {
		this._vector1 = v1;
		this._vector2 = v2;
		notifyObs(this);
	}

	public Vector getVector1() {
		return _vector1;
	}
	
	public Vector getVector2() {
		return _vector2;
	}

	public void setVector1(Vector v) {
		this._vector1 = v;
	}
	
	public void setVector2(Vector v) {
		this._vector2 = v;
	}

	@Override
	public void move(int direction, double speed) {
		switch(direction) {
			case GO_UP:
				_vector1.setTopDistance(_vector1.getTopDistance()-speed);
				_vector1.setEndTopDistance(_vector1.getEndTopDistance()-speed);
				_vector2.setTopDistance(_vector2.getTopDistance()-speed);
				_vector2.setEndTopDistance(_vector2.getEndTopDistance()-speed);
				break;
			case GO_DOWN:
				_vector1.setTopDistance(_vector1.getTopDistance()+speed);
				_vector1.setEndTopDistance(_vector1.getEndTopDistance()+speed);
				_vector2.setTopDistance(_vector2.getTopDistance()+speed);
				_vector2.setEndTopDistance(_vector2.getEndTopDistance()+speed);
				break;
			case GO_LEFT:
				_vector1.setLeftDistance(_vector1.getLeftDistance()-speed);
				_vector1.setEndLeftDistance(_vector1.getEndLeftDistance()-speed);
				_vector2.setLeftDistance(_vector2.getLeftDistance()-speed);
				_vector2.setEndLeftDistance(_vector2.getEndLeftDistance()-speed);
				break;
			case GO_RIGHT:
				_vector1.setLeftDistance(_vector1.getLeftDistance()+speed);
				_vector1.setEndLeftDistance(_vector1.getEndLeftDistance()+speed);
				_vector2.setLeftDistance(_vector2.getLeftDistance()+speed);
				_vector2.setEndLeftDistance(_vector2.getEndLeftDistance()+speed);
				break;
		}
		notifyObs(this);
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		if(_vector1.getTopDistance() == originTop && _vector1.getLeftDistance() == originLeft) {
			_vector1.setTopDistance(endTop);
			_vector1.setLeftDistance(endLeft);
		}
		if(_vector1.getEndTopDistance() == originTop && _vector1.getEndLeftDistance() == originLeft) {
			_vector1.setEndTopDistance(endTop);
			_vector1.setEndLeftDistance(endLeft);
		}
		if(_vector2.getTopDistance() == originTop && _vector2.getLeftDistance() == originLeft) {
			_vector2.setTopDistance(endTop);
			_vector2.setLeftDistance(endLeft);
		}
		if(_vector2.getEndTopDistance() == originTop && _vector2.getEndLeftDistance() == originLeft) {
			_vector2.setEndTopDistance(endTop);
			_vector2.setEndLeftDistance(endLeft);
		}
		notifyObs(this); 
	}

}
