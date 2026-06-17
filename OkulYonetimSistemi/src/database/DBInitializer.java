package database;

import java.sql.Connection;
import java.sql.Statement;

//Veritabanında tabloları oluşturacak  sınıf
public class DBInitializer {
	
	// Tabloları oluşturur
	public static void createTable() {
		
		String bolumler="CREATE TABLE IF NOT EXISTS bolumler ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "ad TEXT NOT NULL "
				+ ");";
		
		String ogrenciler="CREATE TABLE IF NOT EXISTS ogrenciler ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "ad TEXT NOT NULL, "
				+ "soyad TEXT NOT NULL, "
				+ "ogrenci_no TEXT NOT NULL UNIQUE, "
				+ "email TEXT NOT NULL UNIQUE, "
				+ "bolum_id INTEGER NOT NULL,"
				+ "sifre TEXT NOT NULL, "
				+ "FOREIGN KEY(bolum_id) REFERENCES bolumler(id) "
				+ ");";
		
		String ogretmenler="CREATE TABLE IF NOT EXISTS ogretmenler ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "ad TEXT NOT NULL, "
				+ "soyad TEXT NOT NULL, "
				+ "email TEXT NOT NULL UNIQUE, "
				+ "bolum_id INTEGER NOT NULL, "
				+ "sifre TEXT NOT NULL, " 
				+ "FOREIGN KEY(bolum_id) REFERENCES bolumler(id) "
				+ ");";
		
		String dersler="CREATE TABLE IF NOT EXISTS dersler ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "ad TEXT NOT NULL, "
				+ "kredi INTEGER NOT NULL, "
				+ "ogretmen_id INTEGER NOT NULL, "
				+ "FOREIGN KEY(ogretmen_id) REFERENCES ogretmenler(id) "
				+ ");";
		
		String bolum_ders="CREATE TABLE IF NOT EXISTS bolum_ders ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "bolum_id INTEGER NOT NULL, "
				+ "ders_id INTEGER NOT NULL, "
				+ "FOREIGN KEY(bolum_id) REFERENCES bolumler(id), "
				+ "FOREIGN KEY(ders_id) REFERENCES dersler(id) "
				+ ");";
		
		String notlar="CREATE TABLE IF NOT EXISTS notlar ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "ogrenci_id INTEGER NOT NULL, "
				+ "ders_id INTEGER NOT NULL, "
				+ "vize INTEGER NOT NULL, "
				+ "final_notu INTEGER NOT NULL, "
				+ "FOREIGN KEY(ogrenci_id) REFERENCES ogrenciler(id), "
				+ "FOREIGN KEY(ders_id) REFERENCES dersler(id) "
				+ ");";
		
		try(Connection conn=DBConnection.connect();
			Statement stmt =conn.createStatement()){
			
			// Tabloları çalıştırma
			stmt.execute(bolumler);
			stmt.execute(ogrenciler);
			stmt.execute(ogretmenler);
			stmt.execute(dersler);
			stmt.execute(bolum_ders);
			stmt.execute(notlar);
			
			System.out.println("Tablolar oluşturuldu.");
			
			}
		catch(Exception err) {
			err.printStackTrace();
		}
	}

}
