package com.sb.graphqlbootstrap.repository;

import org.springframework.data.repository.CrudRepository;
import com.sb.graphqlbootstrap.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
