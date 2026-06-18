package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;
import model.Ders;

public class DersDAO {
	
	public boolean ekle(Ders ders) {
		String sql = "Insert into dersler(ad,kredi,ogretmen_id) Values(?,?,?)";
		
		try(Connection conn=DBConnection.connect();
			PreparedStatement pstmt=conn.prepareStatement(sql)){
			
			pstmt.setString(1, ders.getAd());
			pstmt.setInt(2, ders.getKredi());
			pstmt.setInt(3, ders.getOgretmenId());
			
			pstmt.executeUpdate();
			
			return true;
			
		}
	 catch (Exception err) {
        err.printStackTrace();
        return false;
    }
	
	
	}
}
