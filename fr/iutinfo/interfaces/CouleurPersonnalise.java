package fr.iutinfo.interfaces;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.iutinfo.interfaces.controler.CouleurPersonnaliseListener;

public class CouleurPersonnalise extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel pPn, pPs;
	private JLabel lR, lG, lB, lA, lColor;
	private JSlider sR, sG, sB, sA;
	private JTextField tR, tG, tB, tA;
	private ChangeListener cl;
	private KeyListener kl;
	private GridBagConstraints c;
	private JButton ok, cancel;
	private Color couleur;

	/**
	 * constructeur qui cree une Frame pour pouvoir faire ses propre couleur
	 * @param p
	 * @param cb
	 */
	public CouleurPersonnalise(Page p, ColorButton cb){
		super("Choix de couleur");
		
		//Changelistener pour modifier les JSlider et les JTextField
		cl = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider) e.getSource();
				if(s == sR){
					tR.setText(s.getValue()+"");
				}
				if(s == sG){
					tG.setText(s.getValue()+"");
				}
				if(s == sB){
					tB.setText(s.getValue()+"");
				}
				if(s == sA){
					tA.setText(s.getValue()+"");
				}
				couleur = new Color(sR.getValue(), sG.getValue(), sB.getValue(), sA.getValue());
				lColor.setBackground(couleur);
			}
		};

		kl= new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			//detection de valeur fausse
			public void keyReleased(KeyEvent e) {
				JTextField tF = (JTextField) e.getSource();
				if(tF.getText().isEmpty()){
					if(tF == tR){
						tR.setText("0");
					}
					if(tF == tG){
						tG.setText("0");
					}
					if(tF == tB){
						tB.setText("0");
					}
					if(tF == tA){
						tA.setText("255");
					}
				}else{
					try{
						if(Integer.valueOf(tR.getText())>256){
							if(tF == tR){
								tR.setText("255");
								sR.setValue(255);
							}
							if(tF == tG){
								tG.setText("255");
								sG.setValue(255);
							}
							if(tF == tB){
								tB.setText("255");
								sB.setValue(255);
							}
							if(tF == tA){
								tA.setText("255");
								sA.setValue(255);
							}
						}else{
							if(tF == tR){
								sR.setValue(Integer.valueOf(tR.getText()));
							}
							if(tF == tG){
								sG.setValue(Integer.valueOf(tG.getText()));
							}
							if(tF == tB){
								sB.setValue(Integer.valueOf(tB.getText()));
							}
							if(tF == tA){
								sA.setValue(Integer.valueOf(tA.getText()));
							}
						}
					}
					catch(Exception ex){
						if(tF == tR){
							tR.setText("0");
						}
						if(tF == tG){
							tG.setText("0");
						}
						if(tF == tB){
							tB.setText("0");
						}
						if(tF == tA){
							tA.setText("255");
						}
					}
				}
				couleur = new Color(sR.getValue(), sG.getValue(), sB.getValue(), sA.getValue());
				lColor.setBackground(couleur);
			}
			public void keyPressed(KeyEvent e) {}
		};

		setLayout(new GridLayout(2,1));
		
		pPn = new JPanel();
		pPn.setLayout(new GridBagLayout());
		
		//contrainte de placement
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0.33;
		
		lR = new JLabel("R:");
		sR = new JSlider(0,255,0);
		sR.addChangeListener(cl);
		tR = new JTextField("0");
		tR.addKeyListener(kl);
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 0;
		pPn.add(lR,c);
		c.weightx = 0.6;
		c.gridx = 1;
		pPn.add(sR,c);
		c.weightx = 0.2;
		c.gridx = 2;
		pPn.add(tR,c);
		
		lG = new JLabel("G:");
		sG = new JSlider(0,255,0);
		sG.addChangeListener(cl);
		tG = new JTextField("0");
		tG.addKeyListener(kl);
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 1;
		pPn.add(lG,c);
		c.weightx = 0.6;
		c.gridx = 1;
		pPn.add(sG,c);
		c.weightx = 0.2;
		c.gridx = 2;
		pPn.add(tG,c);
		
		lB = new JLabel("B:");
		sB = new JSlider(0,255,0);
		sB.addChangeListener(cl);
		tB = new JTextField("0");
		tB.addKeyListener(kl);
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 2;
		pPn.add(lB,c);
		c.weightx = 0.6;
		c.gridx = 1;
		pPn.add(sB,c);
		c.weightx = 0.2;
		c.gridx = 2;
		pPn.add(tB,c);
		
		lA = new JLabel("A:");
		sA = new JSlider(0,255,255);
		sA.addChangeListener(cl);
		tA = new JTextField("255");
		tA.addKeyListener(kl);
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 3;
		pPn.add(lA,c);
		c.weightx = 0.6;
		c.gridx = 1;
		pPn.add(sA,c);
		c.weightx = 0.2;
		c.gridx = 2;
		pPn.add(tA,c);
		
		add(pPn);
		
		pPs = new JPanel();
		pPs.setLayout(new GridBagLayout());
		
		c.fill = GridBagConstraints.CENTER;
		c.weighty = 0.5;
		c.gridy = 0;
		
		CouleurPersonnaliseListener cpl = new CouleurPersonnaliseListener(p, this, cb);
		
		ok = new JButton("OK");
		ok.addActionListener(cpl);
		c.weightx = 0.29;
		c.gridx = 0;
		pPs.add(ok,c);
		
		cancel = new JButton("cancel");
		cancel.addActionListener(cpl);
		c.weightx = 0.29;
		c.gridx = 1;
		pPs.add(cancel,c);
		
		couleur = new Color(0,0,0,255);
		lColor = new JLabel(" ");
		lColor.setPreferredSize(new Dimension(200,200));
		lColor.setBackground(couleur);
		lColor.setOpaque(true);
		
		c.weightx = 0.42;
		c.gridx = 2;
		
		pPs.add(lColor,c);
		
		add(pPs);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350, 450);
		setMinimumSize(new Dimension(350, 450));
		setLocation(750, 350);
		setVisible(true);
	}
	/**
	 * retourne la couleur choisie
	 * @return Color
	 */
	public Color getColor(){
		return couleur;
	}
}
