package com.duth.engapp.repository;

import com.duth.engapp.entity.Score;
import com.duth.engapp.entity.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScoreId> {
}