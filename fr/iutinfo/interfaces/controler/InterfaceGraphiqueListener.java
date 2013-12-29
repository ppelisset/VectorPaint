package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import fr.iutinfo.interfaces.MenuBar;
import fr.iutinfo.interfaces.Page;

public class InterfaceGraphiqueListener implements ActionListener {
	private Page p;
	private MenuBar m;
	//pour les checkBoxMenuItem
	private AbstractButton aButton;
	
	public InterfaceGraphiqueListener(Page p, MenuBar m){
		this.p = p;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Nouveau"){
			
		}
		else if(arg0.getActionCommand() == "Ouvrir"){
			
		}
		else if(arg0.getActionCommand() == "Sauver"){
			
		}
		else if(arg0.getActionCommand() == "Nouvel Onglet"){
			p.nouvelOnglet();
		}
		else if(arg0.getActionCommand() == "Fermer l'Onglet"){
			p.supOnglet();
		}
		else if(arg0.getActionCommand() == "Quitter"){
			System.exit(0);
		}
		else if(arg0.getActionCommand() == "Copier"){
			
		}
		else if(arg0.getActionCommand() == "Couper"){
			
		}
		else if(arg0.getActionCommand() == "Coller"){
			
		}
		else if(arg0.getActionCommand() == "Outils"){
			aButton = (AbstractButton) arg0.getSource();
			if(aButton.getModel().isSelected())
				p.addOutils();
			else
				p.supOutils();
		}
		else if(arg0.getActionCommand() == "Couleur"){
			aButton = (AbstractButton) arg0.getSource();
			if(aButton.getModel().isSelected())
				p.addCouleur();
			else
				p.supCouleur();
		}
	}

}
