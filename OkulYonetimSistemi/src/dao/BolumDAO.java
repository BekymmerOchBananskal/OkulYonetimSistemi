package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import database.DBConnection;
import model.Bolum;



public class BolumDAO {

	public boolean ekle(Bolum bolum) {
		
		String sql="INSERT INTO bolumler(ad) VALUES(?)";
		
		try (Connection conn = DBConnection.connect();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, bolum.getAd());
			
			pstmt.executeUpdate();
			
			return true;
		}
		catch (Exception err) {
            err.printStackTrace();
            return false;
            
        }
	}
}
