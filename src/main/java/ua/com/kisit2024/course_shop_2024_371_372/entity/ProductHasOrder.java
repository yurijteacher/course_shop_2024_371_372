package ua.com.kisit2024.course_shop_2024_371_372.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product_has_order")
public class ProductHasOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product _product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order _order;

    private int quantity;
}
