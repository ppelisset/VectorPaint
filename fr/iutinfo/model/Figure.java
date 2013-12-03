package fr.iutinfo.model;

public abstract class Figure extends Observable {
	/**
	 * Défini si une forme est pleine (true) ou si elle ne contient que le contour(false)
	 */
	private boolean _fill;
	/**
	 * Contient la couleur de la figure
	 */
	private Color _color;
	
	/**
	 * Modifie le remplissage d'une forme
	 * @param fill
	 */
	public void setFill(boolean fill) {
		_fill = fill;
		notifyObs();
	}
	
	/**
	 * Retourne l'état de remplissage de la forme
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
		notifyObs();
	}
	
	/**
	 * Retourne la couleur d'une forme
	 * @return
	 */
	public Color getColor() {
		return _color;
	}
}
