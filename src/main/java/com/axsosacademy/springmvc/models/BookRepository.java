package com.axsosacademy.springmvc.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByDescriptionContaining(String search);
    List<Book> findByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);

}
