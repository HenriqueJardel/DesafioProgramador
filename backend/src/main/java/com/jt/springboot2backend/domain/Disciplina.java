package com.jt.springboot2backend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String cod_disciplina;
    private String nome_disciplina;

    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Disciplina() {
    }

    public Disciplina(Integer id, String cod_disciplina, String nome_disciplina, Professor professor) {
        this.id = id;
        this.cod_disciplina = cod_disciplina;
        this.nome_disciplina = nome_disciplina;
        this.professor = professor;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod_disciplina() {
        return this.cod_disciplina;
    }

    public void setCod_disciplina(String cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    public String getNome_disciplina() {
        return this.nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
