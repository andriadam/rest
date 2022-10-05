package com.example.rest.controller;

import com.example.rest.model.Fakultas;
import com.example.rest.service.FakultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class FakultasController {
    @Autowired
    private FakultasService service;

    @PostMapping(value ="/addFakultas", consumes = {"application/json"})
    public List<Fakultas> addFakultas(@RequestBody Fakultas fakultas) {
        return service.createFakultas(fakultas);
    }

    @GetMapping("/fakultas")
    public List<Fakultas> findAllFakultas() {
        return service.getFakultas();
    }

    @PutMapping(value ="/fakultas/{id}", consumes = {"application/json"})
    public ResponseEntity<Fakultas> updateFakultas(@PathVariable Long id, @RequestBody Fakultas fakultas) {
        Fakultas dataFakultas = service.updateFakultas(id, fakultas);
        return new ResponseEntity<>(dataFakultas, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/fakultas/{id}")
    public String deleteFakultas(@PathVariable Long id) {
        return service.deleteFakultas(id);
    }
}
