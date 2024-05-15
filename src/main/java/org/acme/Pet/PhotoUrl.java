package org.acme.Pet;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class PhotoUrl extends PanacheEntity {
    @Column
    public String url;

    @ManyToOne
    public Petmodel petmodel;
}