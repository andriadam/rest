package com.example.rest.controller;

import com.example.rest.model.Jurusan;
import com.example.rest.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class JurusanController {
    @Autowired
    private JurusanService service;

    @PostMapping(value ="/addJurusan", consumes = {"application/json"})
    public ResponseEntity<Jurusan> addJurusan(@RequestBody Jurusan jurusan) {
        Jurusan dataJurusan = service.createJurusan(jurusan);
        return new ResponseEntity<>(dataJurusan, HttpStatus.CREATED);
    }

    @GetMapping("/jurusan")
    public List<Jurusan> findAllJurusan() {
        return service.getJurusan();
    }

    @PutMapping(value ="/jurusan/{id}", consumes = {"application/json"})
    public ResponseEntity<Jurusan> updateJurusan(@PathVariable Long id, @RequestBody Jurusan jurusan) {
        Jurusan dataJurusan = service.updateJurusan(id, jurusan);
        return new ResponseEntity<>(dataJurusan, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/jurusan/{id}")
    public String deleteJurusan(@PathVariable Long id) {
        return service.deleteJurusan(id);
    }
}
