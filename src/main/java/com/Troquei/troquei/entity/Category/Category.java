package com.Troquei.troquei.entity.Category;

import com.Troquei.troquei.entity.Clothes.Clothes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "category")
    private List<Clothes> clothes;
}

