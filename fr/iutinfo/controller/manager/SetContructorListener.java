package fr.iutinfo.controller.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutinfo.constructor.Constructor;
import fr.iutinfo.controller.MouseCreateController;
import fr.iutinfo.view.SceneView;

/**
 * Controller de gestion d'un constructeur de figure (permet de changer le constructeur lorsqu'on clique sur un bouton)
 * @author pierre
 */
public class SetContructorListener implements ActionListener {
	private Constructor _constructor;
	private SceneView _scene;
	
	public SetContructorListener(SceneView sv, Constructor c) {
		_constructor = c;
		_scene = sv;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		_scene.setSelectedFigure(null);
		if(!(_scene.getMouseListener() instanceof MouseCreateController)) {
			_scene.setMouseListener(new MouseCreateController(_scene));
		}
		((MouseCreateController)_scene.getMouseListener()).setConstructor(_constructor);
	}
}
