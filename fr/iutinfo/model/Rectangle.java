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
		if(originTop == _vector.getTopDistance()) {
			_vector.setTopDistance(endTop);
		}
		if(originTop == _vector.getEndTopDistance()) {
			_vector.setEndTopDistance(endTop);
		}
		if(originLeft == _vector.getLeftDistance()) {
			_vector.setLeftDistance(endLeft);
		}
		if(originLeft == _vector.getEndLeftDistance()) {
			_vector.setEndLeftDistance(endLeft);
		}
		notifyObs(this); 
	}

}
