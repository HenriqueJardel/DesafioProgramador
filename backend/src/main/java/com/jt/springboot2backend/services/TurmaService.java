package com.jt.springboot2backend.services;

import java.util.List;
import java.util.Optional;

import com.jt.springboot2backend.domain.Turma;
import com.jt.springboot2backend.repositories.TurmaRepository;
import com.jt.springboot2backend.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;

    public Turma find(Integer id) {
        Optional<Turma> obj = turmaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrado id: " + id + ", Tipo: " + Turma.class.getName()));
    }
    
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma insert(Turma obj) {
        obj.setId(null);
        return turmaRepository.save(obj);
    }
    
    public Turma update(Turma obj) {
        Turma novo = find(obj.getId());
        novo.setAno_turma(obj.getAno_turma());
        return turmaRepository.save(novo);
    }

    public Turma delete(Integer id) {
        Turma Turma = find(id);
        turmaRepository.deleteById(id);
        return Turma;
    }
}
