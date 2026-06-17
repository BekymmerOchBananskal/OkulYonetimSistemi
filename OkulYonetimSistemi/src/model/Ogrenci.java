package model;

public class Ogrenci {
	
	private int id;
	private String ad;
	private String soyad;
	private String ogrenciNo;
	private String email;
	private int bolumId;
	private String sifre;
	
	public Ogrenci(String ad,String soyad,String ogrenciNo,String email,int bolumId,String sifre) {
		this.ad=ad;
		this.soyad=soyad;
		this.ogrenciNo=ogrenciNo;
		this.email=email;
		this.bolumId=bolumId;
		this.sifre = sifre;
		
	}
	
	public Ogrenci(int id,String ad,String soyad,String ogrenci_no,String email,int bolum_id,String sifre) {
		this.id=id;
		this.ad=ad;
		this.soyad=soyad;
		this.ogrenciNo=ogrenci_no;
		this.email=email;
		this.bolumId=bolum_id;
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
	public String getOgrenciNo() {
		return ogrenciNo;
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
	public void setOgrenciNo(String ogrenci_no) {
		this.ogrenciNo=ogrenci_no;
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
