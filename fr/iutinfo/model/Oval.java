package fr.iutinfo.model;

public class Oval extends Figure implements Cloneable {
	private Point _centre;
	private double _diametreX;
	private double _diametreY;

	public Oval(Point centre, double diametreX, double diametreY) {
		_centre = centre;
		_diametreX = diametreX;
		_diametreY = diametreY;
		notifyObs(this);
	}

	public Point getCentre() {
		return _centre;
	}

	public void setCentre(Point p) {
		_centre = p;
	}

	public double getDiametreX() {
		return _diametreX;
	}

	public void setDiametreX(double d) {
		_diametreX = d;
	}

	public double getDiametreY() {
		return _diametreY;
	}

	public void setDiametreY(double diametreY) {
		this._diametreY = diametreY;
	}

	public String toString() {
		return "Oval(" + _centre + ";" + _diametreX + ";" + _diametreY + ")";
	}

	@Override
	public void move(int direction, double speed) {
		switch (direction) {
		case GO_UP:
			_centre.setTop(_centre.getTop() - speed);
			break;
		case GO_DOWN:
			_centre.setTop(_centre.getTop() + speed);
			break;
		case GO_LEFT:
			_centre.setLeft(_centre.getLeft() - speed);
			break;
		case GO_RIGHT:
			_centre.setLeft(_centre.getLeft() + speed);
			break;
		}
		notifyObs(this);
	}
	@Override
	public void resize(double originTop, double originLeft, double endTop,
			double endLeft) {
		if (Math.abs(originTop - _centre.getTop()) < Oval.ERROR_MARGE
				&& Math.abs(originLeft - _centre.getLeft()) < Oval.ERROR_MARGE) {
			_centre.setTop(endTop);
			_centre.setLeft(endLeft);
		} else {
				setDiametreY(Math.abs(_centre.getTop() - endTop));
				setDiametreX(Math.abs(endLeft - _centre.getLeft()));
			
		}
		notifyObs(this);
	}

	public Oval clone() {
		Oval c = (Oval) super.clone();
		c.setCentre(this.getCentre().clone());
		return c;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}
}
