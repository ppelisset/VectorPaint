package fr.iutinfo.interfaces;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import fr.iutinfo.model.Scene;
import fr.iutinfo.view.SceneView;

public class Onglet extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static int nb = 0;
	protected String nom;
	protected SceneView sv;

	public Onglet(){
		nom = "Onglet "	+ ++nb;
		sv = new SceneView(new Scene());
		setLayout(new GridLayout());
		add(sv);
		setPreferredSize(new Dimension(300,80));
	}
	
	public SceneView getSceneView() {
		return sv;
	}

}