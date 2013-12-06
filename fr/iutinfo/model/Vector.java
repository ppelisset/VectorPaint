package fr.iutinfo.model;

/**
 * Classe reprŽsentant un vecteur
 * @author maxence, pierre
 */
public class Vector extends Observable {

	protected double _size;
	protected double _topDistance;
	protected double _leftDistance;
	protected double _xDirection;
	protected double _yDirection;
	
	protected double _endTopDistance;
	protected double _endLeftDistance;

	/**
	 * DŽfinit un vecteur par sa position dans l'Žcran
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
	 * DŽfinit un vecteur par rapport ˆ un point de dŽpart(topDistance,leftDistance)
	 * et d'un point d'arrivŽ (endTopDistance,endLeftDistance)
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
	 * retourne la tailel du vecteur.
	 * 
	 * @return _size
	 */
	public double getSize() {
		return _size;
	}

	/**
	 * Modifie la taille du vecteur et en notifie les observeurs.
	 * 
	 * @param _size
	 * @throws Exception
	 */
	public void setSize(double _size) throws Exception {
		if (_size > 100 || _size < 0) {
			throw new Exception("size incorrecte");
		} else {
			this._size = _size;
			_updateEndDistance();
			notifyObs();
		}
	}

	/**
	 * retourne la distance entre le point de dÃ©part du vecteur et le l'axe
	 * horizontal
	 * 
	 * @return _topDistance
	 */
	public double getTopDistance() {
		return _topDistance;
	}

	/**
	 * Modifie la distance entre le point de dÃ©part du vecteur et le l'axe
	 * horizontal et en notifie les observeurs.
	 * 
	 * @param _topDistance
	 * @throws Exception
	 */
	public void setTopDistance(double _topDistance) throws Exception {
		if (_topDistance > 100 || _topDistance < 0) {
			throw new Exception("TopDistance incorrecte ");
		} else {
			this._topDistance = _topDistance;
			notifyObs();
		}
	}

	/**
	 * retourne la distance entre le point de dÃ©part du vecteur et le l'axe
	 * vertical
	 * 
	 * @return _leftDistance
	 */
	public double getLeftDistance() {
		return _leftDistance;
	}

	/**
	 * Modifie la distance entre le point de dÃ©part du vecteur et le l'axe
	 * vertical et notifie les Observeurs.
	 * 
	 * @param _leftDistance
	 * @throws Exception
	 */
	public void setLeftDistance(double _leftDistance) throws Exception {
		if (_leftDistance > 100 || _leftDistance < 0) {
			throw new Exception("_LeftDistance incorrecte");
		} else {
			this._leftDistance = _leftDistance;
			notifyObs();
		}
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
			notifyObs();
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
			notifyObs();
		}
	}
	
	
	
	public double getEndTopDistance() {
		return _endTopDistance;
	}

	public void setEndTopDistance(double endTopDistance) throws Exception {
		if (endTopDistance > 100 || endTopDistance < 0) {
			throw new Exception("endTopDistance incorrecte ");
		} else {
			_endTopDistance = endTopDistance;
			_updateDirection();
			notifyObs();
		}
	}

	public double getEndLeftDistance() {
		return _endLeftDistance;
	}

	public void setEndLeftDistance(double endLeftDistance) throws Exception {
		if (endLeftDistance > 100 || endLeftDistance < 0) {
			throw new Exception("endLeftDistance incorrecte ");
		} else {
			_endLeftDistance = endLeftDistance;
			_updateDirection();
			notifyObs();
		}
	}

	public String toString() {
		return "Vecteur (" + _topDistance + "," + _leftDistance + "," + _yDirection + "," + _xDirection + "," + _size + ")";
	}

}
