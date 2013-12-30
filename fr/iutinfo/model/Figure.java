package fr.iutinfo.model;

import java.awt.Color;

import fr.iutinfo.librairies.CorruptFileException;
import fr.iutinfo.librairies.MyObservable;

public abstract class Figure extends MyObservable implements Cloneable {
	public static final int GO_UP = 1;
	public static final int GO_DOWN = 2;
	public static final int GO_LEFT = 3;
	public static final int GO_RIGHT = 4;
	public final static float ERROR_MARGE = (float) 0.5;
	
	/**
	 * Defini si une forme est pleine (true) ou si elle ne contient que le contour(false)
	 */
	private boolean _fill = true;
	/**
	 * Contient la couleur de la figure
	 */
	private  Color _color = Color.BLACK;
	
	/**
	 * Modifie le remplissage d'une forme
	 * @param fill
	 */
	public void setFill(boolean fill) {
		_fill = fill;
		notifyObs(this);
	}
	
	/**
	 * Retourne l'etat de remplissage de la forme
	 * @return
	 */
	public boolean isFill() {
		return _fill;
	}
	
	/**
	 * Modifie la couleur d'une forme
	 * @param color
	 */
	public void setColor(Color color) {
		_color = color;
		notifyObs(this);
	}
	
	/**
	 * Retourne la couleur d'une forme
	 * @return
	 */
	public Color getColor() {
		return _color;
	}
	
	/**
	 * Permet de diriger une forme dans une direction(LEFT, RIGHT, DOWN, UP) avec une vitesse
	 * @param direction
	 * @param speed
	 */
	public abstract void move(int direction, double speed);
	/**
	 * Permet de redimensionner une figure en remplacent le point � l'origine par l'autre
	 * @param originTop
	 * @param originLeft
	 * @param endTop
	 * @param endLeft
	 */
	public abstract void resize(double originTop, double originLeft, double endTop, double endLeft);
	
	/**
	 * Methode de clonage, si la figure contient une liste de vecteur alors la classe fille doit red�finir clone
	 * @see Polygon.clone
	 */
	public Figure clone() {
		try {
			return (Figure) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract String save();
	
	public static Figure restore(String s) throws CorruptFileException {
		return null;
	}
}
