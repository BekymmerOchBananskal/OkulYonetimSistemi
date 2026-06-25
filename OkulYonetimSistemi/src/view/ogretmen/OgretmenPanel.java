package view.ogretmen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Ogretmen;

public class OgretmenPanel extends JFrame implements ActionListener {

	public OgretmenPanel(Ogretmen ogretmen) {
		setTitle("Öğretmen Paneli");
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		setVisible(true);
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {}
}
