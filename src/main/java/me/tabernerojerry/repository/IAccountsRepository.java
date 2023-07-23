package me.tabernerojerry.repository;

import me.tabernerojerry.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findByCustomerId(Long customerId);

}
