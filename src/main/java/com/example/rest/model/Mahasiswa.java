package com.example.rest.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa implements Serializable {
    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="nim", nullable = false, length = 10)
    private String id;

    @Column(name = "nama", nullable = false, length = 40)
    private String nama;

    @Column(name = "kelas", nullable = false, length = 40)
    private String kelas;

    @Column(name="sub_jurusan_id", nullable = false, length = 10)
    private Long subJurusanId;

    @Column(columnDefinition = "BLOB")
    private SubJurusan subJurusan;
}
