package com.example.rest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "fakultas")
@Setter
@Getter
public class Fakultas implements Serializable {
    @Id
    @Column(name="fakultas_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fakultasId;

    @Column(name = "nama_fakultas", nullable = false, length = 40)
    private String namaFakultas;

//    @OneToMany(mappedBy = "id")
//    private List<Jurusan> jurusan;
}
