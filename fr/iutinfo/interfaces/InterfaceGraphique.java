package fr.iutinfo.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JPanel tools = new JPanel();
		tools.setLayout(new GridLayout(0, 1));
		tools.add(ot);
		tools.add(otc);
		add(tools, BorderLayout.WEST);
		p.nouvelOnglet();
	}

}
