package com.jt.springboot2backend.repositories;

import com.jt.springboot2backend.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Integer> {
}