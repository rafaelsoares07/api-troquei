package com.Troquei.troquei.entity.Size;

import com.Troquei.troquei.entity.Clothes.Clothes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SIZES")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String size;

    @OneToMany(mappedBy = "size")
    private List<Clothes> clothes;
}
