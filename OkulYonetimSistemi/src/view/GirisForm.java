package view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.OgrenciDAO;
import dao.OgretmenDAO;
import model.Ogrenci;
import model.Ogretmen;
import view.ogrenci.OgrenciPanel;
import view.ogretmen.OgretmenPanel;

public class GirisForm  extends JFrame implements ActionListener{
	
	JLabel lblEmail, lblSifre;
	JTextField txtEmail;
	JPasswordField sifreField;
	JButton btnGiris;
	JRadioButton rdOgrenci,rdOgretmen;
	
	
	public GirisForm() {
		setTitle("Giriş");
		setSize(310,350);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ImageIcon bg= new ImageIcon(getClass().getResource("/img/mavirenk.jpg"));
		Image img = bg.getImage();
		 Image scaledImg = img.getScaledInstance(
	                310,
	                350,
	                Image.SCALE_SMOOTH
	        );
		 JLabel background = new JLabel(new ImageIcon(scaledImg));
		 
		 ImageIcon icon = new ImageIcon(
		            getClass().getResource("/img/logo.png")
		        );
		 setIconImage(icon.getImage());

	        
	     background.setBounds(0, 0, 310, 350);
	     
	     background.setLayout(new GridBagLayout());
	     
	     GridBagConstraints gbc=new GridBagConstraints();
	     
	     gbc.insets=new Insets(10,5,5,0);
	     
	     gbc.anchor = GridBagConstraints.NORTHWEST;
	     
	     // Font ayarları
	     Font font = new Font("Segoe UI", Font.BOLD, 14);
	     
	     // Email label
	     lblEmail=new JLabel("Email: ");
	     lblEmail.setForeground(Color.WHITE);
	     lblEmail.setFont(font);
	    
	     // Email textField
	     
	     txtEmail=new JTextField(15);
	     
	     // sifre label
	     
	     lblSifre=new JLabel("Şifre: ");
	     lblSifre.setForeground(Color.WHITE);
	     lblSifre.setFont(font);
	     
	     // sifre field
	     sifreField=new JPasswordField(15);
	     
	     //Öğrenci Öğretmen radiobuttonlar
	     rdOgrenci = new JRadioButton("Öğrenci");
	     rdOgretmen = new JRadioButton("Öğretmen");
	  // Radio buttonların arka planını transparan yapma
	     rdOgrenci.setOpaque(false);
	     rdOgretmen.setOpaque(false);
	  // Radio button yazı renkleri
	     rdOgrenci.setForeground(Color.WHITE);
	     rdOgretmen.setForeground(Color.WHITE);
	     
	     ButtonGroup group =new ButtonGroup();
	     group.add(rdOgrenci);
	     group.add(rdOgretmen);
	     JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
	     radioPanel.setOpaque(false);

	     radioPanel.add(rdOgrenci);
	     radioPanel.add(rdOgretmen);
	     
	     //Giriş button
	     btnGiris=new JButton("Giriş");
	  // Butona tıklama olayı ekleme
	     btnGiris.addActionListener(this);
	     
	     //Okul Logo
	     ImageIcon schoolIcon = new ImageIcon(
	    		    getClass().getResource("/img/schoollogo.png")
	    		);

	     Image scaledSchool = schoolIcon.getImage()
	    		        .getScaledInstance(144, 144, Image.SCALE_SMOOTH);

	     JLabel lblSchool =
	    		    new JLabel(new ImageIcon(scaledSchool));
	    		
	        //Okul Logo Konum
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.gridwidth = 2; // 2 sütunu kaplasın
	        gbc.anchor = GridBagConstraints.CENTER;
            background.add(lblSchool, gbc);
	    		
	    	// Email label konumu
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.weighty = 0;
	        gbc.weightx = 0;
	        gbc.gridwidth = 1;
	        gbc.insets=new Insets(10,5,5,10);
	        background.add(lblEmail, gbc);
	        
	        // Email field konumu
	        gbc.gridx=1;
	        gbc.gridy=1;
	        background.add(txtEmail,gbc);
	        
	        
	      // Şifre label konumu
	        
	        gbc.gridx=0;
	        gbc.gridy=2;
	        background.add(lblSifre,gbc);
	        
	        // Şifre field konum
	        gbc.gridx=1;
	        gbc.gridy=2;
	       background.add(sifreField,gbc);
	        
	        //Radio Button konum
	        
	        // Panel konumu
	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        gbc.anchor = GridBagConstraints.CENTER;

	        // komple biraz sağa kaydırır
	        gbc.insets = new Insets(5, 50, 5, 0);
	        background.add(radioPanel, gbc);
	        
	        //Buton konum
	        gbc.gridx=0;
	        gbc.gridy=4;
	        gbc.gridwidth=2;
	        gbc.anchor=GridBagConstraints.EAST;
	        gbc.insets=new Insets(10,5,10,17);//(üst,sol,alt,sağ)
	        background.add(btnGiris,gbc);	        		
	        

	        
	        
	        setContentPane(background);
		    setVisible(true);
	}
	
	
	 @Override
	    public void actionPerformed(ActionEvent e) {
	    	
		  //Giriş Butonuna basıldıysa
		 	if(e.getSource()==btnGiris) {
		 		
		 	    // Kullanıcının girdiği emaili alma
		 		String email=txtEmail.getText();
		 		
		 		// Kullanıcının girdiği şifreyi alma
		 		String sifre=new String(sifreField.getPassword());
		 		
		 		//Rol bilgisi
		 		String rol="";
		 		
		 		//Email ve şifre alanlarının boş olup olmadıgının kontrolu
		 		if (email.isEmpty() || sifre.isEmpty()) {
		 		    JOptionPane.showMessageDialog(this,
		 		            "Lütfen email ve şifre alanlarını doldurunuz!",
		 		            "Uyarı",
		 		            JOptionPane.WARNING_MESSAGE);
		 		    return;
		 		}
		 		// Öğretmen seçildiyse rol öğretmen olur
		 		if(rdOgretmen.isSelected()) {
		 			rol="ogretmen";
		 			
		 		}
		 		// Öğrenci seçildiyse rol öğrenci olur.
		 		else if(rdOgrenci.isSelected()) {
		 			rol="ogrenci";
		 			
		 		}
		 		// rol seçilmediyse uyarı verir
		 		else {
		 			JOptionPane.showMessageDialog(this, "Lütfen kullanıcı türünü seçiniz!");
		 			return;
		 		}
		 	// Veritabanında kullanıcı kontrolü yapılır
		 		Ogretmen ogretmen;
		 		Ogrenci ogrenci;
		 		if(rol.equals("ogretmen")) {
		 			OgretmenDAO ogretmenDao=new OgretmenDAO();
		 			ogretmen = ogretmenDao.girisKontrol(email, sifre);
		 			
		 		   // Giriş başarılı
		 			if(ogretmen != null && ogretmen.getId() != -1) {
		 				JOptionPane.showMessageDialog(this, "Giriş Başarılı!\nHoş Geldin, "+ogretmen.getAd()+" "+ogretmen.getSoyad());
		 				
		 				//OgretmenPaneli açılır
		 				new OgretmenPanel(ogretmen);
		 				
		 				// Giriş ekranı kapatılır
		 				dispose();
		 			}
		 			// Giriş başarısız
		 			else {
		 			    JOptionPane.showMessageDialog(this,
		 			            "Email veya şifre hatalı!",
		 			            "Giriş Başarısız",
		 			            JOptionPane.ERROR_MESSAGE);
		 			}
		 			
		 		}
		 		else if(rol.equals("ogrenci")) {
		 			OgrenciDAO ogrenciDao=new OgrenciDAO();
		 			ogrenci=ogrenciDao.girisKontrol(email, sifre);
		 			
		 			// Giriş başarılı
		 			if(ogrenci != null && ogrenci.getId() != -1) {
		 				JOptionPane.showMessageDialog(this, "Giriş Başarılı!\nHoş Geldiniz "+ogrenci.getAd()+" "+ogrenci.getSoyad());
		 				
		 				// Öğrenci Paneli açılır
		 				new OgrenciPanel(ogrenci);
		 				
		 				//Giriş ekranı kapatılır
		 				dispose();
		 			}
		 			// Giriş başarısız
		 			else {
		 			    JOptionPane.showMessageDialog(this,
		 			            "Email veya şifre hatalı!",
		 			            "Giriş Başarısız",
		 			            JOptionPane.ERROR_MESSAGE);
		 			}
		 		}
		 	
		 	}
		 // Giriş başarısızsa
            else {
                JOptionPane.showMessageDialog(
                        this,
                        "Giriş Başarısız!"
                );
            }
		 
	    }

}
