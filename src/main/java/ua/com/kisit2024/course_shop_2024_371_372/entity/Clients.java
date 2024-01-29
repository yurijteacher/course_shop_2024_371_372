package ua.com.kisit2024.course_shop_2024_371_372.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients")
public class Clients {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // NN AI
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email;
    private int phone;
    private int age;

    @OneToOne
    @MapsId
    @MapKey
    @JoinColumn(name = "id")
    private Users user;

    @OneToMany(mappedBy = "cliente")
    private List<Order> orderList;

    @OneToMany(mappedBy = "_clientes")
    private List<Address> addresses;
}
