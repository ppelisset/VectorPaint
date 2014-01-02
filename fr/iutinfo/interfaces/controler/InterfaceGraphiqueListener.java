package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import fr.iutinfo.interfaces.InterfaceGraphique;
import fr.iutinfo.interfaces.MenuBar;
import fr.iutinfo.interfaces.Onglet;
import fr.iutinfo.interfaces.Page;
import fr.iutinfo.librairies.Opener;
import fr.iutinfo.librairies.Recorder;

public class InterfaceGraphiqueListener implements ActionListener {
	private Page p;
	private MenuBar m;
	private InterfaceGraphique ig;
	private int reponse;
	//pour les checkBoxMenuItem
	private AbstractButton aButton;
	
	public InterfaceGraphiqueListener(Page p, MenuBar m, InterfaceGraphique ig){
		this.p = p;
		this.m = m;
		this.ig = ig;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Nouveau"){
			reponse = JOptionPane.showConfirmDialog(ig, "Etes vous sure?", "Nouveau", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION)
				p.reinitOnglet();
		}
		else if(arg0.getActionCommand() == "Ouvrir"){
			JFileChooser dialog = new JFileChooser(new File(".vpf"));
			if(dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				Opener o = new Opener(((Onglet) p.getSelectedComponent()).getSceneView().getScene());
				try {
					o.restoreFromFile(dialog.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if(arg0.getActionCommand() == "Sauver"){
			JFileChooser dialog = new JFileChooser(new File(".vpf"));
			if(dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				Recorder r = new Recorder(((Onglet) p.getSelectedComponent()).getSceneView().getScene());
				try {
					r.recordInFile(dialog.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else if(arg0.getActionCommand() == "Nouvel Onglet"){
			p.nouvelOnglet();
		}
		else if(arg0.getActionCommand() == "Fermer l'Onglet"){
			p.supOnglet();
		}
		else if(arg0.getActionCommand() == "Quitter"){
			reponse = JOptionPane.showConfirmDialog(ig, "Attention, vous allez peut être perdre l'ensembe de votre progression.\nEtes vous sure de vouloir quitter le programme?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		else if(arg0.getActionCommand() == "Copier"){
			((Onglet) p.getSelectedComponent()).getSceneView().copyFigure();
		} 
		else if(arg0.getActionCommand() == "Coller"){
			((Onglet) p.getSelectedComponent()).getSceneView().pasteFigure();
		} 
		else if(arg0.getActionCommand() == "Couper"){
			((Onglet) p.getSelectedComponent()).getSceneView().cutFigure();
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
