package fr.iutinfo.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import fr.iutinfo.interfaces.controler.InterfaceGraphiqueListener;

public class InterfaceGraphique extends JFrame {
	private static final long serialVersionUID = 1L;
	private Outils ot;
	private OutilsCouleur otc;
	private MenuBar mb;
	
	public InterfaceGraphique(){
		super("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb = new MenuBar();
		setJMenuBar(mb);
		setSize(600, 500);
		setMinimumSize(new Dimension(250, 200));
		setLocation(600, 300);
		setVisible(true);
		ot = new Outils();
		otc = new OutilsCouleur();
		Page p = new Page(ot, otc);
		mb.addActionListener(new InterfaceGraphiqueListener(p, mb));
		add(p);
		add(ot, BorderLayout.WEST);
		add(otc, BorderLayout.SOUTH);
		p.nouvelOnglet();
	}

}
