package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		String sql="INSERT INTO ogrenciler(ad,soyad,ogrenci_no,email,bolum_id,sifre,foto) VALUES(?,?,?,?,?,?,?)";
		
		try (Connection conn = DBConnection.connect();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				pstmt.setString(1, ogrenci.getAd());
				pstmt.setString(2, ogrenci.getSoyad());
				pstmt.setString(3, ogrenci.getOgrenciNo());
				pstmt.setString(4, ogrenci.getEmail());
				pstmt.setInt(5, ogrenci.getBolumId());
				pstmt.setString(6, ogrenci.getSifre());
				pstmt.setString(7, ogrenci.getFoto());
				
			
				pstmt.executeUpdate();
			
				return true;
				
		}
		catch (Exception err) {
            err.printStackTrace();
            return false;
            
        }
	}
	public List<Ogrenci> listele(){
		
		List<Ogrenci> ogrenciler =new ArrayList<>();
		String sql="SELECT o.*, b.ad AS bolum_adi\r\n"
				+ "FROM ogrenciler o\r\n"
				+ "JOIN bolumler b\r\n"
				+ "ON o.bolum_id = b.id;";
		
		try(Connection conn=DBConnection.connect();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	Ogrenci ogrenci = new Ogrenci(
			    			rs.getInt("id"),
			    		    rs.getString("ad"),
			    		    rs.getString("soyad"),
			    		    rs.getString("ogrenci_no"),
			    		    rs.getString("email"),
			    		    rs.getInt("bolum_id"),
			    		    rs.getString("bolum_adi"),
			    		    rs.getString("sifre"),
			    		    rs.getString("foto")
			    			);
			    	ogrenciler.add(ogrenci);
			    }
			
		}catch(Exception e) {
	        e.printStackTrace();
	    }
		return ogrenciler;
		
	}
	
}
