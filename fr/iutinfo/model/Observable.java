package fr.iutinfo.model;

public class Observable extends java.util.Observable {
	/**
	 * Notifie les observers
	 */
	protected void notifyObs() {
		setChanged();
		notifyObservers();
	}
}
