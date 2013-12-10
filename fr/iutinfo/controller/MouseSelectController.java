package fr.iutinfo.controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.iutinfo.model.Figure;
import fr.iutinfo.view.SceneView;

public class MouseSelectController implements MouseListener, MouseMotionListener, KeyListener {
	private SceneView _scene;
	private int _posX, _posY;
	private boolean _inMove = false;
	private int _startX, _startY;

	/**
	 * Crée un gestionnaire de la souris qui s'occupe de la souris pour la selection et le déplacement de figure sur la sceneView
	 * @param v
	 */
	public MouseSelectController(SceneView v) {
		_scene = v;
		v.addMouseMotionListener(this);
		v.addKeyListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent ev) {
		// Si on est en train de déplacer une forme, on la déplace
		if(_inMove) {
			int decX = _startX - ev.getX();
			int decY = _startY - ev.getY();
			double x, y;
			x = (((double)decX)/_scene.getWidth())*100;
			y = (((double)decY)/_scene.getHeight())*100;
			
			_scene.getSelectedFigure().move(Figure.GO_LEFT, x);
			_scene.getSelectedFigure().move(Figure.GO_UP, y);
			_scene.repaint();
			_startX = ev.getX();
			_startY = ev.getY();
		}
	}

	@Override
	public void mouseMoved(MouseEvent ev) {
		_posX = ev.getX();
		_posY = ev.getY();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		_scene.requestFocusInWindow();	
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
		// Quand on enfonce le bouton de la souris, on vérifie plusieurs choses :
		// - Si une figure et séléctionné et que l'appuie sur une touche est faite sur la même, on démarre un déplacement
		// - Si une nouvelle figure est séléctionné, on déséléctionne l'ancienne et on séléctionne l'ancienne
		// - Si aucune figure est séléctionné, on désélectionne celle qui l'était
		Figure selectedFigure = _scene.getSelectedFigure(ev.getX(), ev.getY());
		if(selectedFigure != null && selectedFigure == _scene.getSelectedFigure()) {
			_inMove = true;
			_startX = ev.getX();
			_startY = ev.getY();
		} else if(selectedFigure != null) {
			_inMove = false;
			selectedFigure.setSelected(true);
			if(_scene.getSelectedFigure() != null) _scene.getSelectedFigure().setSelected(false);
			_scene.setSelectedFigure(selectedFigure);
			_scene.repaint();
		} else {
			_inMove = false;
			if(_scene.getSelectedFigure() != null) _scene.getSelectedFigure().setSelected(false);
			_scene.setSelectedFigure(null);
			_scene.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		// Si on fesait un mouvement lors du relachement de la souris, on le termine
		if(_inMove) {
			int decX = _startX - ev.getX();
			int decY = _startY - ev.getY();
			double x, y;
			x = (((double)decX)/_scene.getWidth())*100;
			y = (((double)decY)/_scene.getHeight())*100;
			
			_scene.getSelectedFigure().move(Figure.GO_LEFT, x);
			_scene.getSelectedFigure().move(Figure.GO_UP, y);
			_scene.repaint();
		}
		_inMove = false;
	}
	
	@Override
	public void keyPressed(KeyEvent ev) {
		if(_scene.getSelectedFigure() != null) {
			System.out.println("KeyCode : " + ev.getKeyCode());
			if(ev.getKeyCode() == KeyEvent.VK_UP) {
				_scene.getSelectedFigure().move(Figure.GO_UP, _scene.getSpeed());
				_scene.repaint();
			} else if(ev.getKeyCode() == KeyEvent.VK_DOWN) {
				_scene.getSelectedFigure().move(Figure.GO_DOWN, _scene.getSpeed());
				_scene.repaint();
			} else if(ev.getKeyCode() == KeyEvent.VK_LEFT) {
				_scene.getSelectedFigure().move(Figure.GO_LEFT, _scene.getSpeed());
				_scene.repaint();
			} else if(ev.getKeyCode() == KeyEvent.VK_RIGHT) {
				_scene.getSelectedFigure().move(Figure.GO_RIGHT, _scene.getSpeed());
				_scene.repaint();
			} else if(ev.getKeyCode() == KeyEvent.VK_DELETE || ev.getKeyCode() == 8) {
				_scene.getScene().removeFigure(_scene.getSelectedFigure());
				_scene.setSelectedFigure(null);
				_scene.repaint();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}

}
