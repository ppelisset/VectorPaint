package fr.iutinfo.constructor;

import java.awt.Graphics;
import fr.iutinfo.view.SceneView;
import fr.iutinfo.model.Figure;

/**
 * Interface de gestion d'un constructeur de forme
 * @author pierre
 */
public interface Constructor {
	/**
	 * Ajoute un point dans la figure. La methode renvoit true si la construction est fini et qu'on peut recuperer la figure et faux sinon
	 * @param topDistance
	 * @param leftDistance
	 * @return
	 * @throws ConstructorException
	 */
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException;
	/**
	 * Methode appeler durant la construction de la figure a chaque deplacement de la souris
	 * Elle permet et dessiner ce que verra en temps reel l'utilisateur afin de lui donner un apercu de la figure qui
	 * serait construite si il cliquer a cette endroit
	 * @param v
	 * @param g
	 * @param mousePosX
	 * @param mousePosY
	 */
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY);
	/**
	 * Permet de recuperer la figure creer
	 * @return
	 */
	public Figure getFigure();
	/**
	 * Methode de remise a zero du constructeur. Il doit commencer une nouvelle figure
	 */
	public void reinit();
	/**
	 * Renvoit true si la construction a commencer (cette methode permet d'eviter de redessiner l'ecran à chaque modification si aucune forme n'est en cours de creation)
	 * @return
	 */
	public boolean isBegin();
}
