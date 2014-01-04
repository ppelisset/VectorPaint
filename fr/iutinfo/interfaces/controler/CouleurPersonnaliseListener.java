package fr.iutinfo.interfaces.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.iutinfo.interfaces.ColorButton;
import fr.iutinfo.interfaces.CouleurPersonnalise;
import fr.iutinfo.view.SceneView;



public class CouleurPersonnaliseListener implements ActionListener {
	private SceneView sv;
	private CouleurPersonnalise cp;
	private ColorButton cb;
	
	public CouleurPersonnaliseListener(SceneView sv, CouleurPersonnalise cp, ColorButton cb){
		this.sv = sv;
		this.cp = cp;
		this.cb = cb;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("OK")){
			sv.setColor(cp.getColor());
			cb.setColor(cp.getColor());
			cp.dispose();
		}else if(b.getText().equals("cancel")){
			cp.dispose();
		}

	}

}
