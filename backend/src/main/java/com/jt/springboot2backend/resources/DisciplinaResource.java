package com.jt.springboot2backend.resources;

import java.net.URI;
import java.util.List;

import com.jt.springboot2backend.domain.Disciplina;
import com.jt.springboot2backend.services.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {
    
    @Autowired
    private DisciplinaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Disciplina>> findAll() {
        List<Disciplina> Disciplinas = service.findAll();
        return ResponseEntity.ok().body(Disciplinas);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina obj) {
        Disciplina Disciplina = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Disciplina.getId()).toUri();
        return ResponseEntity.created(uri).body(Disciplina);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Disciplina> update(@RequestBody Disciplina obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Disciplina> delete(@PathVariable Integer id) {
        Disciplina Disciplina = service.delete(id);
        return ResponseEntity.ok().body(Disciplina);
    }
    
}
