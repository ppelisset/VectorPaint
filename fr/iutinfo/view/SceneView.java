package fr.iutinfo.view;

import fr.iutinfo.controller.MouseController;
import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Polygon;
import fr.iutinfo.model.Scene;
import fr.iutinfo.model.Figure;
import fr.iutinfo.model.VectorLine;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Classe d'affichage d'une scene
 * @author pierre
 */
public class SceneView extends JPanel implements Observer {
	protected Scene _scene;
	protected MouseController _controller;
	
	/**
	 * Crée une scene
	 * @param scene
	 */
	public SceneView(Scene scene) {
		_scene = scene;
		_controller = new MouseController(this);
		addMouseListener(_controller);
	}

	/**
	 * Methode d'affichage d'une scene
	 */
	public void paintComponent(Graphics g) {
		// On ajoute un fond blanc
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		
		// On affiche tout les éléments qui existe déjà
		ArrayList<Figure> listFigure;
		for(int i = 0; i < 4; i++) {
			listFigure = _scene.getProfondeurFigure(i);
			
			for(Figure f : listFigure) {
				if(f instanceof VectorLine) {
					(new VectorView(((VectorLine)f))).paint(this, g);
				} else if(f instanceof Circle) {
					(new CircleView(((Circle)f))).paint(this, g);
				} else if(f instanceof Polygon) {
					(new PolygoneView(((Polygon)f))).paint(this, g);
				}
			}
		}
		
		// On dessine l'élément qu'on est en train de créer
		if(_controller.getCurrentConstructor() != null) {
			_controller.getCurrentConstructor().paint(this, g, _controller.getPosX(), _controller.getPosY());
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	public Scene getScene() {
		return _scene;
	}

	public MouseController getMouseController() {
		return _controller;
	}
}
