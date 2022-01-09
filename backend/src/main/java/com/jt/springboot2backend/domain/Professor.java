package com.jt.springboot2backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Professor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dt_admissao;
    private String formacao;
    private String area_atuacao;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Disciplina> diciplinas = new ArrayList<>();

    public Professor(){
    }

    public Professor(Integer id, String nome, Date dt_admissao, String formacao, String area_atuacao) {
        this.id = id;
        this.nome = nome;
        this.dt_admissao = dt_admissao;
        this.formacao = formacao;
        this.area_atuacao = area_atuacao;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_admissao() {
        return this.dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getArea_atuacao() {
        return this.area_atuacao;
    }

    public void setArea_atuacao(String area_atuacao) {
        this.area_atuacao = area_atuacao;
    }

    public List<Disciplina> getDiciplinas() {
        return this.diciplinas;
    }

    public void setDiciplinas(List<Disciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }

}
