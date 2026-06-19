package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Ogrenci;
import model.Ogretmen;

public class OgretmenDAO {
	
	public Ogretmen girisKontrol(String email,String sifre) {
		
		String sql="Select * FROM ogretmenler "+
		"WHERE email=? AND sifre=? ";
		
		try(Connection conn=DBConnection.connect();
			PreparedStatement pstmt =conn.prepareStatement(sql)){
			
			pstmt.setString(1, email);
			pstmt.setString(2, sifre);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return new Ogretmen(rs.getInt("id"),
		                rs.getString("ad"),
		                rs.getString("soyad"),
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
public List<Ogretmen> listele(){
		
		List<Ogretmen> ogretmenler =new ArrayList<>();
		String sql="SELECT * From ogretmenler";
		
		try(Connection conn=DBConnection.connect();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	Ogretmen ogretmen = new Ogretmen(
			    			rs.getInt("id"),
			    			rs.getString("ad"),
			    			rs.getString("soyad"),
			    			rs.getString("email"),
			    			rs.getInt("bolum_id"),
			    			 rs.getString("sifre")
			    			);
			    	ogretmenler.add(ogretmen);
			    }
			
		}catch(Exception e) {
	        e.printStackTrace();
	    }
		return ogretmenler;
		
	}
}
