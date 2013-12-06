package fr.iutinfo.model;

/**
 * Classe représentant un cercle
 * @author pierre
 * TODO A recoder complétement
 */
public class Circle extends Figure {
	private Vector _height;
	private Vector _width;
	
	/**
	 * Cr√©e un cercle avec deux vecteurs
	 * @param height
	 * @param width
	 */
	public Circle(Vector height, Vector width) {
		_height = height;
		_width = width;
		notifyObs();
	}
}
