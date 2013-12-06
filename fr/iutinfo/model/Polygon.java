package fr.iutinfo.model;

import java.util.ArrayList;

public class Polygon extends Figure {
	protected ArrayList<Vector> _vectorList;
	protected boolean _finished = false;
	public final static float ERROR_MARGE = (float) 0.005;
	
	/**
	 * Crée un polygone vide
	 */
	public Polygon() {
		_vectorList = new ArrayList<Vector>();
	}
	
	/**
	 * Ajoute un vecteur à la forme
	 * @param v
	 * @throws Exception 
	 */
	public void addVector(Vector v) throws Exception {
		if(!_checkVector(v)) {
			throw new IllegalArgumentException("Le vecteur ne suit pas le vecteur précédent");
		}
		if(isFinish()) {
			throw new Exception("La figure est déjà pleine");
		}
		if(_isFinish(v)) {
			_finished = true;
		}
		_vectorList.add(v);
	}

	/**
	 * Verifie que le vecteur est ajoutable
	 * @param v
	 * @return
	 */
	protected boolean _checkVector(Vector v) {
		if(_vectorList.isEmpty()) return true;
		
		Vector last = _vectorList.get(_vectorList.size()-1);
		
		double finishY = last.getEndTopDistance();
		double finishX = last.getEndLeftDistance();
		
		double diffY = Math.abs(v.getTopDistance()-finishY);
		double diffX = Math.abs(v.getLeftDistance()-finishX);
		
		if(diffY < ERROR_MARGE && diffX < ERROR_MARGE) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Verifie que la figure est pleine
	 * @param v
	 * @return
	 */
	protected boolean _isFinish(Vector v) {
		if(_vectorList.isEmpty()) return false;
		
		Vector first = _vectorList.get(0);
		
		double finishY = v.getEndTopDistance();
		double finishX = v.getEndLeftDistance();
		
		double diffY = Math.abs(first.getTopDistance()-finishY);
		double diffX = Math.abs(first.getLeftDistance()-finishX);
		
		System.out.println("diffY : " + diffY);
		System.out.println("diffX : " + diffX);
		
		if(diffY < ERROR_MARGE && diffX < ERROR_MARGE) {
			notifyObs();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Vérifie si un polygon est fini
	 * @return
	 */
	public boolean isFinish() {
		return _finished;
	}

	public ArrayList<Vector> getVectors() {
		return _vectorList;
	}
}
