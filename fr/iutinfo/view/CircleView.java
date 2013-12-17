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
		int beginTop, beginLeft, endTop, endLeft;
		beginTop = (int) ((_circle.getHeight().getTopDistance() * v.getHeight()) / 100);
		beginLeft = (int) ((_circle.getHeight().getLeftDistance() * v.getWidth()) / 100);
		endTop = (int) ((_circle.getHeight().getEndTopDistance() * v.getHeight()) / 100);
		endLeft = (int) ((_circle.getHeight().getEndLeftDistance() * v.getWidth()) / 100);
		g.setColor(_circle.getColor());
		
	//	g.fillOval(beginLeft,beginTop,Math.abs(endLeft-beginLeft),Math.abs(endTop-beginTop));
		g.fillOval(beginLeft,beginTop,Math.abs(endTop-beginTop),Math.abs(endTop-beginTop));
		//g.drawLine(beginLeft,beginTop,endLeft,endTop);
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int beginTop, beginLeft, endTop, endLeft;
		Polygon p = new Polygon();
		beginTop = (int) ((_circle.getHeight().getTopDistance() * v.getHeight()) / 100);
		beginLeft = (int) ((_circle.getHeight().getLeftDistance() * v
				.getWidth()) / 100);
		endTop = (int) ((_circle.getHeight().getEndTopDistance() * v
				.getHeight()) / 100);
		endLeft = (int) ((_circle.getHeight().getEndLeftDistance() * v
				.getWidth()) / 100);

		p.addPoint(beginLeft - 5, beginTop - 5);
		p.addPoint(endLeft - 5, endTop - 5);
		p.addPoint(endLeft + 5, endTop + 5);
		p.addPoint(beginLeft + 5, beginTop + 5);

		return p.contains(x, y);
	}

	@Override
	public int getNbPoint() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int beginLeft = (int) ((_circle.getHeight().getLeftDistance() * v
				.getWidth()) / 100);
		int endLeft = (int) ((_circle.getHeight().getEndLeftDistance() * v
				.getWidth()) / 100);
		int ret[] = new int[2];
		ret[0] = beginLeft;
		ret[1] = endLeft;
		return ret;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int beginTop = (int) ((_circle.getHeight().getTopDistance() * v
				.getHeight()) / 100);
		int endTop = (int) ((_circle.getHeight().getEndTopDistance() * v
				.getHeight()) / 100);
		int ret[] = new int[2];
		ret[0] = beginTop;
		ret[1] = endTop;
		return ret;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int beginLeft = (int) ((_circle.getHeight().getLeftDistance() * scene
				.getWidth()) / 100);
		int endLeft = (int) ((_circle.getHeight().getEndLeftDistance() * scene
				.getWidth()) / 100);
		int beginTop = (int) ((_circle.getHeight().getTopDistance() * scene
				.getHeight()) / 100);
		int endTop = (int) ((_circle.getHeight().getEndTopDistance() * scene
				.getHeight()) / 100);
		int diffX, diffY;

		diffX = Math.abs(beginLeft - x);
		diffY = Math.abs(beginTop - y);
		if (diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE) {
			return new Point(beginLeft, beginTop);
		}

		diffX = Math.abs(endLeft - x);
		diffY = Math.abs(endTop - y);
		if (diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE) {
			return new Point(endLeft, endTop);
		}

		return null;
	}

}