package com.sb.graphqlbootstrap.repository;

import org.springframework.data.repository.CrudRepository;
import com.sb.graphqlbootstrap.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
