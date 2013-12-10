package fr.iutinfo.model;

import java.awt.Color;

import fr.iutinfo.librairies.MyObservable;

public abstract class Figure extends MyObservable implements Cloneable {
	public static final int GO_UP = 1;
	public static final int GO_DOWN = 2;
	public static final int GO_LEFT = 3;
	public static final int GO_RIGHT = 4;
	public final static float ERROR_MARGE = (float) 0.5;
	
	/**
	 * D√©fini si une forme est pleine (true) ou si elle ne contient que le contour(false)
	 */
	private boolean _fill = true;
	/**
	 * Contient la couleur de la figure
	 */
	private Color _color = Color.BLACK;
	/**
	 * Contient le fait que la figure soit séléctionner ou non
	 */
	private boolean _selected = false;
	
	/**
	 * Modifie le remplissage d'une forme
	 * @param fill
	 */
	public void setFill(boolean fill) {
		_fill = fill;
		notifyObs(this);
	}
	
	/**
	 * Retourne l'√©tat de remplissage de la forme
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

	public void setSelected(boolean b) {
		_selected = b;
	}
	
	public boolean isSelected() {
		return _selected;
	}
	
	public abstract void move(int direction, double speed);
	public abstract void resize(double originTop, double originLeft, double endTop, double endLeft);
	
	public Figure clone() {
		try {
			return (Figure) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
