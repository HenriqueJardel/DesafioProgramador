package com.jt.springboot2backend.services;

import java.util.List;
import java.util.Optional;

import com.jt.springboot2backend.domain.Aluno;
import com.jt.springboot2backend.domain.Boletim;
import com.jt.springboot2backend.repositories.BoletimRepository;
import com.jt.springboot2backend.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletimService {
    
    @Autowired
    private BoletimRepository boletimRepository;

    @Autowired
    private AlunoService alunoService;

    public Boletim find(Integer id) {
        Optional<Boletim> obj = boletimRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Boletim não encontrado id: " + id + ", Tipo: " + Boletim.class.getName()));
    }
    
    public List<Boletim> findAll() {
        return boletimRepository.findAll();
    }

    public Boletim insert(Boletim obj, Integer id) {
        Aluno aluno = alunoService.find(id);
        Boletim boletim = new Boletim(null, obj.getProva1(), obj.getProva2(), obj.getProva3(), obj.getProva4(), obj.getTrabalho(), aluno);
        return boletimRepository.save(boletim);
    }

    public Boletim insertAll(Boletim obj) {
        List<Aluno> alunos = alunoService.findAll();
        
        for (int i = alunos.size() -1 ; i >= 0; i--) {
            Aluno aluno = alunos.get(i);
            Boletim boletim = new Boletim(null, obj.getProva1(), obj.getProva2(), obj.getProva3(), obj.getProva4(), obj.getTrabalho(), aluno);
            boletimRepository.save(boletim);
            System.out.println("Entrei x " + i + "Vezes já");
        }

        return obj;
    }
    
    public Boletim update(Boletim obj) {
        Boletim novo = find(obj.getId());
        novo.setProva1(obj.getProva1());
        novo.setProva2(obj.getProva2());
        novo.setProva3(obj.getProva3());
        novo.setProva4(obj.getProva4());
        novo.setTrabalho(obj.getTrabalho());
        return boletimRepository.save(novo);
    }

    public Boletim delete(Integer id) {
        Boletim Boletim = find(id);
        boletimRepository.deleteById(id);
        return Boletim;
    }
}
