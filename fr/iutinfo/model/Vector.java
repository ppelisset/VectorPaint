package fr.iutinfo.model;

public class Vector extends Observable {

	float size;
	float topDistance;
	float leftDistance;
	float xDirection;
	float yDirection;
	/**
	 * Définit un vecteur par sa position dans l'écran (topDistance,leftDistance)
	 * ainsi que par sa direction (xDirection,yDirection) et sa taille size.
	 * 
	 * @param size
	 * @param topDistance
	 * @param leftDistance
	 * @param xDirection
	 * @param yDirection
	 */
	
	
	public Vector(float size,float topDistance,float leftDistance,
			float xDirection,float yDirection){
		this.size=size;
		this.topDistance=topDistance ;
		this.leftDistance=leftDistance ;
		this.xDirection=xDirection ;
		this.yDirection=yDirection ;	
	}
	/**
	 * retourne la tailel du vecteur.
	 * 
	 * @return size
	 */
	public float getSize() {
		return size;
	}
	/**
	 * Modifie la taille du vecteur et en notifie les observeurs.
	 * 
	 * @param size
	 */
	public void setSize(float size) {
		this.size = size;
		notifyObs();
	}
	
	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe horizontal 
	 * 
	 * @return topDistance
	 */
	public float getTopDistance() {
		return topDistance;
	}
	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe horizontal 
	 * et en notifie les observeurs.
	 * @param topDistance
	 */
	public void setTopDistance(float topDistance) {
		this.topDistance = topDistance;
		notifyObs();
	}
	/**
	 * retourne la distance entre le point de départ du vecteur et le l'axe vertical 
	 * 
	 * @return leftDistance
	 */
	public float getLeftDistance() {
		return leftDistance;
	}
	/**
	 * Modifie la distance entre le point de départ du vecteur et le l'axe vertical 
	 * et notifie les Observeurs.
	 * @param leftDistance
	 */
	public void setLeftDistance(float leftDistance) {
		this.leftDistance = leftDistance;
		notifyObs();
	}
	/**
	 * retourne la direction de l'axe x du vecteur.
	 * @return xDirection 
	 */
	public float getxDirection() {
		return xDirection;
	}
	/**
	 * Modifie la direction de l'axe x du vecteur et notifie les observeurs.
	 * 
	 * @param xDirection
	 */
	public void setxDirection(float xDirection) {
		this.xDirection = xDirection;
		notifyObs();
	}
	/**
	 * retourne la direction de l'axe y du vecteur.
	 * @return yDirection
	 */
	public float getyDirection() {
		return yDirection;
	}
	/**
	 * modifie la direction de l'axe y du vecteur.
	 *  et notifie les observeurs.
	 * @param yDirection
	 */
	public void setyDirection(float yDirection) {
		this.yDirection = yDirection;
		notifyObs();
	}
	
}
