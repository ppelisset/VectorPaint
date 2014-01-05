package fr.iutinfo.interfaces;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem nouveau, ouvrir, sauver, sauverSous, nouvelOnglet, fermerOnglet, quitter, copier, couper, coller;
	private JCheckBoxMenuItem checkBoxOutils, checkBoxCouleur;
	

	public MenuBar() {
		// Listener g�n�rique qui affiche l'action du menu utilis�
		ActionListener afficherMenuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Element de menu [" + event.getActionCommand() + "] utilise.");
			}
		};
		
		// Creation du menu Fichier
		JMenu fichierMenu = new JMenu("Fichier");
		nouveau = new JMenuItem("Nouveau");
		nouveau.addActionListener(afficherMenuListener);
		nouveau.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(nouveau);
		ouvrir = new JMenuItem("Ouvrir");
		ouvrir.addActionListener(afficherMenuListener);
		fichierMenu.add(ouvrir);
		sauver = new JMenuItem("Sauver", new ImageIcon(getClass().getResource("icons/sauvegarde.png")));
		sauver.addActionListener(afficherMenuListener);
		sauver.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(sauver);
		sauverSous = new JMenuItem("Sauver sous...", new ImageIcon(getClass().getResource("icons/sauvegarde.png")));
		sauverSous.addActionListener(afficherMenuListener);
		fichierMenu.add(sauverSous);
		nouvelOnglet = new JMenuItem("Nouvel Onglet");
		nouvelOnglet.addActionListener(afficherMenuListener);
		nouvelOnglet.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(nouvelOnglet);
		fermerOnglet = new JMenuItem("Fermer l'Onglet");
		fermerOnglet.addActionListener(afficherMenuListener);
		fermerOnglet.setAccelerator(KeyStroke.getKeyStroke('W', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(fermerOnglet);
		quitter = new JMenuItem("Quitter");
		quitter.addActionListener(afficherMenuListener);
		quitter.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(quitter);

		// Creation du menu Editer
		JMenu editerMenu = new JMenu("Editer");
		copier = new JMenuItem("Copier");
		copier.addActionListener(afficherMenuListener);
		copier.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(copier);
		couper= new JMenuItem("Couper");
		couper.addActionListener(afficherMenuListener);
		couper.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(couper);
		coller = new JMenuItem("Coller");
		coller.addActionListener(afficherMenuListener);
		coller.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(coller);
		
		//Creation du menu Affichage
		JMenu affichageMenu = new JMenu("Affichage");
		checkBoxOutils = new JCheckBoxMenuItem("Outils", true);
		affichageMenu.add(checkBoxOutils);
		checkBoxCouleur = new JCheckBoxMenuItem("Couleur", true);
		affichageMenu.add(checkBoxCouleur);
		
		// ajout des menus � la barre de menus
		add(fichierMenu);
		add(editerMenu);
		add(affichageMenu);
	}
	
	public void addActionListener(ActionListener al){
		nouveau.addActionListener(al);
		ouvrir.addActionListener(al);
		sauver.addActionListener(al);
		sauverSous.addActionListener(al);
		nouvelOnglet.addActionListener(al);
		fermerOnglet.addActionListener(al);
		quitter.addActionListener(al);
		copier.addActionListener(al);
		couper.addActionListener(al);
		coller.addActionListener(al);
		checkBoxOutils.addActionListener(al);
		checkBoxCouleur.addActionListener(al);
	}
}