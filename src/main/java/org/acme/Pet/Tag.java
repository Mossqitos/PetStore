package org.acme.Pet;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Tag extends PanacheEntity {
    @Column
    public int Tid;
    @Column
    public String Tname;

    @ManyToOne
    public Petmodel petmodel;
//    public Tag(int Tid, String Tname) {
//            this.Tid = Tid;
//            this.Tname = Tname;
//        }
//        public Tag() {
//        }
}

