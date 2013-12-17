
import javax.swing.UIManager;
import fr.iutinfo.interfaces.InterfaceGraphique;


public class Main {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		InterfaceGraphique ig = new InterfaceGraphique();
		
	}

}
