package fr.iutinfo.librairies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fr.iutinfo.model.Figure;
import fr.iutinfo.model.Scene;

public class Opener {
	Scene _s;
	
	public Opener(Scene s) {
		_s = s;
	}
	
	public void restoreFromFile(File f) throws IOException {
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
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}