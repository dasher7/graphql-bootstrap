package com.sb.graphqlbootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.sb.graphqlbootstrap.model.Author;
import com.sb.graphqlbootstrap.model.Book;
import com.sb.graphqlbootstrap.repository.AuthorRepository;
import com.sb.graphqlbootstrap.repository.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query implements GraphQLQueryResolver {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	/*
	 * the following methods implements the query defined into .graphqls file
	 * 	- Author:
	 * 		- findAllAuthors
	 * 		- countAuthors
	 * 	- Book:
	 * 		- findAllBooks
	 * 		- countBooks
	 */
	
	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}
	
	public long countAuthors() {
		return authorRepository.count();
	}
	
	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public long countBooks() {
		return bookRepository.count();
	}

}
