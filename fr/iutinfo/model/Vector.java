package fr.iutinfo.model;

import fr.iutinfo.librairies.CorruptFileException;

/**
 * Classe repr�sentant un vecteur
 * @author maxence, pierre
 */
public class Vector implements Cloneable {

	protected double _size;
	protected double _topDistance;
	protected double _leftDistance;
	protected double _xDirection;
	protected double _yDirection;

	protected double _endTopDistance;
	protected double _endLeftDistance;

	/**
	 * D�finit un vecteur par sa position dans l'�cran
	 * (topDistance,leftDistance) ainsi que par sa direction
	 * (xDirection,yDirection) et sa taille size.
	 * 
	 * @param size
	 * @param topDistance
	 * @param leftDistance
	 * @param xDirection
	 * @param yDirection
	 * @throws Exception 
	 */

	public Vector(double size, double topDistance, double leftDistance,
			double yDirection, double xDirection) throws Exception {

		setSize(size);
		setTopDistance(topDistance);
		setLeftDistance(leftDistance);
		setYDirection(yDirection);
		setXDirection(xDirection);
		_updateEndDistance();
	}

	/**
	 * D�finit un vecteur par rapport � un point de d�part(topDistance,leftDistance)
	 * et d'un point d'arriv� (endTopDistance,endLeftDistance)
	 * @param topDistance
	 * @param leftDistance
	 * @param endTopDistance
	 * @param endLeftDistance
	 * @throws Exception
	 */
	public Vector(double topDistance, double leftDistance, double endTopDistance, double endLeftDistance) throws Exception {
		setTopDistance(topDistance);
		setLeftDistance(leftDistance);
		setEndTopDistance(endTopDistance);
		setEndLeftDistance(endLeftDistance);
		_updateDirection();
	}


	protected void _updateEndDistance() {
		_endTopDistance = _topDistance+(_yDirection*_size);
		_endLeftDistance = _leftDistance+(_xDirection*_size);
	}

	protected void _updateDirection() {
		double yDistance = _topDistance-_endTopDistance;
		double xDistance = _leftDistance-_endLeftDistance;

		double ySize = Math.abs(yDistance), xSize = Math.abs(xDistance);

		_size = (ySize > xSize) ? ySize : xSize;

		_xDirection = xDistance/_size;
		_yDirection = yDistance/_size;
	}

	/**
	 * retourne la taille du vecteur.
	 * 
	 * @return size
	 */
	public double getSize() {
		return _size;
	}

	/**
	 * Modifie la taille du vecteur et en notifie les observeurs.
	 * @param size
	 * @throws Exception
	 */
	public void setSize(double _size) throws Exception {
		if (_size > 100 || _size < 0) {
			throw new Exception("size incorrecte");
		} else {
			this._size = _size;
			_updateEndDistance();
		}
	}

	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe
	 * horizontal
	 * 
	 * @return _topDistance
	 */
	public double getTopDistance() {
		return _topDistance;
	}

	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe
	 * horizontal et en notifie les observeurs.
	 * 
	 * @param _topDistance
	 */
	public void setTopDistance(double _topDistance) {
		this._topDistance = _topDistance;
	}

	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe
	 * vertical
	 * 
	 * @return _leftDistance
	 */
	public double getLeftDistance() {
		return _leftDistance;
	}

	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe
	 * vertical et notifie les Observeurs.
	 * 
	 * @param _leftDistance
	 */
	public void setLeftDistance(double _leftDistance) {
		this._leftDistance = _leftDistance;
	}

	/**
	 * retourne la direction de l'axe x du vecteur.
	 * 
	 * @return _xDirection
	 */
	public double getXDirection() {
		return _xDirection;
	}

	/**
	 * Modifie la direction de l'axe x du vecteur et notifie les observeurs.
	 * 
	 * @param _xDirection
	 * @throws Exception
	 */
	public void setXDirection(double _xDirection) throws Exception {
		if (_xDirection > 1 || _xDirection < -1) {
			throw new Exception("xDirection incorrecte");
		} else {
			this._xDirection = _xDirection;
			_updateEndDistance();
		}
	}

	/**
	 * retourne la direction de l'axe y du vecteur.
	 * 
	 * @return _yDirection
	 */
	public double getYDirection() {
		return _yDirection;
	}

	/**
	 * modifie la direction de l'axe y du vecteur. et notifie les observeurs.
	 * 
	 * @param _yDirection
	 * @throws Exception
	 */
	public void setYDirection(double _yDirection) throws Exception {
		if (_yDirection > 1 || _yDirection < -1) {
			throw new Exception("yDirection incorrecte");
		} else {
			this._yDirection = _yDirection;
			_updateEndDistance();
		}
	}

	/**
	 * Recup�re la distance par rapport au haut de l'ecran du point d'arrive
	 * @return
	 */
	public double getEndTopDistance() {
		return _endTopDistance;
	}

	/**
	 * Modifie la distance par rapport au haut de l'ecran du point d'arrive
	 * @param endTopDistance
	 */
	public void setEndTopDistance(double endTopDistance) {
		_endTopDistance = endTopDistance;
		_updateDirection();
	}

	/**
	 * Recup�re la distance par rapport au cote gauche de l'�cran du point d'arrive
	 * @return
	 */
	public double getEndLeftDistance() {
		return _endLeftDistance;
	}

	/**
	 * Modifie la distance par rapport au cote gauche de l'�cran du point d'arrive
	 * @param endLeftDistance
	 */
	public void setEndLeftDistance(double endLeftDistance) {
		_endLeftDistance = endLeftDistance;
		_updateDirection();
	}
	/** 
	 * Methode toString du Vector
	 */
	public String toString() {
		return "Vecteur (" + _topDistance + "," + _leftDistance + "," + _endTopDistance + "," + _endLeftDistance + ")";
	}
	/**
	 * Methode de test d'égalité entre deux Vectors
	 * @param v
	 * @return boolean
	 */
	public boolean equals(Vector v) {
		return (_topDistance == v._topDistance && _leftDistance == v._leftDistance && _endLeftDistance == v._endLeftDistance && _endTopDistance == v._endTopDistance);
	}
	
	public Vector clone() {
		try {
			return (Vector) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String save() {
		return "{" + _topDistance + "|" + _leftDistance + "|" + _endTopDistance + "|" + _endLeftDistance + "}";
	}
	
	/**
	 * Methode de creation d'ujn vector depuis un fichier .vpf
	 * @param s
	 * @return
	 * @throws CorruptFileException
	 */
	public static Vector restore(String s) throws CorruptFileException {
		Vector v;
		if(s.startsWith("{") && s.endsWith("}")) {
			s = s.substring(1, s.length()-2);
			String part[] = s.split("\\|");
			if(part.length != 4) {
				throw new CorruptFileException();
			}
			try {
				double topDistance = Double.parseDouble(part[0]);
				double leftDistance = Double.parseDouble(part[1]);
				double endTopDistance = Double.parseDouble(part[2]);
				double endLeftDistance = Double.parseDouble(part[3]);
				v = new Vector(topDistance, leftDistance, endTopDistance, endLeftDistance);
			} catch (Exception e) {
				throw new CorruptFileException();
			}
		} else {
			throw new CorruptFileException();
		}
		return v;
	}

}
