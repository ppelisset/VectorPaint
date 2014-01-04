package fr.iutinfo.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import fr.iutinfo.interfaces.controler.InterfaceGraphiqueListener;

public class InterfaceGraphique extends JFrame {
	private static final long serialVersionUID = 1L;
	private Outils ot;
	private OutilsCouleur otc;
	private ToolBar tb;
	private MenuBar mb;
	
	public InterfaceGraphique(){
		super("Vector Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mb = new MenuBar();
		setJMenuBar(mb);
		setSize(600, 500);
		setMinimumSize(new Dimension(250, 200));
		setLocation(600, 300);
		ot = new Outils();
		otc = new OutilsCouleur();
		Page p = new Page(ot, otc);
		tb = new ToolBar(p);
		mb.addActionListener(new InterfaceGraphiqueListener(p, mb, this));
		add(p);
		add(ot,BorderLayout.WEST);
		add(otc,BorderLayout.SOUTH);
		add(tb, BorderLayout.PAGE_START);
		setVisible(true);
	}

}
