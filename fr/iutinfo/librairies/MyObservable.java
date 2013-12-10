package fr.iutinfo.librairies;

import java.util.ArrayList;

import fr.iutinfo.model.Figure;

public class MyObservable {
	private Figure _message;
	private ArrayList<MyObserver> _observer = new ArrayList<MyObserver>();
	
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
	
	public void addObserver(MyObserver obs) {
		if(!_observer.contains(obs)) {
			_observer.add(obs);
		}
	}
}
