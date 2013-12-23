package fr.iutinfo.view;

import fr.iutinfo.controller.MouseCreateController;
import fr.iutinfo.librairies.MyObservable;
import fr.iutinfo.librairies.MyObserver;
import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Polygon;
import fr.iutinfo.model.Rectangle;
import fr.iutinfo.model.Scene;
import fr.iutinfo.model.Figure;
import fr.iutinfo.model.VectorLine;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Classe d'affichage d'une scene
 * @author pierre
 */
public class SceneView extends JPanel implements MyObserver {
	private static final long serialVersionUID = 6846502414478651296L;
	protected Color _couleur ;
	protected Scene _scene;
	protected MouseListener _controller;
	protected HashMap<Figure, Printable> _map;
	Figure _selectedFigure;
	public final int POINT_SIZE = 5;
	public final int ERROR_MARGE = 5;

	
	/**
	 * Cree la vue de la scene passe en parametre
	 * @param scene
	 */
	public SceneView(Scene scene) {
		_scene = scene;
		_map = new HashMap<Figure, Printable>();
		_controller = new MouseCreateController(this);
		_couleur= Color.BLACK;
		scene.addObserver(this);
		addMouseListener(_controller);
	}
	
	public void setColor(Color col){
		this._couleur=col;
	}
	public Color getColor(){
		return this._couleur;
	}
	/**
	 * Methode d'affichage d'une scene
	 */
	public void paintComponent(Graphics g) {
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		// On ajoute un fond blanc
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(_couleur);

		// On affiche tout les elements qui existe deja
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
				System.out.println("Affichage : " + f);
				p.paint(this, g);
			}
		}

		// On dessine l'element qu'on est en train de creer (si il y en a un)
		g.setColor(_couleur);
		if(_controller instanceof MouseCreateController && ((MouseCreateController)_controller).getCurrentConstructor() != null) {
			((MouseCreateController)_controller).getCurrentConstructor().paint(this, g, ((MouseCreateController)_controller).getPosX(), ((MouseCreateController)_controller).getPosY());
		}
		
		// On dessine les ronds de selection
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

	/**
	 * Permet de r�cuperer la scene afficher par la scene view
	 * @return
	 */
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
			} else if(modified instanceof Rectangle) {
				p = new RectangleView((Rectangle)modified);
			}
			if(p != null) _map.put(modified, p);
		}
		this.repaint();
	}

	/**
	 * Permet de r�cup�rer la figure se trouvant au point (x,y)
	 * @param x
	 * @param y
	 * @return
	 */
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
	
	/**
	 * Permet de r�cup�rer le point de la figure f se trouvant aux coordonn�s (x,y)
	 * @param f
	 * @param x
	 * @param y
	 * @return
	 */
	public Point getSelectedPoint(Figure f, int x, int y) {
		if(_map.containsKey(f)) {
			return _map.get(f).getPoint(this, x, y);
		}
		return null;
	}
	
	/**
	 * Recupere le MouseListener du pannel
	 * @return
	 */
	public MouseListener getMouseListener() {
		return _controller;
	}
	
	/**
	 * Modifie le MouseListener du pannel
	 * @param listener
	 */
	public void setMouseListener(MouseListener listener) {
		if(_controller != null) removeMouseListener(_controller);
		_controller = listener;
		addMouseListener(_controller);
	}

	/**
	 * Recup�re la figure s�l�ctionn� dans le pannel
	 * @return
	 */
	public Figure getSelectedFigure() {
		return _selectedFigure;
	}

	/**
	 * Change la figure selectionn� dans le pannel
	 * @param _selectedFigure
	 */
	public void setSelectedFigure(Figure _selectedFigure) {
		this._selectedFigure = _selectedFigure;
		this.repaint();
	}

	/**
	 * Gere la vitesse de deplacement au clavier
	 * TODO : Modifier pour la faire differer en fonction de la taille de la fenetre
	 * @return
	 */
	public double getSpeed() {
		return  1;
	}
}
