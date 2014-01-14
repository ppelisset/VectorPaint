package fr.iutinfo.librairies;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Scene;

/**
 * Classe representant un enregistreur de donnees pour une scene
 *
 */
public class Recorder {
	private Scene _s;
	
	/**
	 * Cree un enregistreur de donnees pour la scene passer en parametre
	 * @param s
	 */
	public Recorder(Scene s) {
		_s = s;
	}
	
	/**
	 * Enregistre la scene dans le fichier f
	 * @param f
	 * @throws IOException
	 */
	public void recordInFile(File f) throws IOException {
		if(!f.exists()) {
			f.createNewFile();
		}
		
		PrintWriter pw = new PrintWriter(f);
		
		ArrayList<Figure> list;
		for(int i = 0; i < 4; i++) {
			pw.println("--ChangeGround -> " + i);
			list = _s.getProfondeurFigure(i);
			for(Figure fig : list) {
				String part[] = fig.getClass().getName().split("\\.");
				pw.println(part[part.length-1] + ":" + fig.save());
			}
		}
		pw.flush();
		pw.close();
	}
}
