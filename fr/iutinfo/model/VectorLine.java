package fr.iutinfo.model;

import java.awt.Color;

import fr.iutinfo.librairies.CorruptFileException;


/**
 * Classe representant une ligne vectorielle
 * @author pierre
 *
 */
public class VectorLine extends Figure {
	private Vector _vector;

	/**
	 * Cree une nouvelle ligne defini par un vecteur
	 * @param v
	 */
	public VectorLine(Vector v) {
		_vector = v; 	
	}

	/**
	 * Recupere le vecteur utilise par la ligne
	 * @return
	 */
	public Vector getVector() {
		return _vector;
	}

	@Override
	public void move(int direction, double speed) {
		Vector v = _vector;
		switch(direction) {
		case GO_UP:
			v.setTopDistance(v.getTopDistance()-speed);
			v.setEndTopDistance(v.getEndTopDistance()-speed);
			break;
		case GO_DOWN:
			v.setTopDistance(v.getTopDistance()+speed);
			v.setEndTopDistance(v.getEndTopDistance()+speed);
			break;
		case GO_LEFT:
			v.setLeftDistance(v.getLeftDistance()-speed);
			v.setEndLeftDistance(v.getEndLeftDistance()-speed);
			break;
		case GO_RIGHT:
			v.setLeftDistance(v.getLeftDistance()+speed);
			v.setEndLeftDistance(v.getEndLeftDistance()+speed);
			break;
		}
		notifyObs(this);
	}

	@Override
	public void resize(double originTop, double originLeft, double endTop, double endLeft) {
		double diffX, diffY;
		boolean beginResize = false, endResize = false;
		if(!beginResize) {
			diffX = Math.abs(_vector.getLeftDistance() - originLeft);
			diffY = Math.abs(_vector.getTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_vector.setLeftDistance(endLeft);
				_vector.setTopDistance(endTop);
			}
			beginResize = true;
		}

		if(!endResize) {
			diffX = Math.abs(_vector.getEndLeftDistance() - originLeft);
			diffY = Math.abs(_vector.getEndTopDistance() - originTop);

			if(diffX < ERROR_MARGE && diffY < ERROR_MARGE) {
				_vector.setEndLeftDistance(endLeft);
				_vector.setEndTopDistance(endTop);
			}
			endResize = true;
		}
		notifyObs(this);
	}
	
	public VectorLine clone() {
		VectorLine copy = (VectorLine) super.clone();
		if(copy == null) return null;
		copy._vector = _vector.clone();
		return copy;
	}

	@Override
	public String save() {
		return "["+_vector.save()+";"+Figure.encodeColor(getColor())+"]";
	}
	/**
	 * Methode de creation de creation d'ujne VectorLine à partir d'un fichier .vpf
	 * @param s
	 * @return
	 * @throws CorruptFileException
	 */
	public static Figure restore(String s) throws CorruptFileException {
		VectorLine v;
		if(s.startsWith("[") && s.endsWith("]")) {
			s = s.substring(1, s.length()-1);
			String part[] = s.split(";");
			if(part.length != 2) throw new CorruptFileException();
			v = new VectorLine(Vector.restore(part[0]));
			v.setColor(Figure.decodeColor(part[1]));
		} else {
			throw new CorruptFileException();
		}
		
		return v;
	}
}
