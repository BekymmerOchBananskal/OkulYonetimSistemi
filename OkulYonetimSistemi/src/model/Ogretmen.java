package model;

public class Ogretmen {
	private int id;
	private String ad;
	private String soyad;
	private String email;
	private int bolumId;
	
	public Ogretmen(String ad,String soyad,String email,int bolumId) {
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.bolumId=bolumId;
	}
	public Ogretmen(int id,String ad,String soyad,String email,int bolumId) {
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.bolumId=bolumId;
	}
	public int getId() {
		return id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public String getEmail() {
		return email;
	}
	public int getBolumId() {
		return bolumId;
	}
	
	public void setAd(String ad) {
		this.ad=ad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad=soyad;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setBolumId(int bolumId) {
		this.bolumId=bolumId;
	}
}
