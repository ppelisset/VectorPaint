package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import fr.iutinfo.model.Circle;
import fr.iutinfo.model.Scene;

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


	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getNbPoint() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int[] getXPoint(SceneView v) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int[] getYPoint(SceneView v) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

}