package com.example.rest.service;

import com.example.rest.model.SubJurusan;
import com.example.rest.repository.JurusanRepository;
import com.example.rest.repository.SubJurusanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubJurusanService {
    @Autowired
    SubJurusanRepository subJurusanRepository;

    @Autowired
    JurusanRepository jurusanRepository;

    // CREATE
    public SubJurusan createSubJurusan(SubJurusan subJurusan) {
        SubJurusan result = new SubJurusan();
        try {
            result = subJurusanRepository.save(subJurusan);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // READ
    public List<SubJurusan> getSubJurusan() {
        List<SubJurusan> result = subJurusanRepository.findAll();
        for (SubJurusan j: result ) {
            j.setJurusan(jurusanRepository.findById(j.getJurusanId() == null ? null : j.getJurusanId()).orElse(null));
        }
        return result;
    }

    // DELETE
    public String deleteSubJurusan(Long id) {
        subJurusanRepository.deleteById(id);
        return "Removed !! " + id;
    }

    // UPDATE
    public SubJurusan updateSubJurusan(Long id, SubJurusan subJurusanDetails) {
        SubJurusan subJurusan = subJurusanRepository.findById(id).orElse(null);
        assert subJurusan != null;
        subJurusan.setJurusan(jurusanRepository.findById(subJurusan.getJurusanId()).orElse(null));
        subJurusan.setNamaSubJurusan(subJurusanDetails.getNamaSubJurusan());
        return subJurusanRepository.save(subJurusan);
    }
}
