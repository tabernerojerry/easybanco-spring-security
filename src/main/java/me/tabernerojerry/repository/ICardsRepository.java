package me.tabernerojerry.repository;

import me.tabernerojerry.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);

}
