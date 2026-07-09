package view.ogretmen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.BolumDAO;
import dao.OgrenciDAO;
import model.Bolum;
import model.Ogrenci;
import model.Ogretmen;

public class OgrenciIsleriPanel extends JFrame implements ActionListener {
	
	JLabel lblFoto,lblAd,lblSoyad,lblOgrenciNo,lblEmail,lblSifre,lblBolum;
	JTextField txtAd,txtSoyad,txtOgrenciNo,txtEmail,txtSifre,txtAra;
	JComboBox<Bolum> cbBolum;
	JButton btnEkle,btnGuncelle,btnSil,btnTemizle,btnFotoSec,btnAra,btnGeri;
	// Tablo ve tablo modeli
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;
    Ogretmen ogretmen;
	
	public OgrenciIsleriPanel(Ogretmen ogretmen) {
		// Arayüz özellikleri
		setTitle("Öğrenci İşleri Paneli");
		setSize(600,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		this.ogretmen=ogretmen;
		
		// Arka plan resim
		ImageIcon bg= new ImageIcon(getClass().getResource("/img/mavirenk.jpg"));
		Image img = bg.getImage();
		 Image scaledImg = img.getScaledInstance(
	                600,
	                500,
	                Image.SCALE_SMOOTH
	        );
		 JLabel background = new JLabel(new ImageIcon(scaledImg));
		 
		 ImageIcon icon = new ImageIcon(
		            getClass().getResource("/img/logo.png")
		        );
		 setIconImage(icon.getImage());
		 
		 background.setLayout(new java.awt.BorderLayout());
		 
		 // Üst panel
		 JPanel ustPanel= new JPanel(new BorderLayout());
		 ustPanel.setOpaque(false);
		 TitledBorder border = BorderFactory.createTitledBorder(
			        BorderFactory.createLineBorder(Color.WHITE, 2),
			        "Öğrenci Bilgileri"
			);
		 border.setTitleFont(new Font("Segoe UI",Font.BOLD,12));
		 border.setTitleColor(Color.WHITE);

		 ustPanel.setBorder(border);
		 // Sol panel
		 JPanel solPanel=new JPanel(new GridBagLayout());
		 solPanel.setOpaque(false);
		 JPanel sagPanel = new JPanel(new BorderLayout());
		 
		 // Sağ panel
		 sagPanel.setOpaque(false);
		 sagPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
		 
		 // Foto Panel
		 JPanel fotoPanel = new JPanel(new GridBagLayout());
		 fotoPanel.setOpaque(false);
		 sagPanel.add(fotoPanel, BorderLayout.NORTH);
		 
		 ustPanel.add(solPanel,BorderLayout.WEST);
		 ustPanel.add(sagPanel,BorderLayout.EAST);
		 
		 
		 // Label font ayarları
		 Font font=new Font("Segoe UI",Font.BOLD,11);
		 // TextField ölçüler
		 Dimension fieldSize =
	                new Dimension(120, 15);
		 
		 //Fotograf alanı
		 lblFoto = new JLabel();
		 lblFoto.setPreferredSize(new Dimension(90,100));
		 lblFoto.setBackground(Color.WHITE);
		 lblFoto.setOpaque(true);
		 lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		 lblFoto.setHorizontalAlignment(JLabel.CENTER);
		 lblFoto.setText("FOTO");
		 lblFoto.setForeground(Color.GRAY);
		 lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		 lblFoto.setVerticalAlignment(SwingConstants.CENTER);
		 
		 //lbl ad
		 lblAd=new JLabel("Ad: ");
		 lblAd.setFont(font);
		 lblAd.setForeground(Color.WHITE);
		 // TextField ad
		 txtAd=new JTextField();
		 txtAd.setPreferredSize(fieldSize);
		 
		 lblSoyad=new JLabel("Soyad: ");
		 lblSoyad.setFont(font);
		 lblSoyad.setForeground(Color.WHITE);
		 
		 // TextField soyad
		 txtSoyad=new JTextField();
		 txtSoyad.setPreferredSize(fieldSize);
		 
		 //Öğrenci no label
		 lblOgrenciNo=new JLabel("Öğrenci No: ");
		 lblOgrenciNo.setFont(font);
		 lblOgrenciNo.setForeground(Color.WHITE);
		 
		 // TextField Öğrenci no
		 txtOgrenciNo=new JTextField();
		 txtOgrenciNo.setPreferredSize(fieldSize);
		 
		 // Email label
		 lblEmail=new JLabel("Email: ");
		 lblEmail.setFont(font);
		 lblEmail.setForeground(Color.WHITE);
		 
		 // TextField Email
		 txtEmail=new JTextField();
		 txtEmail.setPreferredSize(fieldSize);
		 
		 // Bolum label
		 lblBolum=new JLabel("Bölüm: ");
		 lblBolum.setFont(font);
		 lblBolum.setForeground(Color.WHITE);
		 
		 // Combobox bölüm
		 cbBolum=new JComboBox<>();
		 cbBolum.setFont(font);
		 cbBolum.setPreferredSize(new Dimension(160, 20));
		 
		// Şifre label
		lblSifre=new JLabel("Şifre: ");
		lblSifre.setFont(font);
		lblSifre.setForeground(Color.WHITE);
		
		// TextField Email
		txtSifre=new JTextField();
		txtSifre.setPreferredSize(fieldSize);
		
		 //Foto seçme icon
		 ImageIcon btnFotoIcon=new ImageIcon(getClass().getResource("/img/fotosec.png"));
		 Image btnDersImg=btnFotoIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		 ImageIcon scaledFotoIcon=new ImageIcon(btnDersImg);
		 
		//Fotograf seçme butonu
		 btnFotoSec = new JButton(
				    "<html><center>Fotoğraf Seç</center></html>",
				    scaledFotoIcon);
		 btnFotoSec.setPreferredSize(new Dimension(95, 42));
		 btnFotoSec.setHorizontalTextPosition(SwingConstants.CENTER);
		 btnFotoSec.setVerticalTextPosition(SwingConstants.BOTTOM);
		 btnFotoSec.setFont(new Font("Segoe UI",Font.BOLD,9));
		 btnFotoSec.addActionListener(this);
		 
		 //İşlem butonları
		 // Ekleme butonu
		 ImageIcon btnEkleIcon= new ImageIcon(getClass().getResource("/img/ekleIcon.png"));
		 Image btnEkleImg=btnEkleIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		 ImageIcon scaledEkleIcon = new ImageIcon(btnEkleImg);
		 btnEkle=new JButton("Ekle",scaledEkleIcon);
		 btnEkle.setFont(new Font("Segoe UI", Font.BOLD, 11));
		 btnEkle.setPreferredSize(new Dimension(80, 20));
		 btnEkle.addActionListener(this);
		 
		 // Güncelleme butonu
		 ImageIcon btnGuncelleIcon= new ImageIcon(getClass().getResource("/img/guncelleIcon.png"));
		 Image btnGuncelleImg=btnGuncelleIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		 ImageIcon scaledGuncelleIcon = new ImageIcon(btnGuncelleImg);
		 btnGuncelle=new JButton("Güncelle",scaledGuncelleIcon);
		 btnGuncelle.setFont(new Font("Segoe UI", Font.BOLD, 11));
		 btnGuncelle.setPreferredSize(new Dimension(110, 20));
		 btnGuncelle.addActionListener(this);
		 
		 // Silme butonu
		 ImageIcon btnSilIcon= new ImageIcon(getClass().getResource("/img/silIcon.png"));
		 Image btnSilImg=btnSilIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		 ImageIcon scaledSilIcon = new ImageIcon(btnSilImg);
		 btnSil=new JButton("Sil",scaledSilIcon);
		 btnSil.setFont(new Font("Segoe UI", Font.BOLD, 11));
		 btnSil.setPreferredSize(new Dimension(80, 20));
		 btnSil.addActionListener(this);
		 
		 // Temizleme butonu
		 ImageIcon btnTemizleIcon= new ImageIcon(getClass().getResource("/img/temizleIcon.png"));
		 Image btnTemizleImg=btnTemizleIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		 ImageIcon scaledTemizleIcon = new ImageIcon(btnTemizleImg);
		 btnTemizle=new JButton("Temizle",scaledTemizleIcon);
		 btnTemizle.setFont(new Font("Segoe UI", Font.BOLD, 11));
		 btnTemizle.setPreferredSize(new Dimension(100, 20));
		 btnTemizle.addActionListener(this);
		 
		 // İşlem Paneli
		 JPanel islemPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
		 islemPanel.setOpaque(false);
		 islemPanel.add(btnEkle);
		 islemPanel.add(btnGuncelle);
		 islemPanel.add(btnSil);
		 islemPanel.add(btnTemizle);	
		 
		 //Arama Panel
		 JPanel aramaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
		 aramaPanel.setOpaque(false);
		 
		 // Arama bölümü
		 JLabel lblAra=new JLabel("Ara: ");
		 lblAra.setForeground(Color.WHITE);
		 lblAra.setFont(font);
		 
		 txtAra=new JTextField();
		 txtAra.setPreferredSize(new Dimension(160, 20));
		 
		 ImageIcon btnAraIcon= new ImageIcon(getClass().getResource("/img/aramaIcon.png"));
		 Image btnAraImg=btnAraIcon.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		 ImageIcon scaledAraIcon = new ImageIcon(btnAraImg);
		 btnAra=new JButton("Ara",scaledAraIcon);
		 btnAra.setFont(new Font("Segoe UI",Font.BOLD,9));
		 btnAra.setPreferredSize(new Dimension(80, 20));
		 btnAra.addActionListener(this);
		 
		 aramaPanel.add(lblAra);
		 aramaPanel.add(txtAra);
		 aramaPanel.add(btnAra);
		 
		 
		// JTable özellikleri
		String[] columns = {
				"ID",
				"AD",
				"SOYAD",
				"ÖĞRENCİ NO",
				"BÖLÜM",
				"EMAIL"
				
		};
		// Tablo modeli oluşturma
        model = new DefaultTableModel(columns,0);
        
        
     // Tablo oluşturma
        table = new JTable(model);
        
     // Tablo sütunlarını elle boyutlandırma
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Satır yüksekliği
        table.setRowHeight(25);

        // Sütun genişlikleri
        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(30);

        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(140);
        table.getColumnModel().getColumn(5).setPreferredWidth(140);

        // Tabloyu scroll pane içine alma
        scrollPane = new JScrollPane(table);
        JPanel altPanel=new JPanel(new BorderLayout());
        altPanel.setOpaque(false);
        TitledBorder altborder = BorderFactory.createTitledBorder(
		        BorderFactory.createLineBorder(Color.WHITE, 2),
		        "Öğrenci Listesi"
		);
        // Geri dönüş panel
        JPanel geriPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        // Geri dönüş buton
        ImageIcon btnGeriIcon= new ImageIcon(getClass().getResource("/img/geriIcon.png"));
		 Image btnGeriImg=btnGeriIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		 ImageIcon scaledGeriIcon = new ImageIcon(btnGeriImg);
		 btnGeri=new JButton("Geri",scaledGeriIcon);
		 
		 btnGeri.setFont(new Font("Segoe UI",Font.BOLD,11));
		 btnGeri.setPreferredSize(new Dimension(90, 25));
		 btnGeri.addActionListener(this);
        
        geriPanel.add(btnGeri);
        altborder.setTitleFont(new Font("Segoe UI",Font.BOLD,12));
        altborder.setTitleColor(Color.WHITE);
        altPanel.setBorder(altborder);
        altPanel.add(scrollPane,BorderLayout.CENTER);
        altPanel.add(geriPanel,BorderLayout.SOUTH);
		 
		 
		GridBagConstraints gbc=new GridBagConstraints();
		 gbc=new GridBagConstraints();
		 gbc.insets=new Insets(10,10,5,0);
		 
		 
	     
	     //Foto alan konumu
	     gbc.gridx=0;
	     gbc.gridy=0;
	     fotoPanel.add(lblFoto,gbc);
	     
	     
	     
	     // Foto seç buton konumu
	     gbc.gridx=0;
	     gbc.gridy=1;
	     fotoPanel.add(btnFotoSec,gbc); 
	     sagPanel.add(fotoPanel,BorderLayout.NORTH);
	     
	     
	     
		
		 gbc.insets=new Insets(10,10,5,0);
	     gbc.anchor = GridBagConstraints.NORTHWEST;
	     // Ad label konum
	     gbc.gridx=0;
	     gbc.gridy=0;
	     solPanel.add(lblAd,gbc);
	     
	     // Ad textfield konum
	     gbc.gridx=1;
	     gbc.gridy=0;
	     solPanel.add(txtAd,gbc);
	     
	     // Soyad label konum
	     gbc.gridx=0;
	     gbc.gridy=1;
	     solPanel.add(lblSoyad,gbc);
	     
	     // Soyad textField konum
	     gbc.gridx=1;
	     gbc.gridy=1;
	     solPanel.add(txtSoyad,gbc);
	     
	     // Öğrenci No label konum
	     gbc.gridx=0;
	     gbc.gridy=2;
	     solPanel.add(lblOgrenciNo,gbc);
	     
	     // Öğrenci No textField konum
	     gbc.gridx=1;
	     gbc.gridy=2;
	     solPanel.add(txtOgrenciNo,gbc);
	     
	     //Email label konum
	     gbc.gridx=0;
	     gbc.gridy=3;
	     solPanel.add(lblEmail,gbc);
	     
	     //Email textfield konum
	     gbc.gridx=1;
	     gbc.gridy=3;
	     solPanel.add(txtEmail,gbc);
	     
	     //Bölüm label konum
	     gbc.gridx=0;
	     gbc.gridy=4;
	     solPanel.add(lblBolum,gbc);
	     
	     //Bölüm combobox konum
	     gbc.gridx=1;
	     gbc.gridy=4;
	     solPanel.add(cbBolum,gbc);
	     
	   //Şifre label konum
	     gbc.gridx=0;
	     gbc.gridy=5;
	     solPanel.add(lblSifre,gbc);
	     
	     //Şifre textfield konum
	     gbc.gridx=1;
	     gbc.gridy=5;
	     solPanel.add(txtSifre,gbc);
	     
	     // işlem panel konum
	     gbc.gridx=0;
	     gbc.gridy=6;
	     gbc.gridwidth=2;
	     gbc.insets = new Insets(10, 10, 5, 0);
	     solPanel.add(islemPanel,gbc);
	     
	     // Arama panel konum
	     gbc.gridx=0;
	     gbc.gridy=7;
	     gbc.gridwidth = 2;
	     gbc.insets = new Insets(5, 10, 5, 0);
	     solPanel.add(aramaPanel,gbc);
	     
	     // JTable öğrencileri listeleme
		listele();
		
		BolumDAO bolumDAO = new BolumDAO();
		List<Bolum> bolumler = bolumDAO.listele();

		for (Bolum bolum : bolumler) {
		    cbBolum.addItem(bolum);
		}
		
		// Panelleri ekleme
		ustPanel.add(solPanel,BorderLayout.WEST);
		ustPanel.add(sagPanel,BorderLayout.CENTER);
		background.add(ustPanel,BorderLayout.NORTH);
		background.add(altPanel,BorderLayout.CENTER);
		setContentPane(background);
		setVisible(true);
	}
	
	//J
	private void listele() {
		OgrenciDAO ogrenciDAO=new OgrenciDAO();
		
		List<Ogrenci>ogrenciler=ogrenciDAO.listele();
		model.setRowCount(0);
		for(Ogrenci ogrenci:ogrenciler) {
			model.addRow(new Object[] {
			        ogrenci.getId(),
			        ogrenci.getAd(),
			        ogrenci.getSoyad(),
			        ogrenci.getOgrenciNo(),
			        ogrenci.getBolumAdi(),   
			        ogrenci.getEmail()
			    });
		}
	}
	
	private int secilenBolumId() {
		Bolum bolum = (Bolum) cbBolum.getSelectedItem();
		
		if (bolum !=null) {
			return bolum.getId();
		}
		return -1;
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnGeri) {
			new OgretmenPanel(ogretmen);
			dispose();
		}
		
		else if(e.getSource()==btnEkle) {
			int bolumId=-1;
			bolumId=secilenBolumId();
			Ogrenci ogrenci=new Ogrenci(
					txtAd.getText(),
					txtSoyad.getText(),
					txtOgrenciNo.getText(),
					txtEmail.getText(),
					bolumId,
					txtSifre.getText(),
					lblFoto.getText()
					);
			OgrenciDAO ogrenciDAO=new OgrenciDAO();
			ogrenciDAO.ekle(ogrenci);
			
			listele();
			
		}
		
		else if(e.getSource()==btnFotoSec) {
			JFileChooser jfc= new JFileChooser();
			
			if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
				
				File file=jfc.getSelectedFile();
				
				ImageIcon icon=new ImageIcon(file.getAbsolutePath());
				Image img=icon.getImage().getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(),Image.SCALE_SMOOTH);
				lblFoto.setIcon(new ImageIcon(img));
				lblFoto.setText(null);
			}
		}
	}
}
