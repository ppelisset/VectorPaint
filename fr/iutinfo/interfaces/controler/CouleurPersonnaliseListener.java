package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.iutinfo.interfaces.ColorButton;
import fr.iutinfo.interfaces.CouleurPersonnalise;
import fr.iutinfo.interfaces.Page;



public class CouleurPersonnaliseListener implements ActionListener {
	private Page p;
	private CouleurPersonnalise cp;
	private ColorButton cb;

	public CouleurPersonnaliseListener(Page p){
		this.p = p;
	}

	public CouleurPersonnaliseListener(Page p, CouleurPersonnalise cp, ColorButton cb){
		this.p = p;
		this.cp = cp;
		this.cb = cb;
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("OK")){
			p.getSelectedOnglet().getSceneView().setColor(cp.getColor());
			cb.setColor(cp.getColor());
			cp.dispose();
			if(p.getSelectedOnglet().getSceneView().getSelectedFigure() != null) {
				p.getSelectedOnglet().getSceneView().getSelectedFigure().setColor(cp.getColor());
			}
		}else if(b.getText().equals("cancel")){
			cp.dispose();
		}
		if(e.getSource().toString().equals("perso")){
			new CouleurPersonnalise(p, (ColorButton) e.getSource());
		}	
	}
}
