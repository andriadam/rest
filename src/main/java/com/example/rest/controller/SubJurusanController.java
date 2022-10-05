package com.example.rest.controller;

import com.example.rest.model.Jurusan;
import com.example.rest.model.SubJurusan;
import com.example.rest.service.JurusanService;
import com.example.rest.service.SubJurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SubJurusanController {
    @Autowired
    private SubJurusanService service;

    @PostMapping(value ="/addSubJurusan", consumes = {"application/json"})
    public ResponseEntity<SubJurusan> addSubJurusan(@RequestBody SubJurusan subJurusan) {
        SubJurusan dataSubJurusan = service.createSubJurusan(subJurusan);
        return new ResponseEntity<>(dataSubJurusan, HttpStatus.CREATED);
    }

    @GetMapping("/subjurusan")
    public List<SubJurusan> findAllSubJurusan() {
        return service.getSubJurusan();
    }

    @PutMapping(value ="/subjurusan/{id}", consumes = {"application/json"})
    public ResponseEntity<SubJurusan> updateJurusan(@PathVariable Long id, @RequestBody SubJurusan subJurusan) {
        SubJurusan dataSubJurusan = service.updateSubJurusan(id, subJurusan);
        return new ResponseEntity<>(dataSubJurusan, HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/subjurusan/{id}")
    public String deleteSubJurusan(@PathVariable Long id) {
        return service.deleteSubJurusan(id);
    }
}
