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
	/**
	 * constructeur qui cree un conteneur d'onglet et qui interagit avec les outils passe en parametre
	 * @param ot
	 * @param otc
	 */
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
	/**
	 * permet de cree un nouvel onglet dans la page
	 */
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
	/**
	 * permet de supprimer un onglet de la page
	 */
	public void supOnglet(){
		Onglet o = listOnglet.get(getSelectedIndex());
		remove(o);
		listOnglet.remove(o);
	}
	/**
	 * permet de reinitialiser un onglet de la page
	 */
	public void reinitOnglet(){
		Onglet o = listOnglet.get(getSelectedIndex());
		o.reinitSceneView();
		ot.addOutilOnglet(this, o);
		otc.addOutilCouleurOnglet(o);
		repaint();
	}
	/**
	 * retourne l'onglet selectionné de la page
	 * @return Onglet
	 */
	public Onglet getSelectedOnglet(){
		return listOnglet.get(getSelectedIndex());
	}
	/**
	 * permet de voir les outils
	 */
	public void addOutils(){
		ot.setVisible(true);;
	}
	/**
	 * permet de masquer les outils
	 */
	public void supOutils(){
		ot.setVisible(false);
	}
	/**
	 * permet de voir les outils de couleur
	 */
	public void addCouleur(){
		otc.setVisible(true);
	}
	/**
	 * permet de masquer les outils de couleur
	 */
	public void supCouleur(){
		otc.setVisible(false);
	}
	/**
	 * methode qui change la couleur courante des Onglets de la page par la couleur passe en parametre
	 * @param c
	 */
	public void setColorSV(Color c){
		for(int i=0; i<listOnglet.size(); ++i){
			listOnglet.get(i).getSceneView().setColor(c);
		}
	}
}
