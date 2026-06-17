package model;

public class Ogretmen {
	private int id;
	private String ad;
	private String soyad;
	private String email;
	private int bolumId;
	private String sifre;
	
	public Ogretmen(String ad,String soyad,String email,int bolumId,String sifre) {
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.bolumId=bolumId;
		this.sifre = sifre;
	}
	public Ogretmen(int id,String ad,String soyad,String email,int bolumId,String sifre) {
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.bolumId=bolumId;
		this.sifre = sifre;
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
	public String getSifre() {
	    return sifre;
	}

	public void setSifre(String sifre) {
	    this.sifre = sifre;
	}
}
