package model;

public class Bolum {
	private String ad;
	private int id;
	
	public Bolum(String ad){
		this.ad=ad;
	}
	
	public Bolum(int id, String ad) {
		this.ad=ad;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAd() {
		return ad;
		
	}
	
	public void setAd(String ad) {
		this.ad=ad;
	}
	
	
}
