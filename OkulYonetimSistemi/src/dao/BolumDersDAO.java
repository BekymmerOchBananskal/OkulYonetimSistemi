package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;
import model.BolumDers;

public class BolumDersDAO {
	public boolean ekle(BolumDers bd) {

        String sql =
            "INSERT INTO bolum_ders" +
            "(bolum_id, ders_id) " +
            "VALUES(?, ?)";
        
        try(Connection conn=DBConnection.connect();
    			PreparedStatement pstmt=conn.prepareStatement(sql)){
    			
    			pstmt.setInt(1, bd.getBolumId());
    			pstmt.setInt(2, bd.getDersId());
    			
    			
    			pstmt.executeUpdate();
    			
    			return true;
    			
    		}
    	 catch (Exception err) {
            err.printStackTrace();
            return false;
        }

        
    }
}
