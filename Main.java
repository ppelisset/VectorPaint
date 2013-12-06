import javax.swing.JFrame;

import fr.iutinfo.model.Scene;
import fr.iutinfo.view.SceneView;
import fr.iutinfo.view.manager.ControllerPanel;


public class Main {

	public static void main(String[] args) throws Exception {
		JFrame f = new JFrame("Projet");
		Scene s = new Scene();
		SceneView sv = new SceneView(s);
		f.setContentPane(sv);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 300);
		f.setVisible(true);
		JFrame control = new JFrame("Control");
		control.setContentPane(new ControllerPanel(sv));
		control.setLocationRelativeTo(f);
		control.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		control.setSize(100, 200);
		control.setVisible(true);
	}

}
