package org.acme.Pet;

public class Category {
    private int Cid;
    private String Cname;

    public Category() {
    }

    public Category(int Cid, String Cname) {
        this.Cid = Cid;
        this.Cname = Cname;
    }

    public int getCId() {
        return Cid;
    }

    public void setCId(int Cid) {
        this.Cid = Cid;
    }

    public String getCName() {
        return Cname;
    }

    public void setCName(String Cname) {
        this.Cname = Cname;
    }
}