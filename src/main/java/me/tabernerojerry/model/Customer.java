package me.tabernerojerry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customers_id_seq",
            sequenceName = "customers_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    private Integer id;

    private String email;

    private String password;

    private String role;

}
