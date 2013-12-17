package fr.iutinfo.interfaces;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JToolBar;

import fr.iutinfo.controller.MouseController;
import fr.iutinfo.view.manager.ColorButton;

public class OutilsCouleur extends JToolBar {
	private static final long serialVersionUID = 1L;

	private ColorButton black, blue, cyan, darkGray, gray, green, lightGray, magenta, orange, pink, red, white, yellow;

	public OutilsCouleur(Onglet o){
		super(HORIZONTAL);
		setAlignmentX(0);
		setLayout(new GridLayout(2,7));
		MouseController mc = new MouseController(o.sv);

		black = new ColorButton(Color.black);
		add(black);
		black.addMouseListener(mc);

		blue = new ColorButton(Color.blue);
		add(blue);
		blue.addMouseListener(mc);

		cyan = new ColorButton(Color.cyan);
		add(cyan);
		cyan.addMouseListener(mc);

		darkGray = new ColorButton(Color.darkGray);
		add(darkGray);
		darkGray.addMouseListener(mc);

		gray = new ColorButton(Color.gray);
		add(gray);
		gray.addMouseListener(mc);

		green = new ColorButton(Color.green);
		add(green);
		green.addMouseListener(mc);

		lightGray = new ColorButton(Color.lightGray);
		add(lightGray);
		lightGray.addMouseListener(mc);

		magenta = new ColorButton(Color.magenta);
		add(magenta);
		magenta.addMouseListener(mc);

		orange = new ColorButton(Color.orange);
		add(orange);
		orange.addMouseListener(mc);

		pink = new ColorButton(Color.pink);
		add(pink);
		pink.addMouseListener(mc);

		red = new ColorButton(Color.red);
		add(red);
		red.addMouseListener(mc);

		white = new ColorButton(Color.white);
		add(white);
		white.addMouseListener(mc);

		yellow = new ColorButton(Color.yellow);
		add(yellow);
		yellow.addMouseListener(mc);
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
