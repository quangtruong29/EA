package com.duth.engapp.controller;

import com.duth.engapp.entity.Score;
import com.duth.engapp.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ccore")
public class ScoreController extends RootController {
    ScoreRepository scoreRepository;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository)
    {
        this.scoreRepository = scoreRepository;
    }
    @GetMapping("/")
    List<Score> getByName() {
        return scoreRepository.findAll();
    }
}
