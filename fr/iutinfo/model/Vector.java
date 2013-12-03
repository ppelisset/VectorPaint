package fr.iutinfo.model;

public class Vector extends Observable {

	protected float _size;
	protected float _topDistance;
	protected float _leftDistance;
	protected float _xDirection;
	protected float _yDirection;

	/**
	 * Définit un vecteur par sa position dans l'écran
	 * (_topDistance,_leftDistance) ainsi que par sa direction
	 * (_xDirection,_yDirection) et sa taille _size.
	 * 
	 * @param _size
	 * @param _topDistance
	 * @param _leftDistance
	 * @param _xDirection
	 * @param _yDirection
	 * @throws Exception 
	 */

	public Vector(float _size, float _topDistance, float _leftDistance,
			float _yDirection, float _xDirection) throws Exception {

		setSize(_size);
		setTopDistance(_topDistance);
		setLeftDistance(_leftDistance);
		setYDirection(_yDirection);
		setXDirection(_xDirection);
	}

	/**
	 * retourne la tailel du vecteur.
	 * 
	 * @return _size
	 */
	public float getSize() {
		return _size;
	}

	/**
	 * Modifie la taille du vecteur et en notifie les observeurs.
	 * 
	 * @param _size
	 * @throws Exception
	 */
	public void setSize(float _size) throws Exception {
		if (_size > 100 || _size < 0) {
			throw new Exception("size incorrecte");
		} else {
			this._size = _size;
			notifyObs();
		}
	}

	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe
	 * horizontal
	 * 
	 * @return _topDistance
	 */
	public float getTopDistance() {
		return _topDistance;
	}

	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe
	 * horizontal et en notifie les observeurs.
	 * 
	 * @param _topDistance
	 * @throws Exception
	 */
	public void setTopDistance(float _topDistance) throws Exception {

		if (_topDistance > 100 || _topDistance < 0) {
			throw new Exception("TopDistance incorrecte ");
		} else {
			this._topDistance = _topDistance;
			notifyObs();
		}
	}

	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe
	 * vertical
	 * 
	 * @return _leftDistance
	 */
	public float getLeftDistance() {
		return _leftDistance;
	}

	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe
	 * vertical et notifie les Observeurs.
	 * 
	 * @param _leftDistance
	 * @throws Exception
	 */
	public void setLeftDistance(float _leftDistance) throws Exception {
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
	public float getXDirection() {
		return _xDirection;
	}

	/**
	 * Modifie la direction de l'axe x du vecteur et notifie les observeurs.
	 * 
	 * @param _xDirection
	 * @throws Exception
	 */
	public void setXDirection(float _xDirection) throws Exception {
		if (_xDirection > 100 || _xDirection < 0) {
			throw new Exception("xDirection incorrecte");
		} else {
			this._xDirection = _xDirection;
			notifyObs();
		}
	}

	/**
	 * retourne la direction de l'axe y du vecteur.
	 * 
	 * @return _yDirection
	 */
	public float getYDirection() {
		return _yDirection;
	}

	/**
	 * modifie la direction de l'axe y du vecteur. et notifie les observeurs.
	 * 
	 * @param _yDirection
	 * @throws Exception
	 */
	public void setYDirection(float _yDirection) throws Exception {
		if (_yDirection > 100 || _yDirection < 0) {
			throw new Exception("yDirection incorrecte");
		} else {
			this._yDirection = _yDirection;
			notifyObs();
		}
	}

}
