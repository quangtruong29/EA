package com.duth.engapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DICTIONARY")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@ToString
public class Dictionary {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "WORD", nullable = false, length = 400)
    private String word;

    @Column(name = "IPA", nullable = false, length = 100)
    private String ipa;

    @JsonManagedReference
    @OneToMany(mappedBy = "dictionaryid")
    private Set<Meaning> meanings = new LinkedHashSet<>();

    public Dictionary() {
    }
    public Long getId() {
        return this.id;
    }

    public String getWord() {
        return this.word;
    }

    public String getIpa() {
        return this.ipa;
    }

    public Set<Meaning> getMeanings() {
        return this.meanings;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setIpa(String ipa) {
        this.ipa = ipa;
    }

    public void setMeanings(Set<Meaning> meanings) {
        this.meanings = meanings;
    }
}