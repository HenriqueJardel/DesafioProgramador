package com.jt.springboot2backend.repositories;

import com.jt.springboot2backend.domain.Boletim;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletimRepository extends JpaRepository <Boletim , Integer> {
}
