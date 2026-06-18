package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
import model.Ogrenci;

public class OgrenciDAO {

	public Ogrenci girisKontrol(String email,String sifre) {
		String sql="SELECT * from ogrenciler "+
				   "WHERE email=? AND sifre=?";
		
		try(Connection conn =DBConnection.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				
			pstmt.setString(1, email);
			pstmt.setString(2, sifre);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Ogrenci(rs.getInt("id"),
		                rs.getString("ad"),
		                rs.getString("soyad"),
		                rs.getString("ogrenci_no"),
		                rs.getString("email"),
		                rs.getInt("bolum_id"),
		                rs.getString("sifre")
		                );
				
			}
			
		}catch (Exception err) {
            err.printStackTrace();
        }
		
		return null;
	}
	
	public boolean ekle(Ogrenci ogrenci) {
		String sql="INSERT INTO ogrenciler(ad,soyad,ogrenci_no,email,bolum_id,sifre) VALUES(?,?,?,?,?,?)";
		
		try (Connection conn = DBConnection.connect();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				pstmt.setString(1, ogrenci.getAd());
				pstmt.setString(2, ogrenci.getSoyad());
				pstmt.setString(3, ogrenci.getOgrenciNo());
				pstmt.setString(4, ogrenci.getEmail());
				pstmt.setInt(5, ogrenci.getBolumId());
				pstmt.setString(6, ogrenci.getSifre());
				
			
				pstmt.executeUpdate();
			
				return true;
				
		}
		catch (Exception err) {
            err.printStackTrace();
            return false;
            
        }
	}
	
}
