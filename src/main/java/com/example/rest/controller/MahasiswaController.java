package com.example.rest.controller;

import com.example.rest.model.Mahasiswa;
import com.example.rest.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class MahasiswaController {
    @Autowired
    private MahasiswaService service;

    @PostMapping(value ="/addMahasiswa", consumes = {"application/json"})
    public ResponseEntity<Mahasiswa> addMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        Mahasiswa dataMahasiswa = service.createMahasiswa(mahasiswa);
        return new ResponseEntity<>(dataMahasiswa, HttpStatus.CREATED);
    }

    @GetMapping("/mahasiswa")
    public List<Mahasiswa> findAllMahasiswa() {
        return service.getMahasiswa();
    }

    @PutMapping(value ="/mahasiswa/{id}", consumes = {"application/json"})
    public ResponseEntity<Mahasiswa> updateMahasiswa(@PathVariable String id, @RequestBody Mahasiswa mahasiswa) {
        Mahasiswa dataMahasiswa = service.updateMahasiswa(id, mahasiswa);
        return new ResponseEntity<>(dataMahasiswa, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/mahasiswa/{id}")
    public String deleteMahasiswa(@PathVariable String id) {
        return service.deleteMahasiswa(id);
    }
}
