package com.duth.engapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "SCORES")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Score {
    @EmbeddedId
    private ScoreId id;

    @MapsId("userid")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USERID", nullable = false)
    private User userid;

    @MapsId("setid")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SETID", nullable = false)
    private SetsOfQuestion setid;

    @Column(name = "SCORE", nullable = false)
    private Double score;

    public ScoreId getId() {
        return id;
    }

    public void setId(ScoreId id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public SetsOfQuestion getSetid() {
        return setid;
    }

    public void setSetid(SetsOfQuestion setid) {
        this.setid = setid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

}