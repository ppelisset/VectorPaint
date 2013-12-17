package fr.iutinfo.interfaces;

import javax.swing.JButton;
import javax.swing.JToolBar;

import fr.iutinfo.constructor.CircleConstructor;
import fr.iutinfo.constructor.PolygonConstructor;
import fr.iutinfo.constructor.RectangleConstructor;
import fr.iutinfo.constructor.VectorLineConstructor;
import fr.iutinfo.controller.manager.SetContructorListener;
import fr.iutinfo.controller.manager.SetSelectListener;

public class Outils extends JToolBar{
	private static final long serialVersionUID = 1L;
	
	private JButton _modeLine, _modePolygone, _modeSelect, _modeRectangle, _modeCercle;

	public Outils(Onglet o){
		super(VERTICAL);
        setAlignmentX(0);
        
        _modeLine = new JButton("Ligne");
		_modePolygone = new JButton("Polygone");
		_modeRectangle = new JButton("Rectangle");
		_modeCercle = new JButton("Cercle");
		_modeSelect = new JButton("Select");
        
		_modeLine.addActionListener(new SetContructorListener(o.sv,new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(o.sv,new PolygonConstructor()));
		_modeRectangle.addActionListener(new SetContructorListener(o.sv,new RectangleConstructor()));
		_modeCercle.addActionListener(new SetContructorListener(o.sv,new CircleConstructor()));
		_modeSelect.addActionListener(new SetSelectListener(o.sv));

		add(_modeLine);
		add(_modePolygone);
		add(_modeRectangle);
		add(_modeCercle);
		add(_modeSelect);
	}
	
	public void addOutilOnglet(Onglet o){
		_modeLine.addActionListener(new SetContructorListener(o.sv,new VectorLineConstructor()));
		_modePolygone.addActionListener(new SetContructorListener(o.sv,new PolygonConstructor()));
		_modeSelect.addActionListener(new SetSelectListener(o.sv));
		_modeRectangle.addActionListener(new SetContructorListener(o.sv,new RectangleConstructor()));
		_modeCercle.addActionListener(new SetContructorListener(o.sv,new CircleConstructor()));

	}
}
