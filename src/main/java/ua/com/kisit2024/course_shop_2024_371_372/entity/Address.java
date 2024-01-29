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
@Table(name = "_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String builder;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clients _clientes;

}
