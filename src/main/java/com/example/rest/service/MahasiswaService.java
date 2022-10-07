package com.example.rest.service;

import com.example.rest.model.Jurusan;
import com.example.rest.model.Mahasiswa;
import com.example.rest.repository.MahasiswaRepository;
import com.example.rest.repository.SubJurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MahasiswaService {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Autowired
    SubJurusanRepository subJurusanRepository;

    // CREATE
    public Mahasiswa createMahasiswa(Mahasiswa mahasiswa) {
        Mahasiswa result = new Mahasiswa();
        try {
            result = mahasiswaRepository.save(mahasiswa);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // READ
    public List<Mahasiswa> getMahasiswa() {
        List<Mahasiswa> result = mahasiswaRepository.findAll();
        for (Mahasiswa j: result ) {
            j.setSubJurusan(subJurusanRepository.findById(j.getSubJurusanId() == null ? null : j.getSubJurusanId()).orElse(null));
        }
        return result;
    }

    // DELETE
    public String deleteMahasiswa(String id) {
        Mahasiswa mahasiswa = mahasiswaRepository.getByID(id);
        mahasiswaRepository.delete(mahasiswa);
        return "Removed !! " + id;
    }

    // UPDATE
    public Mahasiswa updateMahasiswa(String id, Mahasiswa mahasiswaDetails) {
        Mahasiswa mahasiswa = mahasiswaRepository.getByID(id);
        assert mahasiswa != null;
        mahasiswa.setKelas(mahasiswaDetails.getKelas());
        mahasiswa.setNama(mahasiswaDetails.getNama());
        mahasiswa.setSubJurusanId(mahasiswaDetails.getSubJurusanId());
        return mahasiswaRepository.save(mahasiswa);
    }
}
