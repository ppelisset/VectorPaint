package fr.iutinfo.view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import fr.iutinfo.model.Circle;

/**
 * Classe d'affichage d'un cercle
 * @author pierre
 * TODO : A coder
 */
public class CircleView implements Printable {
	private Circle _circle;
	
	public CircleView(Circle c) {
		_circle = c;
	}
	

	@Override
	public void paint(SceneView v, Graphics g) {
		
	}

}