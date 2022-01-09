package com.jt.springboot2backend.repositories;

import com.jt.springboot2backend.domain.Turma;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository <Turma, Integer> {   
}
