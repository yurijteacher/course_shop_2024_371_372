package ua.com.kisit2024.course_shop_2024_371_372.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
    private Date dateCreated;
    private boolean status;
    private String delivery;
    private String payment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Clients cliente;

    @OneToMany(mappedBy = "_order")
    private List<ProductHasOrder>  productHasOrders;

}
