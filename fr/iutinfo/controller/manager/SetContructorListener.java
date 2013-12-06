package fr.iutinfo.controller.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutinfo.constructor.Constructor;
import fr.iutinfo.controller.MouseController;

/**
 * Controller (normalement provisoire) de gestion d'un constructeur de figure (permet de changer le constructeur lorsqu'on clique sur un bouton)
 * @author pierre
 */
public class SetContructorListener implements ActionListener {
	private Constructor _constructor;
	private MouseController _mouseController;
	
	public SetContructorListener(MouseController mc, Constructor c) {
		_constructor = c;
		_mouseController = mc;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_mouseController.setConstructor(_constructor);
	}

}
