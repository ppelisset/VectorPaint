import javax.swing.UIManager;

import fr.iutinfo.interfaces.InterfaceGraphique;

public class Main {
	/**
	 * Fonction de lancement du programme
	 * Ajuste une propriete pour le système Mac OS X
	 * Modifie le look en Feel par défaut
	 * Lance l'interface graphique
	 * @throws Exception
	 */
	public static void main(String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Impossible de modifier le lookAndFeel : " + e.getMessage());
		}
		InterfaceGraphique ig = new InterfaceGraphique();
	}
}