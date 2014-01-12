package fr.iutinfo.interfaces;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import fr.iutinfo.constructor.CircleConstructor;
import fr.iutinfo.constructor.OvalConstructor;
import fr.iutinfo.constructor.PolygonConstructor;
import fr.iutinfo.constructor.RectangleConstructor;
import fr.iutinfo.constructor.VectorLineConstructor;
import fr.iutinfo.controller.manager.SetContructorListener;
import fr.iutinfo.controller.manager.SetSelectListener;
import fr.iutinfo.interfaces.controler.PipetteListener;

public class Outils extends JToolBar{
	private static final long serialVersionUID = 1L;

	private JButton _modeLine, _modePolygone, _modeSelect, _modeRectangle, _modeCercle, _modePointer,_modeOval,_modePipette;
	public static ColorButton couleurCourante;
	/**
	 * constructeur qui cree les outils de dessins
	 */
	public Outils(){
		super(VERTICAL);
		setAlignmentX(0);

		_modeLine = new JButton(new ImageIcon(getClass().getResource("icons/line.png")));
		_modePolygone = new JButton(new ImageIcon(getClass().getResource("icons/polygon.png")));
		_modeRectangle = new JButton(new ImageIcon(getClass().getResource("icons/rectangle.png")));
		_modeCercle = new JButton(new ImageIcon(getClass().getResource("icons/circle.png")));
		_modeSelect = new JButton(new ImageIcon(getClass().getResource("icons/select.png")));
		_modePointer = new JButton(new ImageIcon(getClass().getResource("icons/pointer.png")));
		_modeOval=new JButton(new ImageIcon(getClass().getResource("icons/oval.png")));
		couleurCourante = new ColorButton(Color.black);
		_modePipette = new JButton(new ImageIcon(getClass().getResource("icons/pipette.png")));
		setLayout(new GridLayout(3, 1));
		add(_modePointer);
		add(_modeSelect);
		add(_modeLine);
		add(_modePolygone);
		add(_modeRectangle);
		add(_modeCercle);
		add(_modeOval);
		add(_modePipette);
		add(couleurCourante);
	}

	/**
	 * methode qui permet d'ajouter les outils aux nouveau onglet passe en parametre 
	 * @param p
	 * @param o
	 */
	public void addOutilOnglet(Page p, Onglet o){
		_modePointer.addActionListener(new SetContructorListener(o.sv,null));
		_modeLine.addActionListener(new SetContructorListener(o.sv,new VectorLineConstructor()));
		_modeLine.addActionListener(new SetContructorListener(o.sv,new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(o.sv,new PolygonConstructor()));
		_modeSelect.addActionListener(new SetSelectListener(o.sv));
		_modeRectangle.addActionListener(new SetContructorListener(o.sv,new RectangleConstructor()));
		_modeCercle.addActionListener(new SetContructorListener(o.sv,new CircleConstructor()));
		_modeOval.addActionListener(new SetContructorListener(o.sv, new OvalConstructor()));
		_modePipette.addActionListener(new PipetteListener(p, o.sv));
	}
}
