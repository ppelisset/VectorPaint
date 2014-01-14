package fr.iutinfo.model;

import java.util.ArrayList;

import fr.iutinfo.librairies.MyObservable;
import fr.iutinfo.librairies.MyObserver;

/**
 * 
 * @author Vanneufville Matthieu
 *
 */
public class Scene extends MyObservable implements MyObserver {
	//--ATTRIBUTS--
	/**
	 * il sagit d'une ArrayList qui contient 4 ArrayList pour chaque niveau de profondeur.
	 */
	protected ArrayList<ArrayList<Figure>> listFigure;

	//--CONSTRUCTEURS--
	/**
	 * ce constructeur initialise les 2 ArrayList
	 */
	public Scene(){
		listFigure = new ArrayList<ArrayList<Figure>>();
		//boucle qui initialise les ArrayList dans les ArrayList
		for(int i=0; i<4; i++){
			listFigure.add(new ArrayList<Figure>());
		}
	}

	//--METHODES--
	/**
	 * ajoute une Figure dans l'ArrayList de profondeur voulue
	 */
	public void addFigure(int profondeur, Figure figure) {
		if(isCorrect(profondeur)) {
			listFigure.get(profondeur).add(figure);
			figure.addObserver(this);
			update(this, figure);
		}
	}

	/**
	 * change une Figure d'ArrayList
	 */
	public void setFigure(Figure figure, int profondeur) {
		if(isCorrect(profondeur)){
			for(int i=0; i<4; i++){
				listFigure.get(i).remove(figure);
			}
			listFigure.get(profondeur).add(figure);
		}
		notifyObs(figure);
	}

	/**
	 * return vrai si la profondeur est compris entre 0 et 3 inclut et faux sinon
	 */
	private boolean isCorrect(int profondeur){
		if(0<=profondeur && profondeur<=3) return true;
		return false;
	}

	/**
	 * Recupere un etage de figure
	 */
	public ArrayList<Figure> getProfondeurFigure(int profondeur){
		if(isCorrect(profondeur)){
			return listFigure.get(profondeur);
		}
		return null;
	}

	@Override
	public void update(MyObservable observable, Figure modified) {
		notifyObs(modified);
	}

	/**
	 * Permet de supprimer la figure passer en parametre
	 * @param figure
	 */
	public void removeFigure(Figure figure) {
		for(int i=0; i<4; i++){
			listFigure.get(i).remove(figure);
		}
		notifyObs(null);
	}
	
	/**
	 * Vide la scene
	 */
	public void clean() {
		for(ArrayList<Figure> list : listFigure) {
			list.clear();
		}
	}
}
