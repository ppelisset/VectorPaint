package fr.iutinfo.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import fr.iutinfo.view.SceneView;

public class FillButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Page _current;
	private boolean _fill;
	/**
	 * constructeur qui gere la transparence des figures selectionnee
	 * @param current
	 * @param isFill
	 */
	public FillButton(Page current, boolean isFill) {
		_current = current;
		_fill = isFill;
		if(isFill) setIcon(new ImageIcon(getClass().getResource("icons/filled.png")));
		else setIcon(new ImageIcon(getClass().getResource("icons/empty.png")));
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SceneView s = ((Onglet)_current.getSelectedComponent()).getSceneView();
				if(s.getSelectedFigure() != null) {
					s.getSelectedFigure().setFill(_fill);
				}
			}
		});
	}
}
