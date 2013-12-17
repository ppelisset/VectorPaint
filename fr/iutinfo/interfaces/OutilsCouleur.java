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
	}
}
