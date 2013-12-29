package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.iutinfo.interfaces.MenuBar;
import fr.iutinfo.interfaces.Onglet;
import fr.iutinfo.interfaces.Page;
import fr.iutinfo.view.SceneView;

public class InterfaceGraphiqueListener implements ActionListener {
	private Page p;
	private MenuBar m;
	
	public InterfaceGraphiqueListener(Page p, MenuBar m){
		this.p = p;
		this.m = m;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Nouvel Onglet"){
			p.nouvelOnglet();
		}
		else if(arg0.getActionCommand() == "Quitter"){
			System.exit(0);
		}
		else if(arg0.getActionCommand() == "Fermer Onglet"){
			p.fermerOnglet();
		} else if(arg0.getActionCommand() == "Copier"){
			((Onglet) p.getSelectedComponent()).getSceneView().copyFigure();
		} else if(arg0.getActionCommand() == "Coller"){
			((Onglet) p.getSelectedComponent()).getSceneView().pasteFigure();
		} else if(arg0.getActionCommand() == "Couper"){
			((Onglet) p.getSelectedComponent()).getSceneView().cutFigure();
		}
		
	}

}
