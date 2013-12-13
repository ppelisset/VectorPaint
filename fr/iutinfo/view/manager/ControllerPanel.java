package fr.iutinfo.view.manager;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.iutinfo.controller.MouseAdapterDeux;
import fr.iutinfo.constructor.PolygonConstructor;
import fr.iutinfo.constructor.VectorLineConstructor;
import fr.iutinfo.controller.MouseCreateController;
import fr.iutinfo.controller.manager.SetContructorListener;
import fr.iutinfo.controller.manager.SetSelectListener;
import fr.iutinfo.model.Figure;
import fr.iutinfo.view.SceneView;

/**
 * Pannel (normalement provisoire) qui permet de changer d'outils
 * 
 * @author pierre
 */
public class ControllerPanel extends JPanel {
	private JButton _modeLine, _modePolygone, _modeSelect;
	private JList _listeColorButton;
	private ColorButton _red, _blue, _green, _yellow, _black;

	@SuppressWarnings("unchecked")
	public ControllerPanel(SceneView sv) {
		MouseCreateController mcc;
		_red = new ColorButton(Color.RED, "red");
		_blue = new ColorButton(Color.BLUE, "blue");
		_green = new ColorButton(Color.GREEN, "green");
		_yellow = new ColorButton(Color.YELLOW, "yellow");
		_black = new ColorButton(Color.BLACK, "black");
		_modeLine = new JButton("Ligne");
		_modePolygone = new JButton("Polygone");
		_modeSelect = new JButton("Select");

		_listeColorButton = new JList(new ColorButton[] { _red, _blue, _green,
				_yellow, _black });
		_modeLine.addActionListener(new SetContructorListener(sv,
				new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(sv,
				new PolygonConstructor()));
		_modeSelect.addActionListener(new SetSelectListener(sv));
		setLayout(new GridLayout(0, 1));
		_listeColorButton.addMouseListener(new MouseAdapterDeux(sv) {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();

				try {
					if (evt.getClickCount() == 2) {
						this._sv.setColor((((ColorButton) list
								.getSelectedValue()).getColor()));
						
						
						PolygonConstructor.setColor(((ColorButton) list.getSelectedValue())
								.getColor());
						
					} else if (evt.getClickCount() == 1) {
						this._sv.setColor((((ColorButton) list
								.getSelectedValue()).getColor()));
						this._sv.getSelectedFigure().setColor(
								(((ColorButton) list.getSelectedValue())
										.getColor()));
					}
				} catch (Exception e) {
					System.err.println("No Figure selected");
				}

			}
		});

		add(_modeLine);
		add(_modePolygone);
		add(_modeSelect);
		add(_listeColorButton);
	}
}
