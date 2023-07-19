package me.tabernerojerry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@ToString
public class Authority {

    @Id
    @SequenceGenerator(
            name = "authorities_id_seq",
            sequenceName = "authorities_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_id_seq")
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
