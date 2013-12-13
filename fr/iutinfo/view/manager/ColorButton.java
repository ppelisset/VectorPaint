package fr.iutinfo.view.manager;

import java.awt.Color;

import javax.swing.JButton;

public class ColorButton extends JButton {

	private Color color;
	private  String nomCouleur;
	public ColorButton(Color c, String nomnomCouleur){
		super(nomnomCouleur);
		this.color=c;
		this.nomCouleur=nomnomCouleur;
		
		
	}
	/**
	 * retourne le nom de la couleur
	 * @return String 
	 */
	public String getnomCouleur() {
		return nomCouleur;
	}
	/**
	 * set le nom de la couleur
	 * @param nomCouleur
	 */
	public void setnomCouleur(String nomCouleur) {
		this.nomCouleur = nomCouleur;
	}
	/**
	 * retourne la couleur
	 * @return Color
	 */
	public Color getColor(){
		return this.color;
	}
	/**
	 * set la couleur
	 * @param color
	 */
	public void setColor(Color color){
		
		this.color=color;
	}
}
