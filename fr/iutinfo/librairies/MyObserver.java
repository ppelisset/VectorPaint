package fr.iutinfo.librairies;

import fr.iutinfo.model.Figure;

/**
 * Interface implementant le design pattern observer prennant en parametre une figure
 * @see fr.iutinfo.librairies.MyObservable
 */
public interface MyObserver {
	public void update(MyObservable observable, Figure modified);
}
