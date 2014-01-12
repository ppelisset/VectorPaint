package fr.iutinfo.interfaces;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import fr.iutinfo.interfaces.controler.ToolBarListener;

public class ToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	private JButton _firstGround, _secondGround, _thirdGround, _backGround, _fillButton, _emptyButton;
	/**
	 * cree une bar d'Outils de modification de figure
	 * @param current
	 */
	public ToolBar(Page current) {
		_firstGround = new JButton("Premier Plan");
		_secondGround = new JButton("Deuxieme Plan");
		_thirdGround = new JButton("Troisieme Plan");
		_backGround = new JButton("Arriere Plan");
		
		ActionListener listener = new ToolBarListener(this, current);
		_firstGround.addActionListener(listener);
		_secondGround.addActionListener(listener);
		_thirdGround.addActionListener(listener);
		_backGround.addActionListener(listener);
		_fillButton = new FillButton(current, true);
		_emptyButton = new FillButton(current, false);
		
		add(_firstGround);
		add(_secondGround);
		add(_thirdGround);
		add(_backGround);
		add(_fillButton);
		add(_emptyButton);
	}
	/**
	 * retourne le JButton FirstGround
	 * @return JButton
	 */
	public JButton getFirstGround() {
		return _firstGround;
	}
	/**
	 * retourne le JButton SecondGround
	 * @return JButton
	 */
	public JButton getSecondGround() {
		return _secondGround;
	}
	/**
	 * retourne le JButton ThirdGround
	 * @return JButton
	 */
	public JButton getThirdGround() {
		return _thirdGround;
	}
	/**
	 * retourne le JButton BackGround
	 * @return JButton
	 */
	public JButton getBackGround() {
		return _backGround;
	}
	
	
}
