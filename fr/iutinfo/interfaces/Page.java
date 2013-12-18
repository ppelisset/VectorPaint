package fr.iutinfo.interfaces;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Page extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private Outils ot;
	private OutilsCouleur otc;
	
	public Page(Outils ot, OutilsCouleur otc){
		super(SwingConstants.TOP);
		setOpaque(true);
		this.ot = ot;
		this.otc = otc;
		Onglet o = new Onglet();
		ot.addOutilOnglet(o);
		otc.addOutilCouleurOnglet(o);
		add(o.nom,o);
	}
	
	public void nouvelOnglet(){
		Onglet o = new Onglet();
		ot.addOutilOnglet(o);
		otc.addOutilCouleurOnglet(o);
		add(o.nom,o);
	}

}
