package fr.iutinfo.interfaces;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Page extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private Outils ot;
	private OutilsCouleur otc;
	private ArrayList<Onglet> listOnglet;
	
	public Page(Outils ot, OutilsCouleur otc){
		super(SwingConstants.TOP);
		listOnglet = new ArrayList<Onglet>();
		setOpaque(true);
		this.ot = ot;
		this.otc = otc;
		Onglet o = new Onglet();
		listOnglet.add(o);
		ot.addOutilOnglet(this, o);
		otc.addOutilCouleurOnglet(o);
		add(o.nom,o);
	}
	
	public void nouvelOnglet(){
		Onglet o = new Onglet();
		listOnglet.add(o);
		ot.addOutilOnglet(this, o);
		otc.addOutilCouleurOnglet(o);
		if(!listOnglet.isEmpty())
			o.getSceneView().setColor(listOnglet.get(0).getSceneView().getColor());
		add(o.nom,o);
		setSelectedComponent(o);
	}
	
	public void supOnglet(){
		Onglet o = listOnglet.get(getSelectedIndex());
		remove(o);
		listOnglet.remove(o);
	}
	
	public void reinitOnglet(){
		Onglet o = listOnglet.get(getSelectedIndex());
		o.reinitSceneView();
		ot.addOutilOnglet(this, o);
		otc.addOutilCouleurOnglet(o);
		repaint();
	}
	
	public Onglet getSelectedOnglet(){
		return listOnglet.get(getSelectedIndex());
	}
	
	public void addOutils(){
		ot.setVisible(true);;
	}
	
	public void supOutils(){
		ot.setVisible(false);
	}
	
	public void addCouleur(){
		otc.setVisible(true);
	}
	
	public void supCouleur(){
		otc.setVisible(false);
	}
	
	public void setColorSV(Color c){
		for(int i=0; i<listOnglet.size(); ++i){
			listOnglet.get(i).getSceneView().setColor(c);
		}
	}
}
