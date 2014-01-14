package fr.iutinfo.interfaces;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColorButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Color color;
	/**
	 * creer un JButton avec une taille predefinie et lui donne une couleur passe en parametre
	 * @param c
	 */
	public ColorButton(Color c){
		this.color=c;
		setPreferredSize(new Dimension(30, 30));
		setBackground(color);
		setOpaque(true);
		setBorderPainted(false);
	}
	/**
	 * creer un JButton avec une taille et une couleur predefinie et lui donne une ImageIcon passe en parametre
	 * @param ic
	 */
	public ColorButton(ImageIcon ic){
		super(ic);
		setText("perso");
		color = Color.white;
		setOpaque(true);
		setPreferredSize(new Dimension(30, 30));
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
		setBackground(color);
		repaint();
	}
	/**
	 * retourne le texte du bouton.
	 * @return String
	 */
	public String toString(){
		return getText();
	}
}
