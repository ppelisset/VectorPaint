package fr.iutinfo.model;

import java.util.ArrayList;

/**
 * 
 * @author Vanneufville Matthieu
 *
 */
public class Scene extends Observable {
	//--ATTRIBUTS--
	/**
	 * il sagit d'une ArrayList qui contient 4 ArrayList pour chaque niveau de profondeur.
	 */
	protected ArrayList<ArrayList<Figure>> listFigure;

	/**
	 * il sagit d'une ArrayList qui contient 4 ArrayList pour chaque niveau de profondeur.
	 */
	protected ArrayList<ArrayList<Vector>> listVector;

	//--CONSTRUCTEURS--
	/**
	 * ce constructeur initialise les 2 ArrayList
	 */
	public Scene(){
		listFigure = new ArrayList<ArrayList<Figure>>();
		listVector = new ArrayList<ArrayList<Vector>>();
		//boucle qui initialise les ArrayList dans les ArrayList
		for(int i=0; i<4; i++){
			listFigure.add(new ArrayList<Figure>());
			listVector.add(new ArrayList<Vector>());
		}
	}

	//--METHODES--
	/**
	 * ajoute une Figure dans l'ArrayList de profondeur voulue
	 */
	public void addFigure(int profondeur, Figure figure){
		if(isCorrect(profondeur))
			listFigure.get(profondeur).add(figure);
	}

	/**
	 * ajoute un Vector dans l'ArrayList de profondeur voulue
	 */
	public void addVector(int profondeur, Vector vector){
		if(isCorrect(profondeur))
			listVector.get(profondeur).add(vector);
	}

	/**
	 * change une Figure d'ArrayList
	 */
	public void setFigure(Figure figure, int profondeur){
		if(isCorrect(profondeur)){
			for(int i=0; i<4; i++){
				listFigure.get(i).remove(figure);
			}
			listFigure.get(profondeur).add(figure);
		}
	}

	/**
	 * change un Vector d'ArrayList
	 */
	public void setVector(Vector vector, int profondeur){
		if(isCorrect(profondeur)){
			for(int i=0; i<4; i++){
				listVector.get(i).remove(vector);
			}
			listVector.get(profondeur).add(vector);
		}
	}

	/**
	 * return vrai si la profondeur est compris entre 0 et 3 inclut et faux sinon
	 */
	private boolean isCorrect(int profondeur){
		if(0<=profondeur && profondeur<=3) return true;
		return false;
	}

}
