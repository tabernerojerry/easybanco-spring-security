package me.tabernerojerry.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
public class Accounts {

    @Column(name = "customer_id")
    private int customerId;

    @Id
    @Column(name="account_number")
    private long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private String createDt;

}
