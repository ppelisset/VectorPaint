package fr.iutinfo.view;

import java.awt.Graphics;
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

}
