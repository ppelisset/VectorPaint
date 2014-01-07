package fr.iutinfo.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import fr.iutinfo.constructor.Constructor;
import fr.iutinfo.constructor.ConstructorException;
import fr.iutinfo.interfaces.ColorButton;
import fr.iutinfo.view.SceneView;

/**
 * Gestionnaire de la souris
 * 
 * @author pierre
 */
public class MouseController implements MouseListener, MouseMotionListener {
	protected SceneView _scene;

	/**
	 * Cree un gestionnaire de la souris qui s'occupe de la souris pour toute la
	 * SceneView
	 * 
	 * @param v
	 */
	public MouseController(SceneView v) {
		_scene = v;
		v.addMouseMotionListener(this);
	}

	@Override
	/**
	 * Methode appeler lors d'un clic de souris
	 * @param evt
	 */
	public void mouseClicked(MouseEvent evt) {
		ColorButton bouton = (ColorButton) evt.getSource();

		if (evt.getClickCount() == 2) {
			this._scene.setColor((bouton.getColor()));

		} else if (evt.getClickCount() == 1) {
			if(this._scene.getSelectedFigure() != null) {
				this._scene.getSelectedFigure().setColor(bouton.getColor());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent ev) {}

	@Override
	public void mouseReleased(MouseEvent ev) {}

	@Override
	public void mouseDragged(MouseEvent ev) {}

	@Override
	public void mouseMoved(MouseEvent ev) {}


}
