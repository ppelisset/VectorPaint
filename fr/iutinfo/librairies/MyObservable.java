package fr.iutinfo.librairies;

import java.util.ArrayList;

import fr.iutinfo.model.Figure;

/**
 * Classe pour le design pattern observable modifie afin de prendre une figure en parametre (permet de savoir quelle figure doit etre modifier dans la vue)
 *
 */
public class MyObservable {
	private Figure _message;
	private ArrayList<MyObserver> _observer = new ArrayList<MyObserver>();
	
	/**
	 * Change la figure passer en parametre
	 * @param msg
	 */
	public void setMessageFigure(Figure msg) {
		_message = msg;
	}
	
	/**
	 * Notifie les observers
	 */
	protected void notifyObs(Figure f) {
		setMessageFigure(f);
		notifyObservers();
	}

	private void notifyObservers() {
		for(MyObserver obs : _observer) {
			obs.update(this, _message);
		}
	}
	
	/**
	 * Ajoute une observateur
	 * @param obs
	 */
	public void addObserver(MyObserver obs) {
		if(!_observer.contains(obs)) {
			_observer.add(obs);
		}
	}
}
