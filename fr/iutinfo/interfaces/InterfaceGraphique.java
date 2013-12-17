package fr.iutinfo.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class InterfaceGraphique extends JFrame {
	private static final long serialVersionUID = 1L;
	private Outils ot;
	
	public InterfaceGraphique(){
		super("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(new MenuBar());
		setSize(600, 500);
		setMinimumSize(new Dimension(250, 200));
		setLocation(600, 300);
		setVisible(true);
		Page p = new Page();
		Onglet o = new Onglet();
		ot = new Outils(o);
		p.addTab(o.nom, o);
		Onglet o2 = new Onglet();
		ot.addOutilOnglet(o2);
		p.addTab(o2.nom, o2);
		add(p);
		add(ot, BorderLayout.WEST);
	}

}
