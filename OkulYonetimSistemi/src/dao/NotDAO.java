package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.DBConnection;
import model.Not;

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
}
