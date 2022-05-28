package com.duth.engapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TYPESOFWORD")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TypesOfWord {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "SHORTCUT", nullable = false, length = 50)
    private String shortcut;

    @Column(name = "NAME", length = 50)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "typeid")
    private Set<Meaning> meanings = new LinkedHashSet<>();

    public TypesOfWord() {

    }

    public TypesOfWord(Integer id, String shortcut, String name) {
        this.id = id;
        this.shortcut = shortcut;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(Set<Meaning> meanings) {
        this.meanings = meanings;
    }

}