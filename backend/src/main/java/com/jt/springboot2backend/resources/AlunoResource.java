package com.jt.springboot2backend.resources;

import java.net.URI;
import java.util.List;

import com.jt.springboot2backend.domain.Aluno;
import com.jt.springboot2backend.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
    
    @Autowired
    private AlunoService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Aluno> find(@PathVariable Integer id) {
        Aluno aluno = service.find(id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunos = service.findAll();
        return ResponseEntity.ok().body(alunos);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Aluno> insert(@RequestBody Aluno obj) {
        Aluno aluno = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getCod_matricula()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }


    @CrossOrigin
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Aluno> update(@RequestBody Aluno obj, @PathVariable Integer id) {
        obj.setCod_matricula(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Aluno> delete(@PathVariable Integer id) {
        Aluno aluno = service.delete(id);
        return ResponseEntity.ok().body(aluno);
    }

}
