package fr.iutinfo.model;

import java.awt.Color;

import fr.iutinfo.librairies.CorruptFileException;

/**
 * Classe representant un cercle
 * 
 * @author pierre
 */
public class Circle extends Figure implements Cloneable {
	private Point _centre;
	private double _diametreX;
	private double _diametreY;

	/**
	 * Constructeur du Cercle. Le point central est le premier endroit cliqué
	 * pendant la création du cercle, les deux diametres permettent la création
	 * du rayon du cercle.
	 * 
	 * @param centre
	 * @param diametreX
	 * @param diametreY
	 */
	public Circle(Point centre, double diametreX, double diametreY) {
		_centre = centre;
		_diametreX = diametreX;
		_diametreY = diametreY;
		notifyObs(this);
	}

	/**
	 * Retourne le point central du cercle
	 * 
	 * @return Point
	 */
	public Point getCentre() {
		return _centre;
	}

	/**
	 * Remplace le centre actuel du cercle par le point passé en parametre
	 * 
	 * @param p
	 */
	public void setCentre(Point p) {
		_centre = p;
	}

	/**
	 * Retourne la distance sur l'axe X qui sépare le point central et le point
	 * le plus à droite du cercle.
	 * 
	 * @return double
	 */
	public double getDiametreX() {
		return _diametreX;
	}
	/**
	 * Remplace taille X du cercle par le double passé en parametre
	 * @param d
	 */
	public void setDiametreX(double d) {
		_diametreX = d;
	}
	/**
	 * Retourne la distance sur l'axe Y qui sépare le point central et le point le plus "haut"
	 * @return double
	 */
	public double getDiametreY() {
		return _diametreY;
	}
	/**
	 * Remplace la taille Y du cercle par le double passé en parametre
	 * @param diametreY
	 */
	public void setDiametreY(double diametreY) {
		this._diametreY = diametreY;
	}
	/**
	 * toString du cerlce (centre , diametreX et diametreY)
	 * @return String
	 */
	public String toString() {
		return "Cercle(" + _centre + ";" + _diametreX + ";" + _diametreY + ")";
	}
	
	/**
	 * Permet de déplacement de la figure
	 * @param direction
	 * @param speed
	 */
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
	/**
	 * 
	 * Gere le redimensionnement du cercle et son déplacement.
	 * @param OriginTop
	 * @param OriginLeft
	 * @param EndTop
	 * @param endLeft
	 * 
	 */
	@Override
	public void resize(double originTop, double originLeft, double endTop,
			double endLeft) {
		if (Math.abs(originTop - _centre.getTop()) < Circle.ERROR_MARGE
				&& Math.abs(originLeft - _centre.getLeft()) < Circle.ERROR_MARGE) {
			_centre.setTop(endTop);
			_centre.setLeft(endLeft);
		} else
			setDiametreY(_centre.getTop() - endTop);
		setDiametreX(endLeft - _centre.getLeft());
		notifyObs(this);
	}
	/**
	 * Méthode de clonage de la figure
	 * @return Circle
	 */
	public Circle clone() {
		Circle c = (Circle) super.clone();
		c.setCentre(this.getCentre().clone());
		return c;
	}
	/**
	 * écriture de la figure dans le fichier de sauvegarde
	 */
	@Override
	public String save() {
		return "[" + _centre.getTop() + "," + _centre.getLeft() + ";"
				+ _diametreX + ";" + _diametreY + ";" + (isFill() ? 1 : 0)
				+ ";" + Figure.encodeColor(getColor()) + "]";
	}
	
	/**
	 * Restaure la figure sauvegardée
	 * @param s
	 * @return
	 * @throws CorruptFileException
	 */
	public static Figure restore(String s) throws CorruptFileException {
		Circle v;
		if (s.startsWith("[") && s.endsWith("]")) {
			s = s.substring(1, s.length() - 1);
			String part[] = s.split(";");
			if (part.length != 5)
				throw new CorruptFileException();
			String ptInfo[] = part[0].split(",");
			Point p = new Point(Double.parseDouble(ptInfo[0]),
					Double.parseDouble(ptInfo[1]));
			v = new Circle(p, Double.parseDouble(part[1]),
					Double.parseDouble(part[2]));
			v.setFill((Integer.parseInt(part[3]) == 0) ? false : true);
			v.setColor(Figure.decodeColor(part[4]));
		} else {
			throw new CorruptFileException();
		}

		return v;
	}
}
