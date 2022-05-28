package com.duth.engapp.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoriteId implements Serializable {
    private static final long serialVersionUID = 5695886831326989617L;
    @Column(name = "DICTIONARYID", nullable = false)
    private Long dictionaryid;
    @Column(name = "USERID", nullable = false)
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Long getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(Long dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictionaryid, userid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavoriteId entity = (FavoriteId) o;
        return Objects.equals(this.dictionaryid, entity.dictionaryid) &&
                Objects.equals(this.userid, entity.userid);
    }
}