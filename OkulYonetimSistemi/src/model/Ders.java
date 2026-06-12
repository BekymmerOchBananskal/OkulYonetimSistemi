package model;

public class Ders {

	private int id;
	private String ad;
	private int kredi;
	
	private int ogretmenId;
	
	public Ders(String ad,int kredi,int ogretmenId) {
		this.ad=ad;
		this.kredi=kredi;
		this.ogretmenId=ogretmenId;
	}
	public Ders(int id,String ad,int kredi,int ogretmenId) {
		this.id=id;
		this.ad=ad;
		this.kredi=kredi;
		this.ogretmenId=ogretmenId;
	}
	public int getId() {
		return id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public int getOgretmenId() {
		return ogretmenId;
	}
	public int getKredi() {
		return kredi;
	}
	
	
	
	
	
	
	public void setAd(String ad) {
		this.ad=ad;
	}
	
	
	
	
	public void setKredi(int kredi) {
		this.kredi=kredi;
	}
	public void setOgretmenId(int ogretmenId) {
		this.ogretmenId=ogretmenId;
	}
}
