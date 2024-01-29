package ua.com.kisit2024.course_shop_2024_371_372.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "category")
public class Category {


    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // NN AI
    private Long id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "categories")  // categories->Product
    private List<Product> productList;

}
