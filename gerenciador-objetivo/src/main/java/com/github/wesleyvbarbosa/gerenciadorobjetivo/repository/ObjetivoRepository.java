package com.github.wesleyvbarbosa.gerenciadorobjetivo.repository;

import com.github.wesleyvbarbosa.gerenciadorobjetivo.model.entity.Objetivo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

}
