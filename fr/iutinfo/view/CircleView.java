package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import fr.iutinfo.model.Circle;

/**
 * Classe d'affichage d'un cercle
 * 
 * @author pierre TODO : A coder
 */
public class CircleView implements Printable {
	private Circle _circle;
	/**
	 * Methode de creation de la vue associée à un model de cercle
	 * @param c
	 */
	public CircleView(Circle c) {
		_circle = c;
	}

	@Override
	public void paint(SceneView v, Graphics g) {
		int x, y, sizeX, sizeY;

		sizeX = (int) ((_circle.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_circle.getDiametreY() * v.getHeight()) / 100);
		x = (int) ((_circle.getCentre().getLeft() * v.getWidth()) / 100);
		y = (int) ((_circle.getCentre().getTop() * v.getHeight()) / 100);
	
		int hypo = pythagore(sizeX,sizeY);
		g.setColor(_circle.getColor());
		if (_circle.isFill()) {
			g.fillOval(x-(hypo),y-(hypo), hypo*2, hypo*2);
		} else {
			g.drawOval(x-(hypo),y-(hypo), hypo*2, hypo*2);
		}

	}
	/**
	 * Théorème de Pythagore
	 * @param a
	 * @param b
	 * @return
	 */
	public int pythagore(int a, int b) {
		return (int) (double) Math.sqrt(a * a + b * b);
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int cx, cy, sizeX, sizeY;
		cx = (int) ((_circle.getCentre().getLeft() * v.getWidth()) / 100);
		cy = (int) ((_circle.getCentre().getTop() * v.getHeight()) / 100);
		sizeX = (int) ((_circle.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_circle.getDiametreY() * v.getHeight()) / 100);

		int hypo = pythagore(sizeX,sizeY);
		Ellipse2D e = new Ellipse2D.Double(cx-hypo, cy-hypo, hypo * 2, hypo * 2);

		return e.contains(x, y);
	}

	@Override
	public int getNbPoint() {
		return 3;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int x, sizeX,sizeY;
		sizeX = (int) ((_circle.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_circle.getDiametreY() * v.getHeight()) / 100);
		x = (int) ((_circle.getCentre().getLeft() * v.getWidth()) / 100);
		
		int hypo = pythagore(sizeX,sizeY);
		
		int tab[] = new int[3];
		tab[0] = x;
		tab[1] = x + hypo;
		tab[2] = x;
		return tab;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int  sizeX,y,sizeY;
		sizeX = (int) ((_circle.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_circle.getDiametreY() * v.getHeight()) / 100);
		y = (int) ((_circle.getCentre().getTop() * v.getHeight()) / 100);
		int hypo = pythagore(sizeX,sizeY);

		int tab[] = { y, y, y- hypo};
		return tab;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int diffX, diffY, min = scene.ERROR_MARGE * 2 + 1, nbMin = -1;
		for (int i = 0; i < this.getNbPoint(); i++) {
			diffX = Math.abs(this.getXPoint(scene)[i] - x);
			diffY = Math.abs(this.getYPoint(scene)[i] - y);
			if (diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE
					&& diffX + diffY < min) {
				min = diffX + diffY;
				nbMin = i;
			}
		}
		if (nbMin == -1)
			return null;
		else
			return new Point(this.getXPoint(scene)[nbMin],
					this.getYPoint(scene)[nbMin]);
	}

}