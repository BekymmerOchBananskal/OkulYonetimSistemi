package view.ogretmen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Ogretmen;

public class OgretmenPanel extends JFrame implements ActionListener {

	public OgretmenPanel(Ogretmen ogretmen) {
		setTitle("Akademisyen Paneli");
		setSize(500,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ImageIcon bg= new ImageIcon(getClass().getResource("/img/mavirenk.jpg"));
		Image img = bg.getImage();
		 Image scaledImg = img.getScaledInstance(
	                500,
	                400,
	                Image.SCALE_SMOOTH
	        );
		 JLabel background = new JLabel(new ImageIcon(scaledImg));
		 
		 ImageIcon icon = new ImageIcon(
		            getClass().getResource("/img/logo.png")
		        );
		 setIconImage(icon.getImage());
		 
		 background.setLayout(new java.awt.BorderLayout());
		 
		 //Üst Panel
		 JPanel ustPanel=new JPanel(new BorderLayout());
		 ustPanel.setPreferredSize(new Dimension(500, 30));
		 ustPanel.setBorder(
				 BorderFactory.createLineBorder(Color.BLACK,3)
				);
		 
		 //Üst panel icon
		 JLabel lblIcon = new JLabel(new ImageIcon(
			        new ImageIcon(getClass().getResource("/img/akaicon.png"))
			                .getImage()
			                .getScaledInstance(30, 30, Image.SCALE_SMOOTH)
			));
		 
		 lblIcon.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		 ustPanel.add(lblIcon, BorderLayout.WEST);
		 JPanel northPanel = new JPanel(new BorderLayout());
		 northPanel.setOpaque(false);
		 northPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		 
		 // Üst panel orta başlık
		 JLabel lblBaslik = new JLabel("Akademisyen Paneli");
		 lblBaslik.setForeground(Color.BLACK);	
		 lblBaslik.setFont(new Font("Segoe UI",Font.BOLD,18));
		 ustPanel.add(lblBaslik,BorderLayout.CENTER);
		 
		 //Üst Panel Öğretmen Ad Soyad
		 JLabel lblAdSoyad=new JLabel("Hoş Geldiniz, " + ogretmen.getAd() + " " + ogretmen.getSoyad());
		 lblAdSoyad.setForeground(Color.BLACK);
		 lblAdSoyad.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
		 lblAdSoyad.setFont(new Font("Segoe UI",Font.BOLD,11));
		 ustPanel.add(lblAdSoyad,BorderLayout.EAST);
		 
		 northPanel.add(ustPanel, BorderLayout.CENTER);
		 background.add(northPanel, BorderLayout.NORTH);
		
		 //Akademisyen Logo
		
		 ImageIcon akademisyenIcon =new ImageIcon(getClass().getResource("/img/akademisyenlogo.png"));
		 Image akademisyenImg =akademisyenIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		 JLabel lblLogo=new JLabel(new ImageIcon(akademisyenImg));
		 lblLogo.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
		 
		 
		 
		 
		 //Button iconlar 
		 //Ögrenci işleri icon
		 ImageIcon btnOgrIcon = new ImageIcon(getClass().getResource("/img/ogrenci.png"));

		 Image btnOgrImg = btnOgrIcon.getImage()
		         .getScaledInstance(32, 32, Image.SCALE_SMOOTH);

		 ImageIcon scaledOgrIcon = new ImageIcon(btnOgrImg);

		 JButton btnOgrenci = new JButton("Öğrenci İşleri", scaledOgrIcon);
		 btnOgrenci.setFont(new Font("Segoe UI", Font.BOLD, 11));
		 
		 //Not işlemleri icon
		 ImageIcon btnNotIcon= new ImageIcon(getClass().getResource("/img/notIslemleriIcon.png"));
		 Image btnNotImg=btnNotIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		 ImageIcon scaledNotIcon = new ImageIcon(btnNotImg);
		 
		 //Not işlemleri buton
		 JButton btnNot=new JButton("Not İşlemleri",scaledNotIcon);
		 btnNot.setFont(new Font("Segoe UI",Font.BOLD,11));
		 
		 //Ders İşlemleri icon
		 ImageIcon btnDersIcon=new ImageIcon(getClass().getResource("/img/dersIslemleriIcon.png"));
		 Image btnDersImg=btnDersIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		 ImageIcon scaledDersIcon=new ImageIcon(btnDersImg);
		 
		 //Ders işlemleri Buton
		 JButton btnDers=new JButton("Ders İşlemleri",scaledDersIcon);
		 btnDers.setFont(new Font("Segoe UI",Font.BOLD,11));
		 
		 //Bölüm İşlemleri icon
		 ImageIcon btnBolumIcon=new ImageIcon(getClass().getResource("/img/bolumIslemleriIcon.png"));
		 Image btnBolumImg=btnBolumIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		 ImageIcon scaledBolumIcon=new ImageIcon(btnBolumImg);
		 
		 //Bölüm işlemleri buton
		 JButton btnBolum=new JButton("Bölüm İşlemleri",scaledBolumIcon);
		 btnBolum.setFont(new Font("Segoe UI",Font.BOLD,11));
		 
		 //Rapor işlemleri icon
		 ImageIcon btnRaporIcon=new ImageIcon(getClass().getResource("/img/raporIslemleriIcon.png"));
		 Image btnRaporImg=btnRaporIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		 ImageIcon scaledRaporIcon=new ImageIcon(btnRaporImg);
		 
		 //Bölüm işlemleri buton
		 JButton btnRapor=new JButton("Rapor İşlemleri",scaledRaporIcon);
		 btnRapor.setFont(new Font("Segoe UI",Font.BOLD,11));
		 
		//Rapor işlemleri icon
		 ImageIcon btnCikisIcon=new ImageIcon(getClass().getResource("/img/cikisIcon.png"));
		 Image btnCikisImg=btnCikisIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		 ImageIcon scaledCikisIcon=new ImageIcon(btnCikisImg);
		 
		 //Bölüm işlemleri buton
		 JButton btnCikis=new JButton("Çıkış",scaledCikisIcon);
		 btnCikis.setFont(new Font("Segoe UI",Font.BOLD,11));
		 
		 
		 //Buton paneli
		 JPanel buttonPanel= new JPanel(new GridLayout(3,2,15,15));
		 buttonPanel.setOpaque(false);
		 buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 40, 80));
		 buttonPanel.add(btnOgrenci);
		 buttonPanel.add(btnNot);
		 buttonPanel.add(btnDers);
		 buttonPanel.add(btnBolum);
		 buttonPanel.add(btnRapor);
		 buttonPanel.add(btnCikis);
		 
		 //Merkez Panel
		 JPanel centerPanel = new JPanel(new BorderLayout());
		 centerPanel.setOpaque(false);

		 centerPanel.add(lblLogo, BorderLayout.NORTH);
		 centerPanel.add(buttonPanel, BorderLayout.CENTER);

		 background.add(centerPanel, BorderLayout.CENTER);
		 
		 setContentPane(background);
		 setVisible(true);
	}
	
	 @Override
	    public void actionPerformed(ActionEvent e) {}
}
