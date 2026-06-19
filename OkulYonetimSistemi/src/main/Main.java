package main;
import java.util.List;

import dao.BolumDAO;
import dao.BolumDersDAO;
import dao.DersDAO;
import dao.NotDAO;
import dao.OgrenciDAO;
import dao.OgretmenDAO;
import database.DBInitializer;
import model.Bolum;
import model.BolumDers;
import model.Ders;
import model.Not;
import model.Ogrenci;
import model.Ogretmen;

public class Main {

	public static void main(String[] args) {
		
		//DBInitializer.createTable();
		System.out.println("Program başlatıldı.");
		
//		OgrenciDAO dao=new OgrenciDAO();
//		Ogrenci ogrenci=dao.girisKontrol("elcin@gmail.com","240309021");
//		
//		if(ogrenci !=null) {
//			System.out.println("Giriş Başarılı...");
//			System.out.println("Hoşgeldin "+ogrenci.getAd()+ "  "+ogrenci.getSoyad());
//			
//		}
//		else {
//		    System.out.println("Giriş Bşarısız! ");
//		}
		
//		OgretmenDAO dao =new OgretmenDAO();
//		Ogretmen ogretmen=dao.girisKontrol("atilimtor@gmail.com", "370755.Atilim");
//		
//		if(ogretmen !=null) {
//			System.out.println("Giriş Başarılı...");
//			System.out.println("Hoş Geldin "+ogretmen.getAd()+" "+ogretmen.getSoyad());
//		}
//		else {
//			System.out.println("Giriş Başarısız! ");
//		}
		
//		BolumDAO dao =new BolumDAO();
//		Bolum blm= new Bolum("İnşaat Mühendisliği");
//		if(dao.ekle(blm)) {
//			System.out.println("Başarılı");
//		}
//		else {
//			System.out.println("Başarısız");
//		}
		
//		OgrenciDAO dao=new OgrenciDAO();
//		Ogrenci ogrenci=new Ogrenci("Mahmut","Şok","240309022","mahmut@hotmail.com",2,"240309022");
//		if(dao.ekle(ogrenci)) {
//			System.out.println("Öğrenci başarılı şekilde eklendi!");
//		}
//		else {
//			System.out.println("Öğrenci eklenemedi!");
//		}
		
//		DersDAO dao=new DersDAO();
//		Ders ders=new Ders("Nesne Tabanlı Programlama",3,1);
//		
//		if(dao.ekle(ders)) {
//			System.out.println("Ders başarılı şekilde eklendi!");
//		}
//		else {
//			System.out.println("Ders eklenemedi!");
//		}
		
//		BolumDersDAO dao = new BolumDersDAO();
//		
//		BolumDers bd=new BolumDers(1,1);
//		
//		if(dao.ekle(bd)) {
//			System.out.println(" Başarılı şekilde eklendi!");
//		}
//		else {
//			System.out.println("Eklenemedi!");
//		}
		
//		NotDAO dao = new NotDAO();
//
//		Not not1 = new Not(
//		    1, 
//		    1, 
//		    70,
//		    90
//		);
//
//		dao.ekle(not1);
		
		
		
//		OgrenciDAO dao = new OgrenciDAO();
//
//        List<Ogrenci> ogrenciler = dao.listele();
//
//        for(Ogrenci ogrenci : ogrenciler) {
//
//            System.out.println(
//                ogrenci.getId() + "\n" +
//                ogrenci.getAd()+"\n"+
//                ogrenci.getSoyad() + "\n" +
//                ogrenci.getOgrenciNo() +"\n"+
//                ogrenci.getEmail() + "\n" +
//                ogrenci.getBolumId() +"\n**********************"
//                
//            );
//        }
//		OgretmenDAO dao = new OgretmenDAO();
//
//        List<Ogretmen> ogretmenler = dao.listele();
//
//        for(Ogretmen ogretmen : ogretmenler) {
//
//            System.out.println(
//                ogretmen.getId() + "\n" +
//                ogretmen.getAd()+"\n"+
//                ogretmen.getSoyad() + "\n" +
//                ogretmen.getEmail() + "\n" +
//                ogretmen.getBolumId() +"\n**********************"
//                
//            );
//        }
//		BolumDAO dao = new BolumDAO();
//
//        List<Bolum> bolumler = dao.listele();
//
//        for(Bolum bolum : bolumler) {
//
//            System.out.println(
//                bolum.getId() + "\n" +
//                bolum.getAd()+"\n"
//                
//                
//            );
//        }
		
//		NotDAO dao = new NotDAO();
//
//        List<Not> notlar = dao.listele();
//
//        for(Not not : notlar) {
//
//            System.out.println(
//                not.getId() + "\n" +
//                not.getOgrenciId() + "\n"+
//                not.getDersId() + "\n" +
//                not.getVize() +"\n"+
//                not.getFinalNotu()
//                		
//                
//                
//            );
//        }
//		
		BolumDersDAO dao = new BolumDersDAO();

        List<BolumDers> bolumDersler = dao.listele();

        for(BolumDers bolumDers : bolumDersler) {

            System.out.println(
                bolumDers.getId() + "\n" +
                bolumDers.getBolumId() + "\n"+
                bolumDers.getDersId() + "\n" 
                
                		
                
                
            );
        }
		
	}

}
