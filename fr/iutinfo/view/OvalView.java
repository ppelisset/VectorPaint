package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import fr.iutinfo.model.Oval;

/**
 * Classe d'affichage d'un cercle
 * 
 * @author pierre TODO : A coder
 */
public class OvalView implements Printable {
	private Oval _oval;

	public OvalView(Oval o) {
		_oval = o;
	}

	@Override
	public void paint(SceneView v, Graphics g) {
		int x, y, sizeX, sizeY;
		
		sizeX = (int) ((_oval.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_oval.getDiametreY() * v.getHeight()) / 100);
		x = (int) ((_oval.getCentre().getLeft() * v.getWidth()) / 100);
		y = (int) ((_oval.getCentre().getTop() * v.getHeight()) / 100);
		
		
		x-=sizeX;
		y-=sizeY;
		g.setColor(_oval.getColor());
		if (_oval.isFill()) {
			
			g.fillOval(x,y, sizeX*2, sizeY*2);
		} else {
			g.drawOval(x,y, sizeX*2, sizeY*2);
		}

	}


	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int cx, cy, sizeX, sizeY;
		cx = (int) ((_oval.getCentre().getLeft() * v.getWidth()) / 100);
		cy = (int) ((_oval.getCentre().getTop() * v.getHeight()) / 100);
		sizeX = (int) ((_oval.getDiametreX() * v.getWidth()) / 100);
		sizeY = (int) ((_oval.getDiametreY() * v.getHeight()) / 100);
		cx -= sizeX;
		cy -= sizeY;
		Ellipse2D e = new Ellipse2D.Double(cx-sizeX, cy-sizeY,sizeX * 2,
				sizeY * 2);

		return e.contains(x, y);
	}

	@Override
	public int getNbPoint() {
		return 3;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int x, sizeX;
		sizeX = (int) ((_oval.getDiametreX() * v.getWidth()) / 100);
		x = (int) ((_oval.getCentre().getLeft() * v.getWidth()) / 100);
		
		
		int tab[] = new int[3];
		tab[0] = x;
		tab[1] = x + sizeX;
		tab[2] = x;
		return tab;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int  y,sizeY;
		sizeY = (int) ((_oval.getDiametreY() * v.getHeight()) / 100);
		y = (int) ((_oval.getCentre().getTop() * v.getHeight()) / 100);

		int tab[] = { y, y, y- sizeY};
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