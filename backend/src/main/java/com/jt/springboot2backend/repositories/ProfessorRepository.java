package com.jt.springboot2backend.repositories;

import com.jt.springboot2backend.domain.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor, Integer> { 
}
