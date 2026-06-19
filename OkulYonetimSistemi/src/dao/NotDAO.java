package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Not;
import model.Ogrenci;

public class NotDAO {
	public boolean ekle(Not not) {

	    String sql =
	        "INSERT INTO notlar" +
	        "(ogrenci_id,ders_id,vize,final_notu) " +
	        "VALUES(?,?,?,?)";

	    try(Connection conn = DBConnection.connect();
	        PreparedStatement pstmt =
	            conn.prepareStatement(sql)) {

	        pstmt.setInt(1, not.getOgrenciId());
	        pstmt.setInt(2, not.getDersId());
	        pstmt.setInt(3, not.getVize());
	        pstmt.setInt(4, not.getFinalNotu());

	        pstmt.executeUpdate();

	        return true;

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
public List<Not> listele(){
		
		List<Not> notlar =new ArrayList<>();
		String sql="SELECT * From notlar";
		
		try(Connection conn=DBConnection.connect();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	Not not = new Not(
			    			rs.getInt("id"),
			    			rs.getInt("ogrenci_id"),
			    			rs.getInt("ders_id"),
			    			rs.getInt("vize"),
			    			rs.getInt("final_notu")
			    			
			    			);
			    	notlar.add(not);
			    }
			
		}catch(Exception e) {
	        e.printStackTrace();
	    }
		return notlar;
		
	}
}
