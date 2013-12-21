package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import fr.iutinfo.model.Circle;

/**
 * Classe d'affichage d'un cercle
 * 
 * @author pierre TODO : A coder
 */
public class CircleView implements Printable {
	private Circle _circle;

	public CircleView(Circle c) {
		_circle = c;
	}

	@Override
	public void paint(SceneView v, Graphics g) {
		int x, y, size;
		
		size = (int) ((_circle.getDiametre()*v.getWidth())/100);
		x = (int) ((_circle.getCentre().getLeft()*v.getWidth())/100);
		y = (int) ((_circle.getCentre().getTop()*v.getHeight())/100);
		
		x -= size;
		y -= size;
		
		g.setColor(_circle.getColor());
		if(_circle.isFill()) {
			g.fillOval(x, y, size*2, size*2);
		} else {
			g.drawOval(x, y, size*2, size*2);
		}
		
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int cx, cy, size;
		cx = (int) ((_circle.getCentre().getLeft()*v.getWidth())/100);
		cy = (int) ((_circle.getCentre().getTop()*v.getHeight())/100);
		size = (int) ((_circle.getDiametre()*v.getWidth())/100);
		
		int diffX, diffY, diffSize;
		diffX = Math.abs(x-cx);
		diffY = Math.abs(y-cy);
		diffSize = (int) Math.sqrt(Math.pow(diffX, 2)+Math.pow(diffY, 2));
		
		return (diffSize <= size);
	}

	@Override
	public int getNbPoint() {
		return 2;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int x, size;
		size = (int) ((_circle.getDiametre()*v.getWidth())/100);
		x = (int) ((_circle.getCentre().getLeft()*v.getWidth())/100);
		int tab[] = new int[2];
		tab[0] = x;
		tab[1] = x + size;
		return tab;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int y = (int) ((_circle.getCentre().getTop()*v.getHeight())/100);
		int tab[] = {y,y};
		return tab;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int diffX, diffY, min = scene.ERROR_MARGE*2+1, nbMin = -1;
		for(int i = 0; i < this.getNbPoint(); i++) {
			diffX = Math.abs(this.getXPoint(scene)[i]-x);
			diffY = Math.abs(this.getYPoint(scene)[i]-y);
			if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE && diffX+diffY < min) {
				min = diffX+diffY;
				nbMin = i;
			}
		}
		if(nbMin == -1) return null;
		else return new Point(this.getXPoint(scene)[nbMin], this.getYPoint(scene)[nbMin]);
	}

}