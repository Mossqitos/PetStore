package org.acme.Pet;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Petmodel extends PanacheEntity {
    @Column
    public int id;

    @ManyToOne
    public Category category;

    @Column
    public String name;

    @OneToMany(mappedBy = "petmodel")
    public List<PhotoUrl> photoUrls;

    @ManyToMany
    @JoinTable(
            name = "petmodel_tag",
            joinColumns = @JoinColumn(name = "petmodel_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    public List<Tag> tags;

    @Enumerated(EnumType.STRING)
    @Column
    public Status status;

    public Petmodel() {
    }

    public Petmodel(int id, Category category, String name, List<PhotoUrl> photoUrls, List<Tag> tags, Status status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
}
