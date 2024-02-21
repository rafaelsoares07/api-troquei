package com.Troquei.troquei.entity.Clothes;

import com.Troquei.troquei.entity.Category.Category;
import com.Troquei.troquei.entity.Quality.Quality;
import com.Troquei.troquei.entity.Size.Size;
import jakarta.persistence.*;

@Entity
@Table(name = "CLOTHES")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "quality_id")
    private Quality quality;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String description;

}
