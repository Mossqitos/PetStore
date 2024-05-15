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
    @OneToMany(mappedBy = "petmodel")
    public List<Tag> tags;
    @Column
    public String status;
    public Petmodel() {
    }
    public Petmodel(int id, Category category, String name, List<PhotoUrl> photoUrls, List<Tag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public Category getCategory() {
//        if (this.category == null) {
//            return null;
//        }
//        return this.category;
//    }
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//    public String getName() {
//        if (this.name == null) {
//            return null;
//        }
//        return this.name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public List<String> getPhotoUrls() {
//        if (this.photoUrls == null) {
//            return null;
//        }
//        return this.photoUrls;
//    }
//    public void setPhotoUrls(List<String> photoUrls) {
//        this.photoUrls = photoUrls;
//    }
//    public List<Tag> getTags() {
//        if (this.tags == null) {
//            return null;
//        }
//        return this.tags;
//    }
//    public void setTags(List<Tag> tags) {
//        this.tags = tags;
//    }
//    public String getStatus() {
//        if (this.status == null) {
//            return null;
//        }
//        return this.status;
//    }
//    public void setStatus(String status) {
//        this.status = status;
//    }
}


