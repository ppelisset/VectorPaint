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
	private String currentPath;
	/**
	 * creation d'un onglet par defaut a la construction
	 */
	public Onglet(){
		nom = "Onglet "	+ ++nb;
		sv = new SceneView(new Scene());
		setLayout(new GridLayout());
		add(sv);
	}
	/**
	 * methode permetant de reinitialiser la SceneView de l'onglet
	 */
	public void reinitSceneView(){
		remove(sv);
		sv = new SceneView(new Scene());
		add(sv);
	}
	/**
	 * retourne la sceneView de l'onglet
	 * @return SceneView
	 */
	public SceneView getSceneView() {
		return sv;
	}
	/**
	 * permet de changer le nom de l'onglet grace au nom d'un fichier passer en paramettre
	 * @param filepath
	 */
	public void setFilePath(String filepath) {
		this.currentPath = filepath;
	}
	/**
	 * retourne le nom de l'onglet
	 * @return String
	 */
	public String getCurrentPath() {
		return this.currentPath;
	}

}