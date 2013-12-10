package fr.iutinfo.view.manager;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.iutinfo.constructor.PolygonConstructor;
import fr.iutinfo.constructor.VectorLineConstructor;
import fr.iutinfo.controller.MouseCreateController;
import fr.iutinfo.controller.manager.SetContructorListener;
import fr.iutinfo.controller.manager.SetSelectListener;
import fr.iutinfo.view.SceneView;

/**
 * Pannel (normalement provisoire) qui permet de changer d'outils
 * @author pierre
 */
public class ControllerPanel extends JPanel {
	private JButton _modeLine, _modePolygone, _modeSelect;
	
	public ControllerPanel(SceneView sv) {
		MouseCreateController mcc;
		_modeLine = new JButton("Ligne");
		_modePolygone = new JButton("Polygone");
		_modeSelect = new JButton("Select");
		_modeLine.addActionListener(new SetContructorListener(sv, new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(sv, new PolygonConstructor()));
		_modeSelect.addActionListener(new SetSelectListener(sv));
		setLayout(new GridLayout(0, 1));
		
		add(_modeLine);
		add(_modePolygone);
		add(_modeSelect);
	}
}
