package fr.iutinfo.librairies;

import fr.iutinfo.model.Figure;

public interface MyObserver {
	public void update(MyObservable observable, Figure modified);
}
