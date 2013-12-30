package fr.iutinfo.model;


/**
 * Classe representant un cercle
 * @author pierre
 */
public class Circle extends Figure implements Cloneable {
	private Point _centre;
	private double _diametreX;
	private double _diametreY;

	public Circle(Point centre, double diametreX, double diametreY) {
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
		return "Cercle("+_centre+";"+_diametreX+";"+_diametreY+")";
	}

	@Override
	public void move(int direction, double speed) {
		switch(direction) {
		case GO_UP:
			_centre.setTop(_centre.getTop()-speed);
			break;
		case GO_DOWN:
			_centre.setTop(_centre.getTop()+speed);
			break;
		case GO_LEFT:
			_centre.setLeft(_centre.getLeft()-speed);
			break;
		case GO_RIGHT:
			_centre.setLeft(_centre.getLeft()+speed);
			break;
	}
	notifyObs(this);
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		if(Math.abs(originTop-_centre.getTop()) < Circle.ERROR_MARGE && Math.abs(originLeft-_centre.getLeft()) < Circle.ERROR_MARGE) {
			_centre.setTop(endTop);
			_centre.setLeft(endLeft);
		} else if(Math.abs(originTop-(_centre.getTop()-_diametreY)) < Circle.ERROR_MARGE && Math.abs(originLeft-_centre.getLeft()) < Circle.ERROR_MARGE) {
			if(Math.abs(_centre.getTop()-endTop) > Circle.ERROR_MARGE*2) {
				setDiametreY(_centre.getTop()-endTop);
			}
		} else {
			if(Math.abs(endLeft-_centre.getLeft()) > Circle.ERROR_MARGE*2) {
				setDiametreX(endLeft-_centre.getLeft());
			}
		}
		notifyObs(this);
	}
	
	public Circle clone() {
		Circle c = (Circle) super.clone();
		c.setCentre(this.getCentre().clone());
		return c;
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}
}
