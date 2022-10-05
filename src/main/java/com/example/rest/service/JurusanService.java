package com.example.rest.service;

import com.example.rest.model.Jurusan;
import com.example.rest.repository.FakultasRepository;
import com.example.rest.repository.JurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JurusanService {
    @Autowired
    JurusanRepository jurusanRepository;

    @Autowired
    FakultasRepository fakultasRepository;

    // CREATE
    public Jurusan createJurusan(Jurusan jurusan) {
        Jurusan result = new Jurusan();
        try {
            result = jurusanRepository.save(jurusan);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // READ
    public List<Jurusan> getJurusan() {
        List<Jurusan> result = jurusanRepository.findAll();
        for (Jurusan j: result ) {
            j.setFakultas(fakultasRepository.findById(j.getFakultasId() == null ? null : j.getFakultasId()).orElse(null));
        }
        return result;
    }

    // DELETE
    public String deleteJurusan(Long id) {
        jurusanRepository.deleteById(id);
        return "Removed !! " + id;
    }

    // UPDATE
    public Jurusan updateJurusan(Long id, Jurusan jurusanDetails) {
        Jurusan jurusan = jurusanRepository.findById(id).orElse(null);
        assert jurusan != null;
        jurusan.setFakultas(fakultasRepository.findById(jurusan.getFakultasId()).orElse(null));
        jurusan.setNamaJurusan(jurusanDetails.getNamaJurusan());
        return jurusanRepository.save(jurusan);
    }
}
