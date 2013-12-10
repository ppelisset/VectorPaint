package fr.iutinfo.controller.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutinfo.controller.MouseSelectController;
import fr.iutinfo.view.SceneView;

public class SetSelectListener implements ActionListener {
	private SceneView _scene;

	public SetSelectListener(SceneView sv) {
		_scene = sv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		_scene.setSelectedFigure(null);
		if(!(_scene.getMouseListener() instanceof MouseSelectController)) {
			_scene.setMouseListener(new MouseSelectController(_scene));
		}
	}

}
