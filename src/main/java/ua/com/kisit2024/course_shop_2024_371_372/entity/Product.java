package ua.com.kisit2024.course_shop_2024_371_372.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToMany(mappedBy = "_product")
    private List<ProductHasOrder> productHasOrders;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brande brandes;

    @OneToMany(mappedBy = "producte")
    private List<AttributeHasProduct> attributeHasProductes;

}
