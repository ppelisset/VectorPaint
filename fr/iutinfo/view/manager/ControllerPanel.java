package fr.iutinfo.view.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutinfo.constructor.PolygonConstructor;
import fr.iutinfo.constructor.VectorLineConstructor;
import fr.iutinfo.controller.manager.SetContructorListener;
import fr.iutinfo.view.SceneView;

/**
 * Pannel (normalement provisoire) qui permet de changer d'outils
 * @author pierre
 */
public class ControllerPanel extends JPanel {
	private JButton _modeLine, _modePolygone;
	
	public ControllerPanel(SceneView sv) {
		_modeLine = new JButton("Ligne");
		_modePolygone = new JButton("Polygone");
		
		_modeLine.addActionListener(new SetContructorListener(sv.getMouseController(), new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(sv.getMouseController(), new PolygonConstructor()));
		
		setLayout(new GridLayout(0, 1));
		
		add(_modeLine);
		add(_modePolygone);
	}
}
