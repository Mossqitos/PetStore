package org.acme.Pet;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends PanacheEntity{
    @Column
    public int Cid;
    @Column
    public String Cname;

    @OneToMany(mappedBy = "category")
    public List<Petmodel> petmodels;
//    public Category() {
//    }
//
//    public Category(int Cid, String Cname) {
//        this.Cid = Cid;
//        this.Cname = Cname;
//    }
}