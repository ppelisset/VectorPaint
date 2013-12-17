package fr.iutinfo.interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		// Listener g�n�rique qui affiche l'action du menu utilis�
		ActionListener afficherMenuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("El�ment de menu [" + event.getActionCommand() + "] utilis�.");
			}
		};
		
		// Cr�ation du menu Fichier
		JMenu fichierMenu = new JMenu("Fichier");
		JMenuItem item = new JMenuItem("Nouveau");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(item);
		item = new JMenuItem("Ouvrir");
		item.addActionListener(afficherMenuListener);
		fichierMenu.add(item);
		item = new JMenuItem("Sauver");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.insertSeparator(1);
		fichierMenu.add(item);
		item = new JMenuItem("Quitter");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		fichierMenu.add(item);

		// Cr�ation du menu Editer
		JMenu editerMenu = new JMenu("Editer");
		item = new JMenuItem("Copier");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);
		item = new JMenuItem("Couper");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);
		item = new JMenuItem("Coller");
		item.addActionListener(afficherMenuListener);
		item.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		editerMenu.add(item);

		// ajout des menus � la barre de menus
		add(fichierMenu);
		add(editerMenu);
	}
}