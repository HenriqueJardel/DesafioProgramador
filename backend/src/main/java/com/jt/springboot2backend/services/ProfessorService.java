package com.jt.springboot2backend.services;

import java.util.List;
import java.util.Optional;

import com.jt.springboot2backend.domain.Professor;
import com.jt.springboot2backend.repositories.ProfessorRepository;
import com.jt.springboot2backend.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor find(Integer id) {
        Optional<Professor> obj = professorRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado id: " + id + ", Tipo: " + Professor.class.getName()));
    }
    
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor insert(Professor obj) {
        obj.setId(null);
        return professorRepository.save(obj);
    }
    
    public Professor update(Professor obj) {
        Professor novo = find(obj.getId());
        novo.setNome(obj.getNome());
        novo.setFormacao(obj.getFormacao());
        novo.setArea_atuacao(obj.getArea_atuacao());
        return professorRepository.save(novo);
    }

    public Professor delete(Integer id) {
        Professor Professor = find(id);
        professorRepository.deleteById(id);
        return Professor;
    }
}
