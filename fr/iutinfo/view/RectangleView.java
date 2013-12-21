package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;

import fr.iutinfo.model.Rectangle;
import fr.iutinfo.model.Vector;

public class RectangleView implements Printable {
	private Rectangle _rectangle;
	
	public RectangleView(Rectangle rect) {
		_rectangle = rect;
	}
	
	@Override
	public void paint(SceneView v, Graphics g) {
		Vector vec = _rectangle.getVector();
		int x,y,width,height;
		
		x = (int) ((vec.getLeftDistance()*v.getWidth())/100);
		y = (int) ((vec.getTopDistance()*v.getHeight())/100);
		
		width = (int) ((vec.getEndLeftDistance()*v.getWidth())/100) - x;
		height = (int) ((vec.getEndTopDistance()*v.getHeight())/100) - y;
		g.setColor(_rectangle.getColor());
		if(_rectangle.isFill()) {
			g.fillRect(x, y, width, height);
		} else {
			g.drawRect(x, y, width, height);
		}
	}

	@Override
	public boolean isSelect(SceneView v, int x, int y) {
		int bx,by,fx,fy;
		Vector vec = _rectangle.getVector();
		
		bx = (int) ((vec.getLeftDistance()*v.getWidth())/100);
		by = (int) ((vec.getTopDistance()*v.getHeight())/100);
		
		fx = (int) ((vec.getEndLeftDistance()*v.getWidth())/100);
		fy = (int) ((vec.getEndTopDistance()*v.getHeight())/100);
		
		return (x >= bx && x <= fx && y >= by && y <= fy);
	}

	@Override
	public int getNbPoint() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int[] getXPoint(SceneView v) {
		int bx,fx;
		Vector vec = _rectangle.getVector();
		
		bx = (int) ((vec.getLeftDistance()*v.getWidth())/100);
		
		fx = (int) ((vec.getEndLeftDistance()*v.getWidth())/100);
		
		int x[] = {bx, fx, fx, bx};
		
		return x;
	}

	@Override
	public int[] getYPoint(SceneView v) {
		int by,fy;
		Vector vec = _rectangle.getVector();
		by = (int) ((vec.getTopDistance()*v.getHeight())/100);
		fy = (int) ((vec.getEndTopDistance()*v.getHeight())/100);
		int y[] = {by, by, fy, fy};
		return y;
	}

	@Override
	public Point getPoint(SceneView scene, int x, int y) {
		int diffX, diffY, min = scene.ERROR_MARGE*2+1, nbMin = -1;
		for(int i = 0; i < getNbPoint(); i++) {
			diffX = Math.abs(getXPoint(scene)[i]-x);
			diffY = Math.abs(getYPoint(scene)[i]-y);
			if(diffX < scene.ERROR_MARGE && diffY < scene.ERROR_MARGE && diffX+diffY < min) {
				min = diffX+diffY;
				nbMin = i;
			}
		}
		if(nbMin == -1) return null;
		else return new Point(getXPoint(scene)[nbMin], getYPoint(scene)[nbMin]);
	}

}
