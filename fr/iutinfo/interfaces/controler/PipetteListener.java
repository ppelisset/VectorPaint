package fr.iutinfo.interfaces.controler;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fr.iutinfo.controller.MouseSelectController;
import fr.iutinfo.interfaces.Outils;
import fr.iutinfo.interfaces.Page;
import fr.iutinfo.model.Figure;
import fr.iutinfo.view.SceneView;

public class PipetteListener implements ActionListener {
	private SceneView sv;
	private Page p;
	private double _beginLeft,_beginTop;
	
	public PipetteListener(Page p, SceneView sv){
		this.sv = sv;
		this.p = p;
	}

	public void actionPerformed(ActionEvent e) {
		sv.setSelectedFigure(null);
		if(!(sv.getMouseListener() instanceof MouseSelectController)) {
			sv.setMouseListener(new MouseListener() {
				
				public void mouseClicked(MouseEvent arg0) {
					sv.requestFocusInWindow();
					Figure selectedFigure = sv.getSelectedFigure(arg0.getX(), arg0.getY());
					if(selectedFigure != null) {
						sv.setSelectedFigure(selectedFigure);
						sv.repaint();
						p.setColorSV(sv.getSelectedFigure().getColor());
						Outils.couleurCourante.setColor(sv.getSelectedFigure().getColor());	
					} else {
						sv.setSelectedFigure(null);
						sv.repaint();
					}
								
				}
				
				public void mouseReleased(MouseEvent arg0) {}
				
				public void mousePressed(MouseEvent arg0) {}
				
				public void mouseExited(MouseEvent arg0) {}
				
				public void mouseEntered(MouseEvent arg0) {}
			});
		}
	}

}
