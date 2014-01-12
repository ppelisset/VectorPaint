package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.iutinfo.interfaces.ColorButton;
import fr.iutinfo.interfaces.CouleurPersonnalise;
import fr.iutinfo.interfaces.Outils;
import fr.iutinfo.interfaces.Page;



public class CouleurPersonnaliseListener implements ActionListener {
	private Page p;
	private CouleurPersonnalise cp;
	private ColorButton cb;
	/**
	 * listener de la class {@link CouleurPersonnalise}
	 * @param p
	 */
	public CouleurPersonnaliseListener(Page p){
		this.p = p;
	}
	/**
	 * listener de la class {@link CouleurPersonnalise}
	 * @param p
	 */
	public CouleurPersonnaliseListener(Page p, CouleurPersonnalise cp, ColorButton cb){
		this.p = p;
		this.cp = cp;
		this.cb = cb;
	}
	/**
	 * methode qui gere l'interaction utilisateur/interface de la JFrame {@link CouleurPersonnalise}
	 */
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("OK")){
			p.setColorSV(cp.getColor());
			cb.setColor(cp.getColor());
			cp.dispose();
			if(p.getSelectedOnglet().getSceneView().getSelectedFigure() != null) {
				p.getSelectedOnglet().getSceneView().getSelectedFigure().setColor(cp.getColor());
			}
			Outils.couleurCourante.setBackground(cp.getColor());
		}else if(b.getText().equals("cancel")){
			cp.dispose();
		}
		if(e.getSource().toString().equals("perso")){
			new CouleurPersonnalise(p, (ColorButton) e.getSource());
		}	
	}
}
