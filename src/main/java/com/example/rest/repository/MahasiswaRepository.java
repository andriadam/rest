package com.example.rest.repository;

import com.example.rest.model.Mahasiswa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    @Query("select c from Mahasiswa c WHERE c.id = :id")
    public Mahasiswa getByID(@Param("id") String id);
    @Query("select c from Mahasiswa c")
    public List<Mahasiswa> getList();

    @Query("select c from Mahasiswa c")
    Page<Mahasiswa> getAllData(Pageable pageable);

    @Modifying
    @Query("delete from Mahasiswa c WHERE c.id =: id")
    List<Mahasiswa> deleteById(@Param("id") String id);
}
