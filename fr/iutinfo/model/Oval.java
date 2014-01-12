package fr.iutinfo.model;

import fr.iutinfo.librairies.CorruptFileException;

public class Oval extends Figure implements Cloneable {
	private Point _centre;
	private double _diametreX;
	private double _diametreY;

	/**
	 * Constructeur de l'Oval
	 * 
	 * @param centre
	 * @param diametreX
	 * @param diametreY
	 */
	public Oval(Point centre, double diametreX, double diametreY) {
		_centre = centre;
		_diametreX = diametreX;
		_diametreY = diametreY;
		notifyObs(this);
	}

	/**
	 * Retourne le point central de l'oval
	 * 
	 * @return Point
	 */
	public Point getCentre() {
		return _centre;
	}

	/**
	 * Remplace le point central de l'oval
	 * 
	 * @param p
	 */
	public void setCentre(Point p) {
		_centre = p;
	}

	/**
	 * Retourne le diametreX de l'Oval
	 * 
	 * @return double
	 */
	public double getDiametreX() {
		return _diametreX;
	}

	/**
	 * Modifie le DiametreX de l'Oval
	 * 
	 * @param d
	 */
	public void setDiametreX(double d) {
		_diametreX = d;
	}

	/**
	 * retourne le diametreY de l'oval
	 * 
	 * @return double
	 */
	public double getDiametreY() {
		return _diametreY;
	}

	/**
	 * Modifie le diametreY de l'Oval
	 * 
	 * @param diametreY
	 */
	public void setDiametreY(double diametreY) {
		this._diametreY = diametreY;
	}

	/**
	 * Methode toString de la classe
	 */
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
		return "[" + _centre.getTop() + "," + _centre.getLeft() + ";"
				+ _diametreX + ";" + _diametreY + ";" + (isFill() ? 1 : 0)
				+ ";" + Figure.encodeColor(getColor()) + "]";
	}
}
