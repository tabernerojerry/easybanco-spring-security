package me.tabernerojerry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
public class Cards {

    @Id
    @SequenceGenerator(
            name = "cards_card_id_seq",
            sequenceName = "cards_card_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cards_card_id_seq")
    @Column(name = "card_id")
    private int cardId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "create_dt")
    private Date createDt;

}
