package model;

public class Not {

    private int id;
    private int ogrenciId;
    private int dersId;
    private int vize;
    private int finalNotu;

    public Not(int ogrenciId, int dersId, int vize, int finalNotu) {
        this.ogrenciId = ogrenciId;
        this.dersId = dersId;
        this.vize = vize;
        this.finalNotu = finalNotu;
    }

    public Not(int id, int ogrenciId, int dersId, int vize, int finalNotu) {
        this.id = id;
        this.ogrenciId = ogrenciId;
        this.dersId = dersId;
        this.vize = vize;
        this.finalNotu = finalNotu;
    }

    public int getId() {
        return id;
    }

    public int getOgrenciId() {
        return ogrenciId;
    }

    public int getDersId() {
        return dersId;
    }

    public int getVize() {
        return vize;
    }

    public int getFinalNotu() {
        return finalNotu;
    }

    public void setOgrenciId(int ogrenciId) {
        this.ogrenciId = ogrenciId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public void setVize(int vize) {
        this.vize = vize;
    }

    public void setFinalNotu(int finalNotu) {
        this.finalNotu = finalNotu;
    }
    
    public double ortalamaHesapla() {
        return vize * 0.4 + finalNotu * 0.6;
    }
    public String harfNotuHesapla() {

        double ort = ortalamaHesapla();

        if(ort >= 90) return "AA";
        if(ort >= 85) return "BA";
        if(ort >= 80) return "BB";
        if(ort >= 75) return "CB";
        if(ort >= 70) return "CC";
        if(ort >= 65) return "DC";
        if(ort >= 60) return "DD";
        if(ort >= 50) return "FD";

        return "FF";
    }
}
