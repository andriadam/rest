package com.example.rest.model;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name = "jurusan")
public class Jurusan implements Serializable {
    @Id
    @Column(name="jurusan_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jurusanId;

    @Column(name = "fakultas_id", nullable = false, length = 10)
    private Long fakultasId;

    @Column(name = "nama_jurusan", nullable = false, length = 40)
    private String namaJurusan;

    @Column(columnDefinition = "BLOB")
    private Fakultas fakultas;
}
