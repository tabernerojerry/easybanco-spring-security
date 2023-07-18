package me.tabernerojerry.repository;

import me.tabernerojerry.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends CrudRepository<Contact, Long> {


}
