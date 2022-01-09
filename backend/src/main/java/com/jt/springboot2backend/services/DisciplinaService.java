package com.jt.springboot2backend.services;

import java.util.List;
import java.util.Optional;

import com.jt.springboot2backend.domain.Disciplina;

import com.jt.springboot2backend.repositories.DisciplinaRepository;
import com.jt.springboot2backend.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    
    @Autowired
    private DisciplinaRepository DisciplinaRepository;

    public Disciplina find(Integer id) {
        Optional<Disciplina> obj = DisciplinaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Disciplina não encontrado id: " + id + ", Tipo: " + Disciplina.class.getName()));
    }
    
    public List<Disciplina> findAll() {
        return DisciplinaRepository.findAll();
    }

    public Disciplina insert(Disciplina obj) {
        obj.setId(null);
        System.out.println("professor id: " + obj.getProfessor());
        return DisciplinaRepository.save(obj);
    }
    
    public Disciplina update(Disciplina obj) {
        Disciplina novo = find(obj.getId());
        novo.setCod_disciplina(obj.getCod_disciplina());
        novo.setNome_disciplina(obj.getNome_disciplina());
        return DisciplinaRepository.save(novo);
    }

    public Disciplina delete(Integer id) {
        Disciplina Disciplina = find(id);
        DisciplinaRepository.deleteById(id);
        return Disciplina;
    }
}
