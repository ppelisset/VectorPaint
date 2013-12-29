package fr.iutinfo.interfaces;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JToolBar;

import fr.iutinfo.controller.MouseController;

public class OutilsCouleur extends JToolBar {
	private static final long serialVersionUID = 1L;

	private ColorButton black, blue, cyan, darkGray, gray, green, lightGray, magenta, orange, pink, red, white, yellow;

	public OutilsCouleur(){
		super(HORIZONTAL);
		setAlignmentX(0);
		setLayout(new GridLayout(2,7));

		black = new ColorButton(Color.black);
		add(black);

		blue = new ColorButton(Color.blue);
		add(blue);

		cyan = new ColorButton(Color.cyan);
		add(cyan);

		darkGray = new ColorButton(Color.darkGray);
		add(darkGray);

		gray = new ColorButton(Color.gray);
		add(gray);

		green = new ColorButton(Color.green);
		add(green);

		lightGray = new ColorButton(Color.lightGray);
		add(lightGray);

		magenta = new ColorButton(Color.magenta);
		add(magenta);

		orange = new ColorButton(Color.orange);
		add(orange);

		pink = new ColorButton(Color.pink);
		add(pink);

		red = new ColorButton(Color.red);
		add(red);

		white = new ColorButton(Color.white);
		add(white);

		yellow = new ColorButton(Color.yellow);
		add(yellow);
	}

	public void addOutilCouleurOnglet(Onglet o){
		MouseController mc = new MouseController(o.sv);
		black.addMouseListener(mc);
		blue.addMouseListener(mc);
		cyan.addMouseListener(mc);
		darkGray.addMouseListener(mc);
		gray.addMouseListener(mc);
		green.addMouseListener(mc);
		lightGray.addMouseListener(mc);
		magenta.addMouseListener(mc);
		orange.addMouseListener(mc);
		pink.addMouseListener(mc);
		red.addMouseListener(mc);
		white.addMouseListener(mc);
		yellow.addMouseListener(mc);
	}
}
