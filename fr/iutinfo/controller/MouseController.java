package fr.iutinfo.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import fr.iutinfo.constructor.Constructor;
import fr.iutinfo.constructor.ConstructorException;
import fr.iutinfo.view.SceneView;

/**
 * Gestionnaire de la souris
 * @author pierre
 */
public class MouseController implements MouseListener, MouseMotionListener {
	Constructor _constructor;
	SceneView _scene;
	int _posX, _posY;
	
	/**
	 * Cr�e un gestionnaire de la souris qui s'occupe de la souris pour toute la SceneView
	 * @param v
	 */
	public MouseController(SceneView v) {
		_scene = v;
		v.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent ev) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		if(_constructor == null) return;
		if(SwingUtilities.isRightMouseButton(ev)) {
			_constructor.reinit();
			_scene.repaint();
			return;
		}
		System.out.println("Clique : " + ev.getY() + "," + ev.getX());
		double topDistance = ((double)(ev.getY()*100))/_scene.getHeight();
		double leftDistance = ((double)(ev.getX()*100))/_scene.getWidth();
		System.out.println("top : " + topDistance + " left : " + leftDistance);
		boolean finish = false;
		try {
			finish = _constructor.addPoint(topDistance, leftDistance);
		} catch (ConstructorException e) {
			e.printStackTrace();
		}
		if(finish) {
			System.out.println("Fini");
			_scene.getScene().addFigure(0, _constructor.getFigure());
			_scene.repaint();
			_constructor.reinit();
		}
	}

	@Override
	public void mouseReleased(MouseEvent ev) {

	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		mouseMoved(ev);
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		_posX = ev.getX();
		_posY = ev.getY();
		if(_constructor != null && _constructor.isBegin()) {
			_scene.repaint();
		}
	}

	public int getPosX() {
		return _posX;
	}

	public int getPosY() {
		return _posY;
	}
	
	public Constructor getCurrentConstructor() {
		return _constructor;
		
	}

	public void setConstructor(Constructor c) {
		_constructor = c;
	}

}
