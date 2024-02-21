package com.Troquei.troquei.entity.Quality;

import com.Troquei.troquei.entity.Clothes.Clothes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "QUALITY")
public class Quality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "quality")
    private List<Clothes> clothes;
}
