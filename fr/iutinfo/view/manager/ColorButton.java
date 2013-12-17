package fr.iutinfo.view.manager;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class ColorButton extends JButton {

	private Color color;
	public ColorButton(Color c){
		this.color=c;
		
		
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
	
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
