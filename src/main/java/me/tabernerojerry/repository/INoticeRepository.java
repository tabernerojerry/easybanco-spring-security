package me.tabernerojerry.repository;

import me.tabernerojerry.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INoticeRepository extends CrudRepository<Notice, Long> {

    @Query(value = "from Notice n where NOW() BETWEEN noticBegDt AND noticEndDt")
    List<Notice> findAllActiveNotices();

}
