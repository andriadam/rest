package com.example.rest.repository;

import com.example.rest.model.Jurusan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JurusanRepository extends JpaRepository<Jurusan, Long> {
    @Query("select c from Jurusan c WHERE c.id = :id")
    public Jurusan getByID(@Param("id") Long id);
    @Query("select c from Jurusan c")
    public List<Jurusan> getList();

    @Query("select c from Jurusan c")
    Page<Jurusan> getAllData(Pageable pageable);
}
