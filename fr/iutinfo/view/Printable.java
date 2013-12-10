package fr.iutinfo.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

import fr.iutinfo.model.Scene;

/**
 * Interface d'affichage d'une forme
 * @author pierre
 */
public interface Printable {
	public void paint(SceneView v, Graphics g);
	public boolean isSelect(SceneView v, int x, int y);
	public int getNbPoint();
	public int[] getXPoint(SceneView v);
	public int[] getYPoint(SceneView v);
	public Point getPoint(SceneView scene, int x, int y);
}
