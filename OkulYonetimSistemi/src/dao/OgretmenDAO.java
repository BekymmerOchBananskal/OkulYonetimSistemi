package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;
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
}
