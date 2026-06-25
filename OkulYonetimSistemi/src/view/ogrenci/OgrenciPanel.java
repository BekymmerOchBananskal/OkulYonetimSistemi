package view.ogrenci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Ogrenci;


public class OgrenciPanel extends JFrame implements ActionListener {
	public OgrenciPanel(Ogrenci ogrenci) {
		setTitle("Öğrenci Paneli");
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
