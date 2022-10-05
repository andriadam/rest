package com.example.rest.repository;

import com.example.rest.model.SubJurusan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubJurusanRepository extends JpaRepository<SubJurusan, Long> {
    @Query("select c from SubJurusan c WHERE c.id = :id")
    public SubJurusan getByID(@Param("id") Long id);
    @Query("select c from SubJurusan c")
    public List<SubJurusan> getList();

    @Query("select c from SubJurusan c")
    Page<SubJurusan> getAllData(Pageable pageable);
}
