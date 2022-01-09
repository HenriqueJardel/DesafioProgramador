package com.jt.springboot2backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Boletim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double prova1;
    private double prova2;
    private double prova3;
    private double prova4;
    private double trabalho;

    private double media;
    private double mediaGeral;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    public Boletim() {
    }

    public Boletim(Integer id, Double prova1, Double prova2, Double prova3, Double prova4, Double trabalho, Aluno aluno) {
        this.id = id;
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.prova3 = prova3;
        this.prova4 = prova4;
        this.trabalho = trabalho;
        this.media = (prova1 * 0.15) + (prova2 * 0.15) + (prova3 * 0.15) + (prova4 * 0.15) + (trabalho * 0.4);
        this.aluno = aluno;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getProva1() {
        return this.prova1;
    }

    public void setProva1(double prova1) {
        this.prova1 = prova1;
    }

    public double getProva2() {
        return this.prova2;
    }

    public void setProva2(double prova2) {
        this.prova2 = prova2;
    }

    public double getProva3() {
        return this.prova3;
    }

    public void setProva3(double prova3) {
        this.prova3 = prova3;
    }

    public double getProva4() {
        return this.prova4;
    }

    public void setProva4(double prova4) {
        this.prova4 = prova4;
    }

    public double getTrabalho() {
        return this.trabalho;
    }

    public void setTrabalho(double trabalho) {
        this.trabalho = trabalho;
    }

    public double getMedia() {
        return this.media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediaGeral() {
        return this.mediaGeral;
    }

    public void setMediaGeral(double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public String getSituacao() {
        if(media > 6)
            return "Aprovado";
        else 
            return "Reprovado";
    }

}
