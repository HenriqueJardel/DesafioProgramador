package com.jt.springboot2backend.resources;

import java.net.URI;
import java.util.List;

import com.jt.springboot2backend.domain.Turma;
import com.jt.springboot2backend.services.TurmaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {
    
    @Autowired
    private TurmaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Turma>> findAll() {
        List<Turma> turmas = service.findAll();
        return ResponseEntity.ok().body(turmas);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Turma> insert(@RequestBody Turma obj) {
        Turma turma = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turma.getId()).toUri();
        return ResponseEntity.created(uri).body(turma);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Turma> update(@RequestBody Turma obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Turma> delete(@PathVariable Integer id) {
        Turma Turma = service.delete(id);
        return ResponseEntity.ok().body(Turma);
    }
}
