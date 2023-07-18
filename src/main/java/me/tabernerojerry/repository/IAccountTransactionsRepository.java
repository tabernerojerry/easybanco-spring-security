package me.tabernerojerry.repository;

import me.tabernerojerry.model.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountTransactionsRepository extends JpaRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
