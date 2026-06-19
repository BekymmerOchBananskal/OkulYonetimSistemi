package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.BolumDers;
import model.Not;

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
	public List<BolumDers> listele(){
		List<BolumDers> bolumDersler =new ArrayList<>();
		String sql="SELECT * From bolum_ders";
		
		try(Connection conn=DBConnection.connect();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	BolumDers bolumDers = new BolumDers(
			    			rs.getInt("id"),
			    			rs.getInt("bolum_id"),
			    			rs.getInt("ders_id")
			    			
			    			);
			    	bolumDersler.add(bolumDers);
			    }
			
		}catch(Exception e) {
	        e.printStackTrace();
	    }
		return bolumDersler;
    }
}
