package com.duth.engapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "FAVORITES")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Favorite {
    @EmbeddedId
    private FavoriteId id;

    @MapsId("dictionaryid")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DICTIONARYID", nullable = false)
    private Dictionary dictionaryid;

    @MapsId("userid")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USERID", nullable = false)
    private User userid;

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Dictionary getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(Dictionary dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    public FavoriteId getId() {
        return id;
    }

    public void setId(FavoriteId id) {
        this.id = id;
    }
}