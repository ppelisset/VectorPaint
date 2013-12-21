package fr.iutinfo.model;

import fr.iutinfo.controller.manager.SetSelectListener;

/**
 * Classe representant un cercle
 * @author pierre
 */
public class Circle extends Figure implements Cloneable {
	private Point _centre;
	private double _diametre;

	public Circle(Point centre, double diametre) {
		_centre = centre;
		_diametre = diametre;
		notifyObs(this);
	}
	
	public Point getCentre() {
		return _centre;
	}
	
	public void setCentre(Point p) {
		_centre = p;
	}
	
	public double getDiametre() {
		return _diametre;
	}
	
	public void setDiametre(double d) {
		_diametre = d;
	}
	
	public String toString() {
		return "Cercle("+_centre+";"+_diametre+")";
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
		} else {
			double size = Math.abs(_centre.getLeft()-endLeft);
			if(size > Circle.ERROR_MARGE*2) {
				setDiametre(size);
			}
		}
		notifyObs(this);
	}
	
	public Circle clone() {
		Circle c = (Circle) super.clone();
		c.setCentre(this.getCentre().clone());
		return c;
	}
}
