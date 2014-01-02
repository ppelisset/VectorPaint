package fr.iutinfo.interfaces;

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
	}
	
	public void reinitSceneView(){
		remove(sv);
		sv = new SceneView(new Scene());
		add(sv);
	}
	
	public SceneView getSceneView() {
		return sv;
	}

}