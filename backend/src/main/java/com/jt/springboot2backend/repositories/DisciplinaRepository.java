package com.jt.springboot2backend.repositories;

import com.jt.springboot2backend.domain.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository <Disciplina, Integer> {
}
