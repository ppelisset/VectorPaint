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
	 * Ajoute un point dans la figure. La méthode renvoit true si la construction est fini et qu'on peut récupérer la figure et faux sinon
	 * @param topDistance
	 * @param leftDistance
	 * @return
	 * @throws ConstructorException
	 */
	public boolean addPoint(double topDistance, double leftDistance) throws ConstructorException;
	/**
	 * Methode appeler durant la construction de la figure à chaque déplacement de la souris
	 * Elle permet et dessiner ce que verra en temps réel l'utilisateur afin de lui donner un apercu de la figure qui
	 * serait construite si il cliquer à cette endroit
	 * @param v
	 * @param g
	 * @param mousePosX
	 * @param mousePosY
	 */
	public void paint(SceneView v, Graphics g, int mousePosX, int mousePosY);
	/**
	 * Permet de récupérer la figure créer
	 * @return
	 */
	public Figure getFigure();
	/**
	 * Methode de remise à zéro du constructeur. Il doit commencer une nouvelle figure
	 */
	public void reinit();
	/**
	 * Renvoit true si la construction à commencer (cette méthode permet d'éviter de redessiner l'écran à chaque modification si aucune forme n'est en cours de création)
	 * @return
	 */
	public boolean isBegin();
}
