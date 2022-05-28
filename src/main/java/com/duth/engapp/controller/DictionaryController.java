package com.duth.engapp.controller;

import com.duth.engapp.entity.Dictionary;
import com.duth.engapp.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends RootController{
    DictionaryRepository dictionaryRepository;
    @Autowired
    public DictionaryController(DictionaryRepository dictionaryRepository)
    {
        this.dictionaryRepository = dictionaryRepository;
    }
    @GetMapping("/all")
    Dictionary all() {
        return new Dictionary();
    }
    
    @GetMapping("/")
    Dictionary getByName(@RequestParam("word") String word) {
        return dictionaryRepository.findDictionariesByWord(word);
    }
}
