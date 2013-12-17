package fr.iutinfo.interfaces;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class Page extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	
	public Page(){
		super(SwingConstants.TOP);
		setOpaque(true);
	}

}
