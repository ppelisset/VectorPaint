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
	private boolean _inMove = false;
	private int _startX, _startY;
	private boolean _inResize = false;
	private double _beginTop, _beginLeft;
	private boolean _ctrl;

	/**
	 * Cree un gestionnaire de la souris qui s'occupe de la souris pour la selection et le deplacement de figure sur la sceneView
	 * @param v
	 */
	public MouseSelectController(SceneView v) {
		_scene = v;
		v.addMouseMotionListener(this);
		v.addKeyListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent ev) {
		if(_inResize) {
			double endTop, endLeft;
			endLeft = (((double)ev.getX())/_scene.getWidth())*100;
			endTop = (((double)ev.getY())/_scene.getHeight())*100;
			_scene.getSelectedFigure().resize(_beginTop, _beginLeft, endTop, endLeft);
			_beginTop = endTop;
			_beginLeft = endLeft;
		}
		// Si on est en train de deplacer une forme, on la deplace
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
	public void mouseMoved(MouseEvent ev) {}

	@Override
	public void mouseClicked(MouseEvent ev) {
		_scene.requestFocusInWindow();	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent ev) {
		// Quand on enfonce le bouton de la souris, on verifie plusieurs choses :
		// - Si une figure et selectionne et que l'appuie sur une touche est faite sur la m�me, on d�marre un d�placement
		// - Si une nouvelle figure est selectionne, on deselectionne l'ancienne et on selectionne la nouvelle
		// - Si aucune figure est selectionne, on deselectionne celle qui l'etait
		if(_scene.getSelectedFigure() != null) {
			Point p = _scene.getSelectedPoint(_scene.getSelectedFigure(), ev.getX(), ev.getY());
			if(p != null) {
				_beginLeft = (((double)p.getX())/_scene.getWidth())*100;
				_beginTop = (((double)p.getY())/_scene.getHeight())*100;
				_inResize = true;
				return;
			}
		}
		_inResize = false;
		Figure selectedFigure = _scene.getSelectedFigure(ev.getX(), ev.getY());
		if(selectedFigure != null && selectedFigure == _scene.getSelectedFigure()) {
			_inMove = true;
			_startX = ev.getX();
			_startY = ev.getY();
		} else if(selectedFigure != null) {
			_inMove = false;
			_scene.setSelectedFigure(selectedFigure);
			_scene.repaint();
		} else {
			_inMove = false;
			_scene.setSelectedFigure(null);
			_scene.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		if(_inResize) {
			double endTop, endLeft;
			endLeft = (((double)ev.getX())/_scene.getWidth())*100;
			endTop = (((double)ev.getY())/_scene.getHeight())*100;
			_scene.getSelectedFigure().resize(_beginTop, _beginLeft, endTop, endLeft);
		}
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
		_inResize = false;
	}
	
	@Override
	public void keyPressed(KeyEvent ev) {
		if(_scene.getSelectedFigure() != null) {
			if(ev.getKeyCode() == KeyEvent.VK_UP) {
				_scene.getSelectedFigure().move(Figure.GO_UP, _scene.getSpeed());
			} else if(ev.getKeyCode() == KeyEvent.VK_DOWN) {
				_scene.getSelectedFigure().move(Figure.GO_DOWN, _scene.getSpeed());
			} else if(ev.getKeyCode() == KeyEvent.VK_LEFT) {
				_scene.getSelectedFigure().move(Figure.GO_LEFT, _scene.getSpeed());
			} else if(ev.getKeyCode() == KeyEvent.VK_RIGHT) {
				_scene.getSelectedFigure().move(Figure.GO_RIGHT, _scene.getSpeed());
			} else if(ev.getKeyCode() == KeyEvent.VK_DELETE || ev.getKeyCode() == 8) {
				_scene.getScene().removeFigure(_scene.getSelectedFigure());
				_scene.setSelectedFigure(null);
			}
		}
		if(ev.getKeyCode() == 17) {
			_ctrl = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent ev) {
		if(ev.getKeyCode() == 17) {
			_ctrl = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent ev) {}

}
