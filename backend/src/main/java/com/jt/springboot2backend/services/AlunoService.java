package com.jt.springboot2backend.services;

import java.util.List;
import java.util.Optional;

import com.jt.springboot2backend.domain.Aluno;
import com.jt.springboot2backend.repositories.AlunoRepository;
import com.jt.springboot2backend.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno find(Integer id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado id: " + id + ", Tipo: " + Aluno.class.getName()));
    }
    
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno insert(Aluno obj) {
        obj.setCod_matricula(null);
        return alunoRepository.save(obj);
    }
    
    public Aluno update(Aluno obj) {
        Aluno novo = find(obj.getCod_matricula());
        novo.setCpf(obj.getCpf());
        novo.setNome(obj.getNome());
        novo.setDt_nascimento(obj.getDt_nascimento());
        novo.setIdade(obj.getIdade());
        novo.setNome_mae(obj.getNome_mae());
        novo.setNome_pai(obj.getNome_pai());
        novo.setTurma(obj.getTurma());
        return alunoRepository.save(novo);
    }

    public Aluno delete(Integer id) {
        Aluno aluno = find(id);
        alunoRepository.deleteById(id);
        return aluno;
    }

    public void save(Aluno obj) {
        alunoRepository.save(obj);
    }
}
