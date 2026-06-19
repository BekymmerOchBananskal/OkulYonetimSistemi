package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.DBConnection;
import model.Bolum;
import model.Ogrenci;



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
	
public List<Bolum> listele(){
		
		List<Bolum> bolumler =new ArrayList<>();
		String sql="SELECT * From bolumler";
		
		try(Connection conn=DBConnection.connect();
				PreparedStatement pstmt=conn.prepareStatement(sql)){
				
			    ResultSet rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	Bolum bolum = new Bolum(
			    			rs.getInt("id"),
			    			rs.getString("ad")
			    			
			    			);
			    	bolumler.add(bolum);
			    }
			
		}catch(Exception e) {
	        e.printStackTrace();
	    }
		return bolumler;
		
	}
}
