package com.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rest.model.Fakultas;
import com.example.rest.repository.FakultasRepository;
import java.util.List;

@Service
public class FakultasService {
    @Autowired
    FakultasRepository fakultasRepository;

    // CREATE
    public List<Fakultas> createFakultas(Fakultas fakultas) {
        fakultasRepository.save(fakultas);
        return fakultasRepository.findAll();
    }

    // READ
    public List<Fakultas> getFakultas() {
        return fakultasRepository.findAll();
    }

    // DELETE
    public String deleteFakultas(Long id) {
        fakultasRepository.deleteById(id);
        return "Removed !! " + id;
    }

    // UPDATE
    public Fakultas updateFakultas(Long id, Fakultas fakultasDetails) {
        Fakultas fakultas = fakultasRepository.findById(id).get();
        System.out.println("IDDDD "+ fakultas);
        fakultas.setNamaFakultas(fakultasDetails.getNamaFakultas());

        return fakultasRepository.save(fakultas);
    }
}
