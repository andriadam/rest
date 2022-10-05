package com.example.rest.repository;

import com.example.rest.model.Fakultas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakultasRepository extends JpaRepository<Fakultas, Long> {

    @Query("select c from Fakultas c WHERE c.id = :id")
    public Fakultas getByID(@Param("id") Long id);
    @Query("select c from Fakultas c")
    public List<Fakultas> getList();

    @Query("select c from Fakultas c")
    Page<Fakultas> getAllData(Pageable pageable);

}