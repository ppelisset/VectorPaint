package fr.iutinfo.librairies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Scene;

/**
 * Classe representant un lecteur de fichier pour une scene
 */
public class Opener {
	Scene _s;
	
	/**
	 * Cree un lecteur de fichier pour la scene passer en parametre
	 * @param s
	 */
	public Opener(Scene s) {
		_s = s;
	}
	
	/**
	 * Vide la scene et la rempli avec les informations du fichiers passe en parametre
	 * @param f
	 * @throws IOException
	 * @throws CorruptFileException
	 */
	public void restoreFromFile(File f) throws IOException, CorruptFileException {
		BufferedReader bf = new BufferedReader(new FileReader(f));
		String line;
		int currentGround = 0;
		_s.clean();
		while((line = bf.readLine()) != null) {
			line = line.trim();
			if(!line.equals("")) {
				if(line.startsWith("--ChangeGround -> ")) {
					currentGround = Integer.parseInt(line.split(" -> ")[1]);
				} else {
					String part[] = line.split(":", 2);
					String className = part[0];
					String args = part[1];
					try {
						Class c = Class.forName("fr.iutinfo.model." + className);
						Method m = c.getMethod("restore", String.class);
						Figure fig = (Figure)m.invoke(null, args);
						_s.addFigure(currentGround, fig);
					} catch (Exception e) {
						throw new CorruptFileException();
					}
				}
			}
		}
	}
}