package com.example.rest.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "subjurusan")
public class SubJurusan implements Serializable {
    @Id
    @Column(name="sub_jurusan_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subJurusanId;

    @Column(name = "jurusan_id", nullable = false, length = 10)
    private Long jurusanId;

    @Column(name = "nama_sub_jurusan", nullable = false, length = 40)
    private String namaSubJurusan;

    @Column(columnDefinition = "BLOB")
    private Jurusan jurusan;
}
