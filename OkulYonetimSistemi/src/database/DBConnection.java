package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Veritabanı bağlantısını sağlayan sınıf
public class DBConnection {
	
	// Veritabanına bağlantı kuran metot
	public static Connection connect() {
		
		// Connection nesnesi
		Connection conn = null;
		
		try {
			
			// SQLite veritabanı bağlantı adresi
			String url="jdbc:sqlite:okul.db";
			
			 // Veritabanına bağlanma
			conn= DriverManager.getConnection(url);
		}
		// Hata oluşursa çalışır
		catch(SQLException err) {
			// Hata detayını konsola yazdırır
			 err.printStackTrace();

	            return null;
		}
		// Bağlantıyı geri döndürür
		return conn;
	}
	

}
