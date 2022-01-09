package com.jt.springboot2backend.resources;

import java.net.URI;
import java.util.List;

import com.jt.springboot2backend.domain.Professor;
import com.jt.springboot2backend.services.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {
    
    @Autowired
    private ProfessorService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> professores = service.findAll();
        return ResponseEntity.ok().body(professores);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Professor> insert(@RequestBody Professor obj) {
        Professor professor = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(professor);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Professor> update(@RequestBody Professor obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Professor> delete(@PathVariable Integer id) {
        Professor Professor = service.delete(id);
        return ResponseEntity.ok().body(Professor);
    }

}
