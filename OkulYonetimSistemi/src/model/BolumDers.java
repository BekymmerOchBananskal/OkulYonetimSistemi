package model;

public class BolumDers {

    private int id;
    private int bolumId;
    private int dersId;

    public BolumDers(int bolumId, int dersId) {
        this.bolumId = bolumId;
        this.dersId = dersId;
    }

    public BolumDers(int id, int bolumId, int dersId) {
        this.id = id;
        this.bolumId = bolumId;
        this.dersId = dersId;
    }

    public int getId() {
        return id;
    }

    public int getBolumId() {
        return bolumId;
    }

    public int getDersId() {
        return dersId;
    }

    public void setBolumId(int bolumId) {
        this.bolumId = bolumId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }
}
