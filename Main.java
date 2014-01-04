import javax.swing.UIManager;

import fr.iutinfo.interfaces.CouleurPersonnalise;
import fr.iutinfo.interfaces.InterfaceGraphique;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		InterfaceGraphique ig = new InterfaceGraphique();
	}
}