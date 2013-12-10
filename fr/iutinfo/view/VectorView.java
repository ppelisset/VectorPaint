package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import fr.iutinfo.model.VectorLine;

/**
 * Classe d'affichage d'un VectorLine
 * @author pierre
 */
public class VectorView implements Printable {
	VectorLine _vector;
	
	public VectorView(VectorLine v) {
		_vector = v;
	}
	
	@Override
	public void paint(SceneView v, Graphics g) {
		int beginTop, beginLeft, endTop, endLeft;
		beginTop = (int) ((_vector.getVector().getTopDistance()*v.getHeight())/100);
		beginLeft = (int) ((_vector.getVector().getLeftDistance()*v.getWidth())/100);
		endTop = (int) ((_vector.getVector().getEndTopDistance()*v.getHeight())/100);
		endLeft = (int) ((_vector.getVector().getEndLeftDistance()*v.getWidth())/100);
		g.setColor(_vector.getColor());
		g.drawLine(beginLeft, beginTop, endLeft, endTop);
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int beginTop, beginLeft, endTop, endLeft;
		Polygon p = new Polygon();
		beginTop = (int) ((_vector.getVector().getTopDistance()*v.getHeight())/100);
		beginLeft = (int) ((_vector.getVector().getLeftDistance()*v.getWidth())/100);
		endTop = (int) ((_vector.getVector().getEndTopDistance()*v.getHeight())/100);
		endLeft = (int) ((_vector.getVector().getEndLeftDistance()*v.getWidth())/100);
		
		p.addPoint(beginLeft-5, beginTop-5);
		p.addPoint(endLeft-5, endTop-5);
		p.addPoint(endLeft+5, endTop+5);
		p.addPoint(beginLeft+5, beginTop+5);
		
		return p.contains(x, y);
	}

	@Override
	public int getNbPoint() {
		return 2;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int beginLeft = (int) ((_vector.getVector().getLeftDistance()*v.getWidth())/100);
		int endLeft = (int) ((_vector.getVector().getEndLeftDistance()*v.getWidth())/100);
		int ret[] = new int[2];
		ret[0] = beginLeft;
		ret[1] = endLeft;
		return ret;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int beginTop = (int) ((_vector.getVector().getTopDistance()*v.getHeight())/100);
		int endTop = (int) ((_vector.getVector().getEndTopDistance()*v.getHeight())/100);
		int ret[] = new int[2];
		ret[0] = beginTop;
		ret[1] = endTop;
		return ret;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int beginLeft = (int) ((_vector.getVector().getLeftDistance()*scene.getWidth())/100);
		int endLeft = (int) ((_vector.getVector().getEndLeftDistance()*scene.getWidth())/100);
		int beginTop = (int) ((_vector.getVector().getTopDistance()*scene.getHeight())/100);
		int endTop = (int) ((_vector.getVector().getEndTopDistance()*scene.getHeight())/100);
		int diffX, diffY;
		
		diffX = Math.abs(beginLeft-x);
		diffY = Math.abs(beginTop-y);
		if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE) {
			return new Point(beginLeft, beginTop);
		}
		
		diffX = Math.abs(endLeft-x);
		diffY = Math.abs(endTop-y);
		if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE) {
			return new Point(endLeft, endTop);
		}
		
		return null;
	}

}
