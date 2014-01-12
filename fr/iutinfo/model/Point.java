package fr.iutinfo.model;

/**
 * Classe repr�sentant un point sous forme vectorielle
 */
public class Point implements Cloneable {
	private double _top;
	private double _left;

	/**
	 * Constructeur du Point
	 * 
	 * @param top
	 * @param left
	 */
	public Point(double top, double left) {
		_top = top;
		_left = left;
	}

	/**
	 * retourne coordonnée en Y du point
	 * 
	 * @return double
	 */
	public double getTop() {
		return _top;
	}

	/**
	 * Modifie la coordonnée en Y du point
	 * 
	 * @param top
	 */
	public void setTop(double top) {
		this._top = top;
	}
	/**Retourne la coordonnée en X du point
	 * 
	 */
	public double getLeft() {
		return _left;
	}
	/**
	 * Modifie la coordonnée en X du point
	 * @param left
	 */
	public void setLeft(double left) {
		this._left = left;
	}
	/** 
	 * Méthode toString du point
	 */
	public String toString() {
		return "Point(" + _left + "," + _top + ")";
	}
	/**
	 * Méthode de clone du point
	 */
	public Point clone() {
		try {
			return (Point) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
