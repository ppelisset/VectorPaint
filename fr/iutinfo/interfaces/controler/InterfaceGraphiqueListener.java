package fr.iutinfo.interfaces.controler;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import fr.iutinfo.interfaces.InterfaceGraphique;
import fr.iutinfo.interfaces.Onglet;
import fr.iutinfo.interfaces.Page;
import fr.iutinfo.librairies.CorruptFileException;
import fr.iutinfo.librairies.Opener;
import fr.iutinfo.librairies.Recorder;

public class InterfaceGraphiqueListener implements ActionListener {
	private Page p;
	private InterfaceGraphique ig;
	private int reponse;
	//pour les checkBoxMenuItem
	private AbstractButton aButton;
	/**
	 * creation du listener de la Frame principal
	 * @param p
	 * @param ig
	 */
	public InterfaceGraphiqueListener(Page p, InterfaceGraphique ig){
		this.p = p;
		this.ig = ig;
	}

	/**
	 * methode qui gere l'interaction utilisateur/interface de la JFrame {@link InterfaceGraphique}
	 */

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Nouveau"){
			reponse = JOptionPane.showConfirmDialog(ig, "Etes vous sure?", "Nouveau", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION)
				p.reinitOnglet();
		}
		else if(arg0.getActionCommand() == "Ouvrir"){
			FileDialog fDial = new FileDialog(ig, "Ouvrir", FileDialog.LOAD);
			fDial.setFilenameFilter(new FileFilter());
			fDial.setVisible(true);
			if(fDial.getFile() != null) {
				String filepath = fDial.getDirectory() + fDial.getFile();
				Opener o = new Opener(((Onglet) p.getSelectedComponent()).getSceneView().getScene());
				try {
					o.restoreFromFile(new File(filepath));
					p.setTitleAt(p.getSelectedIndex(), fDial.getFile());
					((Onglet) p.getSelectedComponent()).setFilePath(filepath);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(ig, "Impossible de lire le fichier, verifiais que le fichier existe et que vous disposez des droits de lecture", "Erreur d'acces au fichier", JOptionPane.ERROR_MESSAGE);
				} catch (CorruptFileException e) {
					JOptionPane.showMessageDialog(ig, "Le fichier semble corrompu, verifier qu'il s'agit bien d'un fichier cree avec VectorPaint", "Fichier corrompu", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if(arg0.getActionCommand().equals("Sauver sous...") || arg0.getActionCommand().equals("Sauver")) {
			boolean save = false;
			File f = null;
			if(((Onglet) p.getSelectedComponent()).getCurrentPath() != null && !arg0.getActionCommand().equals("Sauver sous...")) {
				f = new File(((Onglet) p.getSelectedComponent()).getCurrentPath());
				save = true;
			} else {
				JFileChooser dialog = new JFileChooser(new File("."));
				javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter() {
					public boolean accept(final File f) {
						return (f.isDirectory() ? true : f.getName().endsWith(".vpf"));
				    }
					public String getDescription() {
				        return "VectorPaint File (*.vpf)";
				    }
				};
				dialog.setFileFilter(filter);
				if(dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					f = dialog.getSelectedFile();
					if(!f.getPath().toLowerCase().endsWith(".vpf")) {
						f = new File(f.getPath() +  ".vpf");
					}
					save = true;
				}
			}
			if(save) {
				Recorder r = new Recorder(((Onglet) p.getSelectedComponent()).getSceneView().getScene());
				try {
					r.recordInFile(f);
					p.setTitleAt(p.getSelectedIndex(), f.getName());
					((Onglet) p.getSelectedComponent()).setFilePath(f.getPath());
				} catch (IOException e) {
					JOptionPane.showMessageDialog(ig, "Impossible d'ecrire dans le fichier, verifiais que le fichier existe et que vous disposez des droits en ecriture", "Erreur d'acces au fichier", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else if(arg0.getActionCommand() == "Nouvel Onglet"){
			p.nouvelOnglet();
		}
		else if(arg0.getActionCommand() == "Fermer l'Onglet"){
			p.supOnglet();
		}
		else if(arg0.getActionCommand() == "Quitter"){
			reponse = JOptionPane.showConfirmDialog(ig, "Attention, vous allez peut être perdre l'ensembe de votre progression.\nEtes vous sure de vouloir quitter le programme?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		else if(arg0.getActionCommand() == "Copier"){
			((Onglet) p.getSelectedComponent()).getSceneView().copyFigure();
		} 
		else if(arg0.getActionCommand() == "Coller"){
			((Onglet) p.getSelectedComponent()).getSceneView().pasteFigure();
		} 
		else if(arg0.getActionCommand() == "Couper"){
			((Onglet) p.getSelectedComponent()).getSceneView().cutFigure();
		}
		else if(arg0.getActionCommand() == "Outils"){
			aButton = (AbstractButton) arg0.getSource();
			if(aButton.getModel().isSelected())
				p.addOutils();
			else
				p.supOutils();
		}
		else if(arg0.getActionCommand() == "Couleur"){
			aButton = (AbstractButton) arg0.getSource();
			if(aButton.getModel().isSelected())
				p.addCouleur();
			else
				p.supCouleur();
		}
	}
	/**
	 * class permetant de creer notre propre filler
	 * @author Matthieu
	 *
	 */
	class FileFilter implements FilenameFilter {
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".vpf");
		}
		
	}
}
