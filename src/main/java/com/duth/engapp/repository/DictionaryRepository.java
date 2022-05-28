package com.duth.engapp.repository;

import com.duth.engapp.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    Dictionary findDictionariesByWord(String word);
}
