package com.sb.graphqlbootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sb.graphqlbootstrap.error.BookNotFoundException;
import com.sb.graphqlbootstrap.model.Author;
import com.sb.graphqlbootstrap.model.Book;
import com.sb.graphqlbootstrap.repository.AuthorRepository;
import com.sb.graphqlbootstrap.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	/*
	 * the following methods implements the mutation defined into .graphqls files
	 * 	- Author:
	 * 		- newAuthor(firstName: String!, lastName: String!) : Author!
	 * 	- Book:
	 * 		- newBook(title: String!, isbn: String!, pageCount: Int, author: ID!) : Book!
	 * 		- deleteBook(id: ID!) : Boolean
	 * 		- updateBookPageCount(pageCount: Int!, id: ID!) : Book!
	 */
	
	public Author newAuthor(String firstName, String lastName) {
		Author authorToSave = new Author(firstName, lastName);
		authorRepository.save(authorToSave);
		return authorToSave;
	}
	
	public Book newBook(String title, String isbn, Integer pageCount, Long id) {
		Author author = authorRepository.findById(id).get();
		Book bookToSave = new Book(title, isbn, pageCount, author);
		bookRepository.save(bookToSave);
		return bookToSave;
	}
	
	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findById(id).get() != null ? true : false;
	}
	
	public Book updateBookPageCount(Integer newPageCount, Long id) {
		Book bookToUpdate = bookRepository.findById(id).get();
		if (bookToUpdate == null) {
			throw new BookNotFoundException("The book you desire to update could not be found into the database.", id);
		}
		bookToUpdate.setPageCount(newPageCount);
		bookRepository.save(bookToUpdate);
		return bookToUpdate;
	}

}
