package com.jt.springboot2backend.resources;

import java.net.URI;
import java.util.List;

import com.jt.springboot2backend.domain.Boletim;
import com.jt.springboot2backend.services.BoletimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/boletins")
public class BoletimResource {
    
    @Autowired
    private BoletimService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Boletim>> findAll() {
        List<Boletim> boletims = service.findAll();
        return ResponseEntity.ok().body(boletims);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public ResponseEntity<Boletim> insert(@RequestBody Boletim obj, @PathVariable Integer id) {
        Boletim boletim = service.insert(obj, id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(boletim.getId()).toUri();
        return ResponseEntity.created(uri).body(boletim);
    }


    @RequestMapping(method=RequestMethod.POST, value = "/all")
    public ResponseEntity<Boletim> insertAll(@RequestBody Boletim obj) {
        Boletim boletim = service.insertAll(obj);
        return ResponseEntity.ok().body(boletim);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Boletim> update(@RequestBody Boletim obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boletim> delete(@PathVariable Integer id) {
        Boletim Boletim = service.delete(id);
        return ResponseEntity.ok().body(Boletim);
    }

}
