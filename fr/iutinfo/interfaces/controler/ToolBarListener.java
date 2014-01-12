package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutinfo.interfaces.Page;
import fr.iutinfo.interfaces.ToolBar;
import fr.iutinfo.interfaces.Onglet;
import fr.iutinfo.view.SceneView;

/**
 * Classe permettant de changer la profondeur d'une figure
 */
public class ToolBarListener implements ActionListener {
	private ToolBar _tb;
	private Page _p;
	
	public ToolBarListener(ToolBar tb, Page p) {
		_tb = tb;
		_p = p;
	}
	
	
	public void actionPerformed(ActionEvent ev) {
		SceneView current = ((Onglet)_p.getSelectedComponent()).getSceneView();
		if(current.getSelectedFigure() != null) {
			if(ev.getSource() == _tb.getFirstGround()) {
				current.getScene().setFigure(current.getSelectedFigure(), 0);
			} else if(ev.getSource() == _tb.getSecondGround()) {
				current.getScene().setFigure(current.getSelectedFigure(), 1);
			} else if(ev.getSource() == _tb.getThirdGround()) {
				current.getScene().setFigure(current.getSelectedFigure(), 2);
			} else if(ev.getSource() == _tb.getBackGround()) {
				current.getScene().setFigure(current.getSelectedFigure(), 3);
			}
		}
	}
	
}
