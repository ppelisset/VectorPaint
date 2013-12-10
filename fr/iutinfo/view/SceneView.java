package fr.iutinfo.view;

import fr.iutinfo.controller.MouseCreateController;
import fr.iutinfo.librairies.MyObservable;
import fr.iutinfo.librairies.MyObserver;
import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Polygon;
import fr.iutinfo.model.Scene;
import fr.iutinfo.model.Figure;
import fr.iutinfo.model.VectorLine;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

/**
 * Classe d'affichage d'une scene
 * @author pierre
 */
public class SceneView extends JPanel implements MyObserver {
	protected Scene _scene;
	protected MouseListener _controller;
	protected HashMap<Figure, Printable> _map;
	Figure _selectedFigure;
	public final int POINT_SIZE = 5;
	public final int ERROR_MARGE = 5;

	/**
	 * Cr�e une scene
	 * @param scene
	 */
	public SceneView(Scene scene) {
		_scene = scene;
		_map = new HashMap<Figure, Printable>();
		_controller = new MouseCreateController(this);
		addMouseListener(_controller);
	}

	/**
	 * Methode d'affichage d'une scene
	 */
	public void paintComponent(Graphics g) {
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		// On ajoute un fond blanc
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);

		// On affiche tout les �l�ments qui existe d�j�
		ArrayList<Figure> listFigure;
		Printable p;
		for(int i = 0; i < 4; i++) {
			listFigure = _scene.getProfondeurFigure(i);

			for(Figure f : listFigure) {
				p = _map.get(f);
				if(p == null) {
					update(_scene, f);
					p = _map.get(f);
				}
				p.paint(this, g);
			}
		}

		// On dessine l'�l�ment qu'on est en train de cr�er (si il y en a un)
		g.setColor(Color.black);
		if(_controller instanceof MouseCreateController && ((MouseCreateController)_controller).getCurrentConstructor() != null) {
			((MouseCreateController)_controller).getCurrentConstructor().paint(this, g, ((MouseCreateController)_controller).getPosX(), ((MouseCreateController)_controller).getPosY());
		}
		
		// On dessine les �l�ments de selection
		if(getSelectedFigure() != null) {
			p = _map.get(getSelectedFigure());
			int nb = p.getNbPoint();
			int x[] = p.getXPoint(this);
			int y[] = p.getYPoint(this);
			g.setColor(Color.ORANGE);
			for(int i = 0; i < nb; i++) {
				g.fillOval(x[i]-POINT_SIZE, y[i]-POINT_SIZE, POINT_SIZE*2, POINT_SIZE*2);
			}
		}
	}

	public Scene getScene() {
		return _scene;
	}

	@Override
	public void update(MyObservable observable, Figure modified) {
		System.out.println("Appeler pour : " + modified);
		if(!_map.containsKey(modified)) {
			Printable p = null;
			if(modified instanceof VectorLine) {
				p = new VectorView((VectorLine)modified);
			} else if(modified instanceof Circle) {
				p = new CircleView((Circle)modified);
			} else if(modified instanceof Polygon) {
				p = new PolygoneView((Polygon)modified);
			}
			if(p != null) _map.put(modified, p);
		}
		this.repaint();
	}

	public Figure getSelectedFigure(int x, int y) {
		// On teste tout les �l�ments qui sont pr�sent
		ArrayList<Figure> listFigure;
		Printable p;
		Figure selectedFigure = null;
		for(int i = 3; i >= 0; i--) {
			listFigure = _scene.getProfondeurFigure(i);

			for(Figure f : listFigure) {
				p = _map.get(f);
				if(p == null) {
					update(_scene, f);
					p = _map.get(f);
				}
				if(p.isSelect(this, x, y)) {
					selectedFigure = f;
				}
			}
		}
		return selectedFigure;
	}
	
	public Point getSelectedPoint(Figure f, int x, int y) {
		if(_map.containsKey(f)) {
			return _map.get(f).getPoint(this, x, y);
		}
		return null;
	}
	
	public MouseListener getMouseListener() {
		return _controller;
	}
	
	public void setMouseListener(MouseListener listener) {
		if(_controller != null) removeMouseListener(_controller);
		_controller = listener;
		addMouseListener(_controller);
	}

	public Figure getSelectedFigure() {
		return _selectedFigure;
	}

	public void setSelectedFigure(Figure _selectedFigure) {
		this._selectedFigure = _selectedFigure;
	}

	/**
	 * G�re la vitesse de d�placement au clavier
	 * TODO : Modifier pour la faire diff�rer en fonction de la taille de la fen�tre
	 * @return
	 */
	public double getSpeed() {
		return  1;
	}
}
