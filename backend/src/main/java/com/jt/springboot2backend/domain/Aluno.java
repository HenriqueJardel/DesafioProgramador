package com.jt.springboot2backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_matricula;

    @Column(unique = true)
    private String cpf;
    private String nome;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dt_nascimento;
    private int idade;
    private String nome_mae;
    private String nome_pai;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToOne(mappedBy = "aluno")
    private Boletim boletim;

    public Aluno() {
    }

    public Aluno(Integer cod_matricula, String nome, String cpf, Date dt_nascimento, int idade, String nome_mae, String nome_pai, Turma turma) {
        this.cod_matricula = cod_matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.idade = idade;
        this.nome_mae = nome_mae;
        this.nome_pai = nome_pai;
        this.turma = turma;
    }

    public Integer getCod_matricula() {
        return this.cod_matricula;
    }

    public void setCod_matricula(Integer cod_matricula) {
        this.cod_matricula = cod_matricula;
    }
    
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return this.dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome_mae() {
        return this.nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNome_pai() {
        return this.nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    };

    public Boletim getBoletim() {
        return this.boletim;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }
}
